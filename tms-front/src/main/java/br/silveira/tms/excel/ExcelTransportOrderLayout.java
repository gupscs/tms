package br.silveira.tms.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.silveira.tms.excel.dto.ExcelTransportOrderDto;

public class ExcelTransportOrderLayout {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	private static List<ExcelLayout> LAYOUT = Arrays.asList(ExcelLayout.builder().position(0).fieldName("companyCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(1).fieldName("branchCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(2).fieldName("toNo").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(3).fieldName("refNo").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(4).fieldName("customerPoNo").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(5).fieldName("orderTypeCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(6).fieldName("etd").cellType(ExcelLayout.DATE).build(),
															ExcelLayout.builder().position(7).fieldName("eta").cellType(ExcelLayout.DATE).build(),
															ExcelLayout.builder().position(8).fieldName("shipTypeCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	9	).fieldName("shipperCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	10	).fieldName("shipperFederalId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	11	).fieldName("shipperStateId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	12	).fieldName("shipperNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	13	).fieldName("shipperAddress").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	14	).fieldName("shipperDistrict").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	15	).fieldName("shipperZipcode").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	16	).fieldName("shipperCityCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	17	).fieldName("shipperCityNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	18	).fieldName("shipperStateCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	19	).fieldName("shipperStateNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	20	).fieldName("shipperCountryCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	21	).fieldName("shipperCountryNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	22	).fieldName("shipperTrZoneCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	23	).fieldName("shipperEmail").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	24	).fieldName("shipperLatitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	25	).fieldName("shipperLongitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	26	).fieldName("sourceCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	27	).fieldName("sourceFederalId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	28	).fieldName("sourceStateId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	29	).fieldName("sourceNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	30	).fieldName("sourceAddress").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	31	).fieldName("sourceDistrict").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	32	).fieldName("sourceZipcode").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	33	).fieldName("sourceCityCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	34	).fieldName("sourceCityNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	35	).fieldName("sourceStateCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	36	).fieldName("sourceStateNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	37	).fieldName("sourceCountryCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	38	).fieldName("sourceCountryNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	39	).fieldName("sourceTrZoneCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	40	).fieldName("sourceToEmail").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	41	).fieldName("sourceLatitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	42	).fieldName("sourceLongitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	43	).fieldName("customerCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	44	).fieldName("customerFederalId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	45	).fieldName("customerStateId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	46	).fieldName("customerNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	47	).fieldName("customerAddress").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	48	).fieldName("customerDistrict").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	49	).fieldName("customerZipcode").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	50	).fieldName("customerCityCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	51	).fieldName("customerCityNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	52	).fieldName("customerStateCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	53	).fieldName("customerStateNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	54	).fieldName("customerCountryCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	55	).fieldName("customerCountryNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	56	).fieldName("customerTrZoneCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	57	).fieldName("customerToEmail").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	58	).fieldName("customerLatitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	59	).fieldName("customerLongitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	60	).fieldName("shipToCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	61	).fieldName("shipToFederalId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	62	).fieldName("shipToStateId").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	63	).fieldName("shipToNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	64	).fieldName("shipToAddress").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	65	).fieldName("shipToDistrict").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	66	).fieldName("shipToZipcode").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	67	).fieldName("shipToCityCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	68	).fieldName("shipToCityNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	69	).fieldName("shipToStateCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	70	).fieldName("shipToStateNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	71	).fieldName("shipToCountryCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	72	).fieldName("shipToCountryNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	73	).fieldName("shipToTrZoneCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	74	).fieldName("shipToEmail").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	75	).fieldName("shipToLatitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	76	).fieldName("shipToLongitude").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	77	).fieldName("totalVolume").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	78	).fieldName("totalWeight").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	79	).fieldName("totalAmount").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	80	).fieldName("totalAmountTax").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	81	).fieldName("currency").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	82	).fieldName("itemNo").cellType(ExcelLayout.INTEGER).build(),
															ExcelLayout.builder().position(	83	).fieldName("refItemNo").cellType(ExcelLayout.INTEGER).build(),
															ExcelLayout.builder().position(	84	).fieldName("itemCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	85	).fieldName("itemNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	86	).fieldName("itemEan").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	87	).fieldName("itemGroupCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	88	).fieldName("itemGroupNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	89	).fieldName("itemCategoryCd").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	90	).fieldName("itemCategoryNm").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	91	).fieldName("itemQty").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	92	).fieldName("qtyUnit").cellType(ExcelLayout.STRING).build(),
															ExcelLayout.builder().position(	93	).fieldName("itemDimWidth").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	94	).fieldName("itemDimHeight").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	95	).fieldName("itemDimDeep").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	96	).fieldName("itemVolume").cellType(ExcelLayout.DOUBLE).build(),
															ExcelLayout.builder().position(	97	).fieldName("itemWeight").cellType(ExcelLayout.DOUBLE).build()


												);

	
	
	public static List<ExcelTransportOrderDto> readExcel(XSSFWorkbook excel){
		List<Map<String, Object>> rows = getRows(excel);
		List<ExcelTransportOrderDto> dto = rows.stream().map(row -> mapper.convertValue(row, ExcelTransportOrderDto.class)).collect(Collectors.toList());
		return dto;
	}



	private static List<Map<String, Object>> getRows(XSSFWorkbook excel) {
		List<Map<String, Object>> excelList = new ArrayList<Map<String, Object>>();
		XSSFSheet sheet = excel.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		for(int rowCnt = 1 ; rowCnt <= lastRowNum ; rowCnt++) {
			Boolean hasValueInRow = false;
			XSSFRow row = sheet.getRow(rowCnt);
			if(row == null) continue;
			Map<String, Object> rowMap = new HashMap<String, Object>();
			rowMap.put("excelLine", rowCnt + 1);
			for (ExcelLayout excelLayout : LAYOUT) {
				if(ExcelUtil.isNotEmptyCell(row.getCell(excelLayout.getPosition()))) {
					hasValueInRow = true;
					rowMap.put(excelLayout.getFieldName(),ExcelUtil.getCellValue(excelLayout, row));
				}
			}
			
			if(hasValueInRow) {
				excelList.add(rowMap);
			}
		}
		return excelList;
	}

}
