import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class getFileNameGUI extends JFrame {

	private JPanel getFIleNamePane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getFileNameGUI frame = new getFileNameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getFileNameGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		getFIleNamePane = new JPanel();
		getFIleNamePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getFIleNamePane);
		getFIleNamePane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Enter file path");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblTitle.setBounds(10, 11, 264, 21);
		getFIleNamePane.add(lblTitle);
		
		JTextPane txtFileURL = new JTextPane();
		txtFileURL.setBounds(10, 43, 264, 21);
		getFIleNamePane.add(txtFileURL);
		
		JButton btnRead = new JButton("READ");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//create new object flightFile of type FileReader from text input
					FileReader flightsFile = new FileReader(txtFileURL.getText().toString());
					
					//use method from Flights file with the filereader paramater
					Flight.readFlights(flightsFile);
					
					//open Flights GUI
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								FlightsGUI frame = new FlightsGUI();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					//dispose this gui
					dispose();
				} catch (FileNotFoundException error) {
					JOptionPane.showMessageDialog(getFIleNamePane, "File not found! Please try again with different path.");
				}
				
			}
		});
		btnRead.setBounds(98, 92, 89, 23);
		getFIleNamePane.add(btnRead);
	}
}
