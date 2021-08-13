package br.silveira.tms.excel;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExcelLayout {
	
	public static int STRING = 0;
	public static int DOUBLE = 1;
	public static int INTEGER = 2;
	public static int DATE = 3;
	
	private Integer position;
	
	private String fieldName;
	
	private int cellType;

}
