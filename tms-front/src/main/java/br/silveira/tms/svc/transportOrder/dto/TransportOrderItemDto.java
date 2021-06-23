package br.silveira.tms.svc.transportOrder.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class TransportOrderItemDto {
	
	private Long id;
	
	private TransportOrderDto transportOrder;
	
	private Integer version;
	
	private Long companyId;
	
	private Long branchId;
	
	private String insertUserId;
	
	private Date insertDt;
	
	private String updateUserId;
	
	private Date updatetDt;
	
	private Boolean actived;
	
	private String toNo;

	private Integer itemNo;

	private String refNo;
	
	private String refItemNo;
	
	private String itemCd;
	
	private String itemNm;
	
	private String itemEan;
	
	private String itemGroupCd;
	
	private String itemGroupNm;
	
	private String itemCategoryCd;
	
	private String itemCategoryNm;
	
	private BigDecimal itemQty;
	
	private String qtyUnit;
	
	private BigDecimal itemDimWidth;
	
	private BigDecimal itemDimHeight;
	
	private BigDecimal itemDimDeep;
	
	private String dimUnit;
	
	private BigDecimal itemVolume;
	
	private String volumeUnit;
	
	private BigDecimal itemWeight;
	
	private String weightUnit;
	
	private BigDecimal itemAmount;
	
	private BigDecimal itemAmountTax;
	
	private String currency;

}
