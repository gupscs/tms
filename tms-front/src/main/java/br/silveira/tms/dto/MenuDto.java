package br.silveira.tms.dto;

import java.math.BigInteger;
import java.util.List;

import lombok.Data;

@Data
public class MenuDto {

	private BigInteger menuId;
	
	private String menuName;
	
	private String menuUrl;
	
	private Integer menuOrder;
	
	private List<MenuDto> subMenus;

	public MenuDto(BigInteger menuId, String menuName, String menuUrl, Integer menuOrder, List<MenuDto> subMenus) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuOrder = menuOrder;
		this.subMenus = subMenus;
	}
	
	public MenuDto() {}
	
	public boolean isMainMenu() {
		return menuUrl == null || menuUrl.isEmpty();
	}
	
	
}
