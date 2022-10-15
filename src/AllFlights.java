import java.util.ArrayList;

public class AllFlights {
	
	//static arraylist of type flights to store all the flights from the csv file.
	private static ArrayList<Flight> allFlights = new ArrayList<Flight>();
	
	public static void addFlight(Flight flight) {
		allFlights.add(flight);
	}
	
	public static ArrayList<Flight> getAllFlights(){
		return allFlights;
	}
	
	/*
	 * Method that will be used to "filter" flights from the previous arraylist.
	 * it will take as parameters 3 strings, departure city, ariival city and departure date
	 * it will return an arraylist of flights
	 */
	public static ArrayList<Flight> findFlights(String departureCity, String arrivalCity, String departureDate){
		
		//creating local arraylist of flights type to store the found flights.
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		//loop through allflights and if criteria matches add flight object to local arraylist
		for(Flight flight : allFlights) {
			
			String depCity = flight.getDepartureCity();
			String arrCity = flight.getArrivalCity();
			String depDate = flight.getFlightDate();
			
			if(depCity.equals(departureCity) && arrCity.equals(arrivalCity) && depDate.equals(departureDate)) {
				flights.add(flight);
			}
		}
		return flights;
	}
	
}

