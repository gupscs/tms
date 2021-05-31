package br.silveira.tms.view.orderMng;

import java.util.Date;
import java.util.List;

import br.silveira.tms.view.CommonView;
import lombok.Getter;
import lombok.Setter;

public class OrderMngSearchView extends CommonView{
	
	@Getter @Setter
	private List<String> listTransportOrder;
	
	@Getter @Setter
	private List<Date> rangeCreateDate;

}
