package br.silveira.tms.svc.system.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.silveira.tms.dto.MenuDto;
import br.silveira.tms.svc.system.MenuSvc;

@Service
public class MenuSvcMkpImpl implements MenuSvc {

	@Override
	public List<MenuDto> getMenuByUserId(BigInteger userId) {
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		List<MenuDto> subOrder = new ArrayList<MenuDto>();
		MenuDto orderMng = new MenuDto(new BigInteger("2"), "Order Management", "/pages/order-mng/order-mng.xhtml" , 2100, null); 		
		subOrder.add(orderMng);
		MenuDto orderHeader = new MenuDto(new BigInteger("1"), "Orders", "", 2000, subOrder);	
		menuList.add(orderHeader);	
		return menuList;
	}

}
