package Service;

import model.AirportName;
import model.BoardingPass;
import model.Flight;
import model.Passenger;

public interface IBoardingPassService {

	public BoardingPass newBoardingPass(Flight flight, Passenger pas);
	public BoardingPass newBoardingPass(AirportName airportName, int flightNr ,String idenNr);
}
