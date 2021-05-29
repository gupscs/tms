package br.silveira.tms.converter;

import java.util.List;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import br.silveira.tms.dto.MenuDto;

public class MenuViewConverter {
	
	
	public static DefaultMenuModel converterMenuDtoForModel(List<MenuDto> listMenus) {
		DefaultMenuModel menuModel = new DefaultMenuModel();

		for (MenuDto menuDto : listMenus) {
			DefaultSubMenu fatherMenu = DefaultSubMenu.builder().label(menuDto.getMenuName()).build();
			fatherMenu = createSubMenus(menuDto.getSubMenus(), fatherMenu);
			menuModel.getElements().add(fatherMenu);
		}

		return menuModel;
	}

	private static DefaultSubMenu createSubMenus(List<MenuDto> subMenus, DefaultSubMenu fatherMenu) {
		for (MenuDto menuDto : subMenus) {
			if (menuDto.isMainMenu()) {
				DefaultSubMenu fatherSonMenu = DefaultSubMenu.builder().label(menuDto.getMenuName()).build();
				fatherSonMenu = createSubMenus(menuDto.getSubMenus(), fatherSonMenu);
				fatherMenu.getElements().add(fatherSonMenu);
			} else {
				DefaultMenuItem item = DefaultMenuItem.builder().value(menuDto.getMenuName()).ajax(true)
						.command("#{menuView.openTabMenuContent(" + menuDto.getMenuId() + ")}")
						//TODO IMPLEMENTAR NO FUTURO .icon("pi pi-save")
						.update("@obs(eventTabMainContentUpdate)")
						.build();
				fatherMenu.getElements().add(item);
			}
		}

		return fatherMenu;
	}

}
