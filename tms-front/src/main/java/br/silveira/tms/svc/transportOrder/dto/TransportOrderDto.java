package br.silveira.tms.svc.transportOrder.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TransportOrderDto{
	
	private Long id;
	
	private Integer version;
	
	private Long companyId;
	
	private Long branchId;
	
	private String insertUserId;
	
	private Date insertDt;
	
	private String updateUserId;
	
	private Date updatetDt;
	
	private Boolean actived;
	
	private String toNo;
		
	private String refNo;
	
	private String customerPoNo;
	
	private String orderTypeCd;
	
	private String orderTypeNm;
		
	private Date etd;
	
	private Date eta;
	
	private String shipTypeCd;
	
	private String shipTypeNm;
	
	private String statusCd;
	
	private String subStatusCd;
	
	private Boolean partialStatus;
	
	private Boolean blocked;
	
	private String shipperCd;
	
	private String shipperFederalId;
	
	private String shipperStateId;
	
	private String shipperNm;
	
	private String shipperAddress;
	
	private String shipperDistrict;
	
	private String shipperZipcode;
	
	private String shipperCityCd;
	
	private String shipperCityNm;
	
	private String shipperStateCd;
	
	private String shipperStateNm;
	
	private String shipperCountryCd;
	
	private String shipperCountryNm;
	
	private String shipperTrZoneCd;
	
	private String shipperEmail;
	
	private BigDecimal shipperLatitude;
	
	private BigDecimal shipperLongitude;
	
	private String sourceCd;
	
	private String sourceFederalId;
	
	private String sourceStateId;
	
	private String sourceNm;
	
	private String sourceAddress;
	
	private String sourceDistrict;
	
	private String sourceZipcode;
	
	private String sourceCityCd;
	
	private String sourceCityNm;
	
	private String sourceStateCd;
	
	private String sourceStateNm;
	
	private String sourceCountryCd;
	
	private String sourceCountryNm;
	
	private String sourceTrZoneCd;
	
	private String sourceToEmail;
	
	private BigDecimal sourceLatitude;
	
	private BigDecimal sourceLongitude;
	
	private String customerCd;
	
	private String customerFederalId;
	
	private String customerStateId;
	
	private String customerNm;
	
	private String customerAddress;
	
	private String customerDistrict;
	
	private String customerZipcode;
	
	private String customerCityCd;
	
	private String customerCityNm;
	
	private String customerStateCd;
	
	private String customerStateNm;
	
	private String customerCountryCd;
	
	private String customerCountryNm;
	
	private String customerTrZoneCd;
	
	private String customerToEmail;
	
	private BigDecimal customerLatitude;
	
	private BigDecimal customerLongitude;

	private String shipToCd;
	
	private String shipToFederalId;
	
	private String shipToStateId;
	
	private String shipToNm;
	
	private String shipToAddress;
	
	private String shipToDistrict;
	
	private String shipToZipcode;
	
	private String shipToCityCd;
	
	private String shipToCityNm;
	
	private String shipToStateCd;
	
	private String shipToStateNm;
	
	private String shipToCountryCd;
	
	private String shipToCountryNm;
	
	private String shipToTrZoneCd;
	
	private String shipToEmail;
	
	private BigDecimal shipToLatitude;
	
	private BigDecimal shipToLongitude;
	
	private BigDecimal totalVolume   ;
	
	private String volumeUnit    ;
	
	private BigDecimal totalWeight   ;
	
	private String weightUnit    ;
	
	private BigDecimal totalAmount   ;
	
	private BigDecimal totalAmountTax;
	
	private String currency      ;
	
	private List<TransportOrderItemDto> transportUnitItems;
	
}
