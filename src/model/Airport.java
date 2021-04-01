package model;

import java.util.concurrent.ThreadLocalRandom;

public class Airport implements IdNumberGenerator {

	private String airportNr;
	private int capacity;
	private AirportName airportName;
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public AirportName getAirportName() {
		return airportName;
	}
	public void setAirportName(AirportName airportName) {
		this.airportName = (airportName != null) ? airportName : AirportName.RIGA;

	}
	public String getAirportNr() {
		return airportNr;
	}
	
	public void generateNr()
	{
		
		this.airportNr = airportName.name().substring(0, 3) + ThreadLocalRandom.current().nextInt(10, 100 + 1);
	}
	
	public Airport()
	{
		
		capacity = 0;
		airportName = AirportName.RIGA;
		generateNr();
				
	}
	
	public Airport(AirportName airportName, int capacity)
	{
		
		setCapacity(capacity);
		setAirportName(airportName);
		generateNr();
				
	}
	
	public String toString()
	{
		return "Airport name : " + airportName + ", Airport NR : " + airportNr + "Capacity" + capacity;
	}
}
