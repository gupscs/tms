package br.silveira.tms.testes;

import java.util.Date;

import lombok.Data;

@Data
public class Flight {

	    private Long id;

	    private String airline;
	    private String fromAirport;
	    private String toAirport;

	    private Date scheduledDateTime;
	    private Date estimatedDateTime;
	    private Date actualDateTime;

}
