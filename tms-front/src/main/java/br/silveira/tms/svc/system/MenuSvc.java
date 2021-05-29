package br.silveira.tms.svc.system;

import java.math.BigInteger;
import java.util.List;

import br.silveira.tms.dto.MenuDto;

public interface MenuSvc {
	
	public List<MenuDto> getMenuByUserId(BigInteger userId);

}
