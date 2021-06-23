package br.silveira.tms.view.orderMng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import br.silveira.tms.converter.SearchViewConverters;
import br.silveira.tms.svc.transportOrder.ctr.TransportOrderCtr;
import br.silveira.tms.svc.transportOrder.dto.TransportOrderDto;
import br.silveira.tms.view.CommonView;
import lombok.Getter;
import lombok.Setter;

@RequestScope
public class OrderMngView extends CommonView{
	
	@Getter @Setter
	private OrderMngSearchView searchView;
	
	@Getter
	private List<TransportOrderDto> transportOrdersHeader;
	
	@Autowired
	private TransportOrderCtr transportOrderCtr;
	
	
	public void search() {
		transportOrdersHeader = transportOrderCtr.findTransportOrderHeader(SearchViewConverters.convertToTransOrderSearchDto(searchView));
	}
	
	

}
