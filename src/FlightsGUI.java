import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.EventQueue;

public class FlightsGUI extends JFrame {
	
	private JPanel flightFinderPane;
	
	//f will be used to format dates into strings
	private DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dateToday = new Date();
	
	//get todays date and store it in a string after formatting it
	private String dateTodayf = f.format(dateToday);
	
	//initialise ArrayLists to store found flights
	private static ArrayList<Flight> departureFlights = new ArrayList<Flight>();
	private static ArrayList<Flight> arrivalFlights = new ArrayList<Flight>();
	
	private String[] cities = {"Amsterdam", "Athens", "Bangkok", "Cairo", "Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Lisbon", "London", "Madrid", "Marrakesh", "Mexico", "Moscow", "New York", "Paris", "Rome", "San Paulo", "Sweden", "Sydney", "Texas", "Tokyo", "Toronto"};
	
	/**
	 * Create the frame.
	 */
	public FlightsGUI() {
		setTitle("Brunel City Airport System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		flightFinderPane = new JPanel();
		flightFinderPane.setBackground(Color.WHITE);
		flightFinderPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(flightFinderPane);
		flightFinderPane.setLayout(null);
		
		
		/*
		 * Create combo boxes for cities
		 * loop through array cities to add each city to the combo box
		 * then add both combo boxes to panel
		 */
		JComboBox<String> departureCity = new JComboBox<String>();
		JComboBox<String> arrivalCity = new JComboBox<String>();
		departureCity.setFont(new Font("Arial", Font.PLAIN, 16));
		arrivalCity.setFont(new Font("Arial", Font.PLAIN, 16));
		departureCity.setBounds(143, 78, 157, 36);
		arrivalCity.setBounds(420, 78, 157, 36);
		for(String city : cities) {
			departureCity.addItem(city);
			arrivalCity.addItem(city);
		}
		flightFinderPane.add(departureCity);
		flightFinderPane.add(arrivalCity);
		
		JDateChooser departDate = new JDateChooser();
		departDate.setBounds(143, 125, 157, 36);
		flightFinderPane.add(departDate);
		
		JDateChooser arrivalDate = new JDateChooser();
		arrivalDate.setBounds(420, 125, 157, 36);
		flightFinderPane.add(arrivalDate);
		
		JLabel lblBrunelCityAirport = new JLabel("Brunel City Airport");
		lblBrunelCityAirport.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrunelCityAirport.setForeground(new Color(0, 73, 133));
		lblBrunelCityAirport.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblBrunelCityAirport.setBounds(10, 11, 714, 44);
		flightFinderPane.add(lblBrunelCityAirport);
		
		JLabel lblDepartureCity = new JLabel("From:");
		lblDepartureCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartureCity.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDepartureCity.setBounds(33, 78, 100, 36);
		flightFinderPane.add(lblDepartureCity);
		
		JLabel lblArrivalCity = new JLabel("To:");
		lblArrivalCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArrivalCity.setFont(new Font("Arial", Font.PLAIN, 16));
		lblArrivalCity.setBounds(310, 78, 100, 36);
		flightFinderPane.add(lblArrivalCity);
		
		JLabel lblDepartureDate = new JLabel("Departure Date:");
		lblDepartureDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartureDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDepartureDate.setBounds(10, 125, 123, 36);
		flightFinderPane.add(lblDepartureDate);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date:");
		lblArrivalDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArrivalDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblArrivalDate.setBounds(287, 125, 123, 36);
		flightFinderPane.add(lblArrivalDate);
		
		/*
		 * create button
		 * its setting
		 * and an action listener
		 */
		JButton btnSearchFlights = new JButton("Find flights!");
		btnSearchFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get departure city and arrival city chosen from combo boxes
				String strDepartureCity = (String) departureCity.getSelectedItem();
				String strArrivalCity = (String) arrivalCity.getSelectedItem();
				
				//local variables for dates
				Date depDate = null;
				Date arrDate = null;
				String depDatef = "";
				String arrDatef = "";
					
				if (strDepartureCity.equals(strArrivalCity)) {
					JOptionPane.showMessageDialog(flightFinderPane, "Please select different cities");
				} else {
					
					try { 
						depDate = departDate.getDate();
						depDatef = f.format(depDate);
					} catch(NullPointerException a) {
						JOptionPane.showMessageDialog(flightFinderPane, "Please enter a departure date.");
					}
					
					try { 
						arrDate = arrivalDate.getDate();
						arrDatef = f.format(arrDate);
					} catch(NullPointerException a) {
						JOptionPane.showMessageDialog(flightFinderPane, "Please enter an arrival date.");
					}
					
					//compare departure date and arrival date
					if (dateToday.compareTo(depDate) > 0) {
						JOptionPane.showMessageDialog(flightFinderPane, "Departure date must be after today.");
					} 
					else if (dateToday.compareTo(arrDate) > 0) {
						JOptionPane.showMessageDialog(flightFinderPane, "Arrival date must be after today.");
					}
					else if (dateTodayf.equals(depDatef)) {
						JOptionPane.showMessageDialog(flightFinderPane, "Departure date must be after today.");
					}
					else if (dateTodayf.equals(arrDatef)) {
						JOptionPane.showMessageDialog(flightFinderPane, "Arrival date must be after today.");
					}
					else if(depDate.compareTo(arrDate) > 0) {
						JOptionPane.showMessageDialog(flightFinderPane, "Departure date must be before arrival date.");
					} 
					else if (depDatef.equals(arrDatef)) {
						JOptionPane.showMessageDialog(flightFinderPane, "Arrival and departure date must be different.");
					} 
					else {
						//store to static attribute the flights found from static method findFlights in AllFlights class
						departureFlights = AllFlights.findFlights(strDepartureCity, strArrivalCity, depDatef);
						arrivalFlights = AllFlights.findFlights(strArrivalCity, strDepartureCity, arrDatef);
						
						//open flightPicker GUI
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									FlightPickerGUI frame = new FlightPickerGUI();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
		});
		btnSearchFlights.setBounds(426, 193, 151, 36);
		btnSearchFlights.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSearchFlights.setForeground(Color.WHITE);
		btnSearchFlights.setBackground(new Color(65, 105, 225));
		flightFinderPane.add(btnSearchFlights);	
	}
	
	//getters for both ArrayLists
	public static ArrayList<Flight> getDepartureFlights(){
		return departureFlights;
	}
		 
	public static ArrayList<Flight> getArrivalFlights(){
		return arrivalFlights;
	}
}
