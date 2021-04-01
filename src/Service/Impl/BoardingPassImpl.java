package Service.Impl;

import java.util.ArrayList;

import Service.IBoardingPassService;
import Service.MainService;
import model.AirportName;
import model.BoardingPass;
import model.Flight;
import model.Passenger;
import model.Person;
import Service.MainService;
import Service.IBoardingPassService;


public class BoardingPassImpl implements IBoardingPassService{


	public BoardingPass newBoardingPass(Flight flight, Passenger pas) {
		BoardingPass bPas = new BoardingPass(pas);

		return bPas;
	}

	public BoardingPass newBoardingPass(AirportName airportName, int flightNr, String idenNr) {
		

		BoardingPass bPas = new BoardingPass();
		
		for(Person pas: MainService.allUsersInSystem)
		{
			//Private user posts are stored in publicPostList
			if(pas instanceof Passenger)
			{

					if(pas.getIdenNr().equals(idenNr))
					{
						bPas = new BoardingPass((Passenger)pas);
					}
				
			} 



	}
		return bPas;
	}
}
