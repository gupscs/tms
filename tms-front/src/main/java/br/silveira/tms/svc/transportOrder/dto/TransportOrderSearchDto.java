package br.silveira.tms.svc.transportOrder.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TransportOrderSearchDto {
	
	private Long companyId;
	
	private Long branchId;
	
	private Boolean actived;
	
	private Date insertDt;
	
	private List<String> toNo;
	
	private LocalDate startEtd;
	
	private LocalDate endEtd;
	
	private Long transportOrderId;
	
}
