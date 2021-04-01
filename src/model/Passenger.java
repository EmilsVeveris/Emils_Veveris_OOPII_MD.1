package model;

import utils.DataVerification;

public class Passenger extends Person {
	
	private boolean isAdult;
	private String extraNeeds;
	
	public boolean getisAdult() {
		return isAdult;
	}
	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	public String getExtraNeeds() {
		return extraNeeds;
	}
	public void setExtraNeeds(String extraNeeds) {
		
		this.extraNeeds = (extraNeeds != null) ? extraNeeds : "";

	}
	
	public Passenger()
	{
		super();
		isAdult = true;
		extraNeeds = "";
	}
	
	public Passenger(String name, String surname, Nationality nationality, IdenType idenType, String idenNr, boolean isAdult, String extraNeeds)
	{
		super(name, surname, nationality, idenType, idenNr);
		setAdult(isAdult);
		setExtraNeeds(extraNeeds);

	}

	public String toString()
	{
		return super.toString() + " Adult : " + isAdult + " Extra needs : " + extraNeeds;
	}
	
}
