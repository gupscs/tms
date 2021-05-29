package br.silveira.tms.dto;

import java.math.BigInteger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuTabDto {

	private BigInteger menuId;
	
	private String menuName;
	
	private String menuUrl;
	
	private boolean closable;	
	
}
