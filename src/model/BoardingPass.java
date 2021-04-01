package model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import Service.Impl.BoardingPassImpl;







public class BoardingPass implements IdNumberGenerator {
	
	public static BoardingPassImpl registerUserService = new BoardingPassImpl();
	private String boardingPassNr;
	private short group;
	private static int VIPSeat = 1;
	private static int VIPRow = 0;
	private static int CSeat = 1;
	private static int CRow = 0;
	
	
	private Passenger passenger;
	private Seat seat;
	

	public void generateGroupByPriority() 
	{
		if (passenger instanceof VIPPassenger)
		{
			this.group = 1;
		} else {
			this.group = (short)ThreadLocalRandom.current().nextInt(2, 5 + 1);
		}
	}
	public void generateSeatByPriority()
	{
		char[] row = {'A', 'B', 'C', 'D', 'E', 'F'};


		if (passenger instanceof VIPPassenger)
		{
			if(VIPRow < row.length)
			{
				Seat seat = new Seat(row[VIPRow],(short)VIPSeat);
				setSeat(seat);
				VIPSeat = VIPSeat+1;
				if(VIPSeat > 3)
				{
					VIPSeat = 1;
					VIPRow = VIPRow + 1;
				}
			}
		} else {
			if(CRow < row.length)
			{
				Seat seat = new Seat(row[CRow],(short)CSeat);
				setSeat(seat);
				CSeat = CSeat+1;
				if(CSeat > 30)
				{
					CSeat = 4;
					CRow = CRow + 1;
				}
			}
		}
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = (passenger!=null) ? passenger : (new Passenger());
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = (seat!=null) ? seat : (new Seat());
	}
	public String getNr()
	{
		return boardingPassNr;
	}

	public void generateNr()
	{
		this.boardingPassNr = passenger.getName().substring(0, 1) + passenger.getSurname().substring(0, 1) + seat.toString() + group;
	}

	
	public BoardingPass()
	{
		Passenger passenger = new Passenger();
	}
	
	public BoardingPass(Passenger passenger)
	{
		setPassenger(passenger);
		generateGroupByPriority();
		generateSeatByPriority();
		generateNr();
	}
}
