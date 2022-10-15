import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightPickerGUI extends JFrame {
	
	private JPanel flightPickerPane;
	private JTable departureFlightsTable;
	private JScrollPane arrFlightsScroll;
	private JTable arrivalFlightsTable;
	
	/*
	 * Store selected flight of type Flight
	 */
	private static Flight selectedDepFlight;
	private static Flight selectedArrFlight;
	
	

	/**
	 * Create the frame.
	 */
	public FlightPickerGUI() {
		setTitle("Brunel City Airport");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 725);
		flightPickerPane = new JPanel();
		flightPickerPane.setBackground(Color.WHITE);
		flightPickerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(flightPickerPane);
		flightPickerPane.setLayout(null);
		
		JScrollPane depFlightsScroll = new JScrollPane();
		depFlightsScroll.setBounds(10, 43, 714, 203);
		flightPickerPane.add(depFlightsScroll);
		
		departureFlightsTable = new JTable();
		departureFlightsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		departureFlightsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Departure City", "Departure Airport", "Arrival City", "Arrival Airport", "Departure Time", "Arrival Time", "Flight Number", "Economy Price"
			}
		));
		DefaultTableModel depModel = (DefaultTableModel) departureFlightsTable.getModel();
		
		//for each flight in the departure flights arraylist of type Flight we get each object and use get methods to get needed information
		for(Flight flight : FlightsGUI.getDepartureFlights()) {
			depModel.addRow(new Object[]{flight.getDepartureCity(), flight.getDepartureAirport(), flight.getArrivalCity(), flight.getArrivalAirport(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getFligtNumber()});
		}
		
		depFlightsScroll.setViewportView(departureFlightsTable);
		
		arrFlightsScroll = new JScrollPane();
		arrFlightsScroll.setBounds(10, 284, 714, 203);
		flightPickerPane.add(arrFlightsScroll);
		
		arrivalFlightsTable = new JTable();
		arrivalFlightsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		arrivalFlightsTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Departure City", "Departure Airport", "Arrival City", "Arrival Airport", "Departure Time", "Arrival Time", "Flight Number", "Economy Price"
				}
			));
		DefaultTableModel arrModel = (DefaultTableModel) arrivalFlightsTable.getModel();
		for(Flight flight : FlightsGUI.getArrivalFlights()) {
			arrModel.addRow(new Object[]{flight.getDepartureCity(), flight.getDepartureAirport(), flight.getArrivalCity(), flight.getArrivalAirport(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getFligtNumber()});
		}
		arrFlightsScroll.setViewportView(arrivalFlightsTable);
		
		JLabel lblDepartureFlights = new JLabel("Departure Flights");
		lblDepartureFlights.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartureFlights.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDepartureFlights.setBounds(10, 11, 181, 36);
		flightPickerPane.add(lblDepartureFlights);
		
		JLabel lblArrivalFlights = new JLabel("Arrival Flights");
		lblArrivalFlights.setHorizontalAlignment(SwingConstants.LEFT);
		lblArrivalFlights.setFont(new Font("Arial", Font.PLAIN, 16));
		lblArrivalFlights.setBounds(10, 248, 181, 36);
		flightPickerPane.add(lblArrivalFlights);
		
		JButton btnPickFlights = new JButton("Pick flights");
		btnPickFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedDepRow = departureFlightsTable.getSelectedRow();
				int selectedArrRow = arrivalFlightsTable.getSelectedRow();
				if(departureFlightsTable.getSelectionModel().isSelectionEmpty() || arrivalFlightsTable.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(flightPickerPane, "You need to select a flight");
				} else {
					selectedDepFlight = FlightsGUI.getDepartureFlights().get(selectedDepRow);
					selectedArrFlight = FlightsGUI.getArrivalFlights().get(selectedArrRow);
					
					int seconds = selectedDepFlight.getFlightDuration().toSecondOfDay();
					seating1.findPlaneModel(seconds);
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								seating1 frame = new seating1();
								frame.setVisible(true);
								frame.setSize(1280, 720);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnPickFlights.setForeground(Color.WHITE);
		btnPickFlights.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPickFlights.setBackground(new Color(65, 105, 225));
		btnPickFlights.setBounds(573, 498, 151, 36);
		flightPickerPane.add(btnPickFlights);
		
		
	}
	
	/*
	 * getters for selected flights
	 */
	public static Flight getSelectedDepartureFlight() {
		return selectedDepFlight;
	}
	
	public static Flight getSelectedArrivalFlight() {
		return selectedArrFlight;
	}
}
