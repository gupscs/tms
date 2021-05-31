package br.silveira.tms.view;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.TabCloseEvent;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

import br.silveira.tms.converter.MenuViewConverter;
import br.silveira.tms.dto.MenuDto;
import br.silveira.tms.dto.MenuTabDto;
import br.silveira.tms.svc.system.MenuSvc;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class MenuView extends CommonView {

	@Autowired
	private MenuSvc menuSvc;

	private List<MenuDto> listMenus;

	@Getter
	private MenuModel menuModel;

	@Getter
	private List<MenuTabDto> listMenuOpen;
	
	@Getter 
	@Setter
	private Integer tabActiveIndex;

	@PostConstruct
	public void init() {
		listMenus = menuSvc.getMenuByUserId(getUserDto().getUserId());
		menuModel = MenuViewConverter.converterMenuDtoForModel(listMenus);
		listMenuOpen = new ArrayList<MenuTabDto>();
		listMenuOpen.add(MenuTabDto.builder()
				.menuId(BigInteger.ZERO)
				.menuName("Home")
				.menuUrl("/pages/home/home-content.xhtml")
				.closable(false)
				.build());
		tabActiveIndex = 0;
	}

    @SuppressWarnings("rawtypes")
	public void onTabClose(TabCloseEvent event) {
    	BigInteger menuId = new BigInteger(event.getTab().getAriaLabel());
    	
    	int idxRemove = 0;
    	for (int i = 0; i < listMenuOpen.size(); i++) {
			if(listMenuOpen.get(i).getMenuId().compareTo(menuId)==0) {
				idxRemove = i;
				break;
			}
		}
    	listMenuOpen.remove(idxRemove);
    	tabActiveIndex = idxRemove - 1;
    }

	public void openTabMenuContent(BigInteger menuId) {
		Integer indexTab = getTabActiveIndexByMenuId(menuId);
		if(indexTab.compareTo(-1) == 0) {
			MenuDto menuSelected = getMenuByMenuId(listMenus, menuId );
			listMenuOpen.add(MenuTabDto.builder()
					.menuId(menuSelected.getMenuId())
					.menuName(menuSelected.getMenuName())
					.menuUrl(menuSelected.getMenuUrl())
					.closable(true)
					.build());
			tabActiveIndex = (listMenuOpen.size() - 1);
		}else {
			tabActiveIndex = indexTab;
		}
	}

	private Integer getTabActiveIndexByMenuId(BigInteger menuId) {
		for (int i = 0; i < listMenuOpen.size(); i++) {
			if(listMenuOpen.get(i).getMenuId().compareTo(menuId)==0) {
				return i;
			}			
		}
		return -1;
	}
	
	private MenuDto getMenuByMenuId(List<MenuDto> menusDto , BigInteger menuId) {
		
		for (MenuDto dto : menusDto) {
			if(dto.getMenuId().compareTo(menuId) == 0) {
				return dto;
			}else if(dto.isMainMenu()) {
				MenuDto retRec = getMenuByMenuId(dto.getSubMenus(), menuId);
				if(retRec != null) {
					return retRec;
				}
			}
		}
		return null;
		
	}


	

}
