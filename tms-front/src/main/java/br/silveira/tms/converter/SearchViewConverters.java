package br.silveira.tms.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import br.silveira.tms.svc.transportOrder.dto.TransportOrderSearchDto;
import br.silveira.tms.view.orderMng.OrderMngSearchView;

public class SearchViewConverters {
	
	public static TransportOrderSearchDto convertToTransOrderSearchDto(OrderMngSearchView view) {
		TransportOrderSearchDto dto = new TransportOrderSearchDto();
		String[] toList = view.getListTo().split("\\n");
		dto.setToNo(Arrays.asList(toList));
		if(Optional.ofNullable(view.getEtd()).isPresent()) {
			dto.setStartEtd(view.getEtd().get(0));
			dto.setEndEtd(view.getEtd().get(1));
		}
		
		return dto;
	}

}
