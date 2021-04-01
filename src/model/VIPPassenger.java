package model;

public class VIPPassenger extends Passenger implements IdNumberGenerator{
	private long vipNr;
	private String loungeCardNr;
	private static long vipNrCounter = 0;
	
	public long getVipNr() {
		return vipNr;
	}

	public String getLoungeCardNr() {
		return loungeCardNr;
	}
	public void setLoungeCardNr(String loungeCardNr) {
		
		this.loungeCardNr = (loungeCardNr != null) ? loungeCardNr : "";
	}
	
	public VIPPassenger()
	{
		super();
		loungeCardNr = "";
		generateNr();
	}
	
	public VIPPassenger(String name, String surname, Nationality nationality, IdenType idenType, String idenNr, boolean isAdult, String extraNeeds, String loungeCardNr)
	{
		super(name, surname, nationality, idenType, idenNr, isAdult, extraNeeds);
		generateNr();
		setLoungeCardNr(loungeCardNr);

	}
	

	public String toString()
	{
		return vipNr+ ", " + loungeCardNr + " : " + super.toString();
	}

	public void generateNr() {
		
		this.vipNr = vipNrCounter++;
	}
}
