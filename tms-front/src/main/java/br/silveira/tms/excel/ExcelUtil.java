package br.silveira.tms.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelUtil {
	

	public static boolean isNotEmptyCell(XSSFCell cell) {
		if(cell == null) {
			return false;
		}
		if(cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
			return false;
		}
		
		return true;
	}

	public static Object getCellValue(ExcelLayout excelLayout, XSSFRow row) {
		Object ret = null;
		XSSFCell cell = row.getCell(excelLayout.getPosition());
		
		if(excelLayout.getCellType() == ExcelLayout.STRING) {
			if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				Double numericCellValue = cell.getNumericCellValue();
				ret =  numericCellValue.toString();
			}else {
				ret =  cell.getStringCellValue();
			}
		}else if(excelLayout.getCellType() == ExcelLayout.INTEGER) {
			if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				double numericCellValue = cell.getNumericCellValue();
				Integer IntValue = (int) Math.round(numericCellValue);
				ret =  IntValue;
			}else {
				String stringCellValue = cell.getStringCellValue();
				if(stringCellValue.contains(".") || stringCellValue.contains(",")) {
					stringCellValue = stringCellValue.replaceAll(",", ".").split(".")[0];
				}
				ret =  Integer.parseInt(stringCellValue);
			}
		}else if(excelLayout.getCellType() == ExcelLayout.DOUBLE) {
			if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				ret =  cell.getNumericCellValue();
			}else {
				String stringCellValue = cell.getStringCellValue();
				ret =  Double.parseDouble(stringCellValue);
			}
		}else if(excelLayout.getCellType() == ExcelLayout.DATE) {
			ret =  cell.getDateCellValue();
		}else {
			ret =  cell.getStringCellValue();
		}
		
		return ret;
	}
}
