package model;

import java.util.Date;
import java.util.PriorityQueue;

public class Flight implements IdNumberGenerator {
	private int flightNr;
	private Date dateAndTime;
	private byte duration;
	private PriorityQueue<BoardingPass> allPassangers;
	private Airport airportFrom;
	private Airport airportTo;
	private static int flightNrCounter = 0;
	
	public int getFlightNr()
	{
		return flightNr;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public byte getDuration() {
		return duration;
	}

	public void setDuration(byte duration) {
		this.duration = duration;
	}

	public PriorityQueue<BoardingPass> getAllPassangers() {
		return allPassangers;
	}

	public void setAllPassangers(PriorityQueue<BoardingPass> allPassangers) {
		this.allPassangers = allPassangers;
		
	}

	public Airport getAirportFrom() {
		return airportFrom;
	}

	public void setAirportFrom(Airport airportFrom) {
		this.airportFrom = (airportFrom!=null) ? airportFrom : (new Airport());
	}

	public Airport getAirportTo() {
		return airportTo;
	}

	public void setAirportTo(Airport airportTo) {
		this.airportTo = (airportTo!=null) ? airportTo : (new Airport());
	}

	public Flight( Airport airportFrom, Airport airportTo, Date date, byte duration)
	{
		setAirportFrom(airportFrom);
		setAirportTo(airportTo);
		setDuration(duration);
		setDateAndTime(date);
	}
	
	public String toString()
	{
		return "From : " + airportFrom.getAirportName() + " To : " + airportTo.getAirportName() + " Date : " + dateAndTime + "Duration : " + duration;
	}
	
	public void generateNr()
	{
		this.flightNr = flightNrCounter++;
	}
	
	public boolean addNewPassangerByBoardingPass(Passenger pas)
	{
		//TODO Parbaudit vai passangeram ir pareizais bording pass
		//pievienot sarakstam atgriezt true

		//Ja anv pareizais bording pass atgriezt false
		return true;
	}

}

