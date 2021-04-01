package Service;

import java.io.Serial;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import model.Airport;
import model.AirportName;
import model.BoardingPass;
import model.Flight;
import model.IdenType;
import model.Nationality;
import model.Passenger;
import model.Person;
import model.VIPPassenger;

public class MainService {
	public static ArrayList<Person> allUsersInSystem = new ArrayList<>();
	public static ArrayList<BoardingPass> allBoardingPases = new ArrayList<>();
	public static ArrayList<Flight> allUFlights = new ArrayList<>();
	public static ArrayList<Airport> allAirports = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = format.format( new Date()   );
		Date   date1       = format.parse ( "2009-12-31" );   

		Passenger pas1 = new Passenger("Emîls", "Vçveris", Nationality.LATVIAN, IdenType.IDCARD, "101199-12517", true, "None");
		allUsersInSystem.add(pas1);
		Passenger pas2 = new Passenger("Kaíis", "Suns", Nationality.ITALIAN, IdenType.PASSPORT, "160805-12447", false, "Window seat");
		allUsersInSystem.add(pas2);
		Passenger pas3 = new Passenger("Mâris", "Ozols", Nationality.ESTONIAN, IdenType.IDCARD, "190167-13317", true, "None");
		allUsersInSystem.add(pas3);
		
		VIPPassenger vippas1 = new VIPPassenger("Jânis", "Kâmis", Nationality.LATVIAN, IdenType.PASSPORT, "270285-11111", true,"None", "10");
		allUsersInSystem.add(vippas1);
		VIPPassenger vippas2 = new VIPPassenger("Ieva", "Bçrziòa", Nationality.ITALIAN, IdenType.PASSPORT, "160805-12447", false, "None", "11");
		allUsersInSystem.add(vippas2);
		VIPPassenger vippas3 = new VIPPassenger("Mâris", "Ozols", Nationality.ESTONIAN, IdenType.IDCARD, "190167-13317", true, "None", "12");
		allUsersInSystem.add(vippas3);

		
		Airport air1 = new Airport(AirportName.BARSELONA, 1000);
		allAirports.add(air1);
		Airport air2 = new Airport(AirportName.RIGA, 1234);
		allAirports.add(air2);
		Airport air3 = new Airport(AirportName.OSLO, 4321);
		allAirports.add(air3);

		Flight flight1 = new Flight(air1, air2, date1, (byte)5);
		allUFlights.add(flight1);
		Flight flight2 = new Flight(air2, air3, date1, (byte)5);
		allUFlights.add(flight2);
		Flight flight3 = new Flight(air3, air2, date1, (byte)5);
		allUFlights.add(flight3);
		
		BoardingPass bPass1 = BoardingPass.registerUserService.newBoardingPass(flight1, pas1);
		allBoardingPases.add(bPass1);
		BoardingPass bPass2 = BoardingPass.registerUserService.newBoardingPass(flight2, pas3);
		allBoardingPases.add(bPass2);
		BoardingPass bPass3 = BoardingPass.registerUserService.newBoardingPass(flight3, pas2);
		allBoardingPases.add(bPass3);
		
		for (Person persTemp : allUsersInSystem) {
			if (persTemp instanceof Passenger) 
			{
				System.out.println(persTemp.toString());
			}
		}
		
		allUsersInSystem = deletePassanger("Emîls","Vçveris");
		
		for (Person persTemp : allUsersInSystem) {
			if (persTemp instanceof Passenger)
			{
				System.out.println(persTemp.toString());
			}
		}
		showFlights(AirportName.BARSELONA);
	}

	
	public static ArrayList<Person> deletePassanger(String name, String Surname)
	{
		ArrayList<Person> tempData = new ArrayList<>();
		for(Person pas: MainService.allUsersInSystem)
		{
			//Private user posts are stored in publicPostList
			if(pas instanceof Passenger)
			{

					if(pas.getName().equals(name) && pas.getSurname().equals(Surname))
					{
						
					} else {
						tempData.add(pas);
					}
				
			} 
		}
		return tempData;
	}
	
	public static ArrayList<Person> deleteVIPPassanger(long vipNr)
	{
		ArrayList<Person> tempData = new ArrayList<>();
		for(Person pas: MainService.allUsersInSystem)
		{
			//Private user posts are stored in publicPostList
			if(pas instanceof VIPPassenger)
			{
				VIPPassenger vPas =  (VIPPassenger)pas;
					if(vPas.getVipNr() == vipNr)
					{

					} else {
						tempData.add(pas);
					}
				
			} 
		}
		return tempData;
	}
	//Delete Airport by Airport number (3 points);
	public static ArrayList<Airport> deleteAirpotByNr(String airportNr)
	{
		ArrayList<Airport> tempData = new ArrayList<>();
		for(Airport air: MainService.allAirports)
		{
			//Private user posts are stored in publicPostList


					if(air.getAirportNr().equals(airportNr))
					{

					} 
					else 
					{
						tempData.add(air);
					}
				
				
		}
		return tempData;
	}
	//Delete all Airports By Airport Name, for example, to delete BAR12, BAR32 if BARSELONA Airport Name is selected (3 points)
	public static ArrayList<Airport> deleteAirpotByName(String airportName)
	{
		ArrayList<Airport> tempData = new ArrayList<>();
		for(Airport air: MainService.allAirports)
		{
			//Private user posts are stored in publicPostList


					if(air.getAirportName().equals(airportName))
					{

					} else {
						tempData.add(air);
					}
				
		}
		return tempData;
	}

	// Delete BoardingPass by BoardingPass number (3 points);
	public static ArrayList<BoardingPass> deleteBoardingPass(String boardingPassNr)
	{
		ArrayList<BoardingPass> tempData = new ArrayList<>();
		for(BoardingPass bPass: MainService.allBoardingPases)
		{
			//Private user posts are stored in publicPostList


					if(bPass.getNr().equals(boardingPassNr))
					{

					} else {
						tempData.add(bPass);
					}
				
		}
		return tempData;
	}
	// Delete Flight in specific Airport by Flight number and airport name (3 points);
	public static ArrayList<Flight> deleteFlight(int flightNr, AirportName airportName)
	{
		ArrayList<Flight> tempData = new ArrayList<>();
		for(Flight flight: MainService.allUFlights)
		{
			//Private user posts are stored in publicPostList


					if(flight.getAirportFrom().equals(airportName) && flight.getFlightNr() == flightNr)
					{

					} else {
						tempData.add(flight);
					}
				
		}
		return tempData;
	}
	// Add regular Passenger in Flight if AirportName, Flight number and Passenger identificator are as input parameters (3 points);
	// Add VIP Passenger in Flight if AirportName, Flight number and Passenger identificator are as input parameters (3 points);
	public static void addVIPPassanger(int flightNr, AirportName airportName, Passenger passenger)
	{
		for(Flight flight: MainService.allUFlights)
		{



					if(flight.getAirportFrom().equals(airportName) && flight.getFlightNr() == flightNr)
					{
						flight.addNewPassangerByBoardingPass(passenger);
					}
				
		}
		//Show all Passengers in Flight if airport name and flight number are as input parameters (3 points);


	}
	private static void showAllPasangers(int flightNr, AirportName airportName)
	{
		for(Flight flight: MainService.allUFlights)
		{



					if(flight.getAirportFrom().equals(airportName) && flight.getFlightNr() == flightNr)
					{
						
						System.out.println(flight.getAllPassangers());
						
					}
				
		}
	}
	// Show only VIP Passengers in Flight if airport name and flight number are as input parameters (3 points);
//TODO 
/*	private static void showVIPPasangers(int flightNr, AirportName airportName)
	{
		for(Flight flight: MainService.allUFlights)
		{



					if(flight.getAirportFrom().equals(airportName) && flight.getFlightNr() == flightNr)
					{
						
						System.out.println(flight.getAllPassangers());
						
					}
				
		}
	}*/ 
	
	public static void showFlights(AirportName airportName)
	{
		for(Flight flight: MainService.allUFlights)
		{
			//Private user posts are stored in publicPostList


			if(flight.getAirportFrom().getAirportName().equals(airportName))
			{
				System.out.println(flight.toString());
			}

		}
	}
}
	
	
