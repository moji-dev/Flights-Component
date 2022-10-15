import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

public class Flight {
	
	//attributes for each flight
	private String flightDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private LocalTime flightDuration;
	private double distance;
	private int delay;
	private String departureAirport;
	private String departureCity;
	private String arrivalAirport;
	private String arrivalCity;	
	private String flightNo;
	private String airline;
	
	//constructor for each flight object
	public Flight(String flightDate, LocalTime departureTime, LocalTime arrivalTime, LocalTime flightDuration, double distance, int delay, String depAirport, String depCity, String arrAirport, String arrCity, String flightNo, String airline) {
		
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightDuration = flightDuration;
		this.distance = distance;
		this.delay = delay;
		this.departureAirport = depAirport;
		this.departureCity = depCity;
		this.arrivalAirport = arrAirport;
		this.arrivalCity = arrCity;
		this.flightNo = flightNo;
		this.airline = airline;
		
		//add constructed object to an ArrayList of Flights type in the AllFlights class.
		AllFlights.addFlight(this);
	}
	
	/*
	 * Public method that will take as input a FileReader and loop through the given csv file.
	 */
	public static void readFlights(FileReader file) {
		String line = "";
		
		BufferedReader br = new BufferedReader(file);
		
		try {
			/*
			 * loop through each row and save it as a string to the local variable line
			 * split each comma separated line and save it to array values
			 * call constructor with each value to create object.
			 */
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				new Flight(values[0], LocalTime.parse(values[1]), LocalTime.parse(values[2]), LocalTime.parse(values[3]), Double.valueOf(values[4]), Integer.valueOf(values[5]), values[6], values[7], values[8], values[9], values[10], values[11]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * getter methods for each attribute, may be used by other objects.
	 * I could not find a use to setter methods, thus not creating any.
	 */
	public String getFlightDate() {
		return this.flightDate;
	}
	
	public LocalTime getDepartureTime() {
		return this.departureTime;
	}
	
	public LocalTime getArrivalTime() {
		return this.arrivalTime;
	}
	
	public String getFligtNumber() {
		return this.flightNo;
	}
	
	public LocalTime getFlightDuration() {
		return this.flightDuration;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public int getDelayTime() {
		return this.delay;
	}
	
	public String getDepartureAirport() {
		return this.departureAirport;
	}
	
	public String getDepartureCity() {
		return this.departureCity;
	}
	
	public String getArrivalAirport() {
		return this.arrivalAirport;
	}
	
	public String getArrivalCity() {
		return this.arrivalCity;
	}
	
	public String getAirline() {
		return this.airline;
	}
	
//	public String toString() {
//		String str = String.format("Flight object with flight number %s departure from %s and arrival at %s.", this.flightNo, this.departureCity, this.arrivalCity);
//		return str;
//	}
	
}