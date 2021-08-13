package br.silveira.tms.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.silveira.tms.excel.dto.ExcelTransportOrderDto;
import br.silveira.tms.svc.transportOrder.dto.TransportOrderDto;
import br.silveira.tms.svc.transportOrder.dto.TransportOrderItemDto;

public class ExcelConverter {
	
	private static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;

	public static List<TransportOrderDto> excelTransportOrderDtoConverter(List<ExcelTransportOrderDto> excelTransportOrderDto) {
		List<TransportOrderDto> ret = new ArrayList<TransportOrderDto>();
		Map<String, List<ExcelTransportOrderDto>> map = new HashMap<String, List<ExcelTransportOrderDto>>();
		for (ExcelTransportOrderDto dto : excelTransportOrderDto) {
			if(!map.containsKey(dto.getToNo())) {
				map.put(dto.getToNo(), new ArrayList<ExcelTransportOrderDto>());
			}
			map.get(dto.getToNo()).add(dto);
		}
		
		for (String key : map.keySet()) {
			TransportOrderDto retDto = mapper.convertValue(map.get(key).get(0), TransportOrderDto.class);
			List<TransportOrderItemDto> items = new ArrayList<TransportOrderItemDto>();
			for (ExcelTransportOrderDto item : map.get(key)) {
				items.add(mapper.convertValue(item, TransportOrderItemDto.class));
			}
			retDto.setTransportOrderItems(items);
			ret.add(retDto);
		}
		
		return ret;
	}

}
