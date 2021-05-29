package br.silveira.tms.testes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named
@ViewScoped
public class FlightController implements Serializable {

	/**	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Flight flight = new Flight();

	private List<Flight> flights = new ArrayList<>();

	List<Flight> ret = new ArrayList<Flight>();

	public void fetchAll() {
		flights = listAll();
	}

	private List<Flight> listAll() {
		
		return ret;
	}

	public void save() {
		ret.add(flight);
		System.out.println("saved!!!!");
		flight = new Flight();
		flights = listAll();
	}

	public void edit(Flight flight) {
		this.flight = flight;
	}

	public void refresh() {
		flight = new Flight();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}