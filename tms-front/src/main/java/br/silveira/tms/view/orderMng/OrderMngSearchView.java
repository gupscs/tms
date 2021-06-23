package br.silveira.tms.view.orderMng;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class OrderMngSearchView {
	
	private String listTo;
	
	private List<LocalDate> etd;

}
