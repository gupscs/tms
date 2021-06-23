package br.silveira.tms.svc.transportOrder.ctr;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.silveira.tms.svc.transportOrder.dto.TransportOrderDto;
import br.silveira.tms.svc.transportOrder.dto.TransportOrderItemDto;
import br.silveira.tms.svc.transportOrder.dto.TransportOrderSearchDto;

@FeignClient(name = "tms-transport-order" , url = "http://localhost:8081/" )
public interface TransportOrderCtr {
	
	@GetMapping
	public List<TransportOrderDto> findTransportOrderHeader(TransportOrderSearchDto search);
	
	@GetMapping
	public List<TransportOrderDto> findTransportOrderWithItem(TransportOrderSearchDto search);
	
	@GetMapping
	public List<TransportOrderItemDto> findTransportOrderItemById(TransportOrderSearchDto search);
	
	@PostMapping
	public void saveTransportOrder(TransportOrderDto dto);
	
}
