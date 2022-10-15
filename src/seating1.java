import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
//git test 13


public class seating1 extends JFrame {
	//#############Veriables##############################################################



	Integer planeType;
	static int planeTypeNum;
	double flightDuration;
	String planeModel="boing 747";
	//test veriables go under here
	String test_seatingNum= "error";

	/////////////////////
	static char c = 'A';
	static int n = 1;
	static int x = 1;
	static int seatC=1;
	static boolean moreSeats= true;
	static int selections=0;


	////////////////////////////
	/**
	 * temp files 
	 * just holds info till the program is put together 
	 * @return
	 */

	//file manipulation

	static	String id = "";
	static	String name = "bob";
	static	String age = "22";
	static String filepath= "takenSeats.csv";
	//
	static String flightId ;
	//
	static ArrayList<String> flightSeats = new ArrayList<String>();
	static ArrayList<String> selectedSeats = new ArrayList<String>();



//######################################
/**
	 * Launch the application.
	 */
	//###############################################MAIN###############################
//	public static void main(String[] args) {
//		
//		//saveRecrod(id, name, age, filepath);
//		flightId="1235";
//		readRecord(flightId, filepath);
//		
//
//		
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					seating1 frame = new seating1();
//					frame.setVisible(true);
//					frame.setSize(1280, 720);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	private JPanel contentPane;
//############################	

public static void findPlaneModel(int flightDuration){
	if(flightDuration > 7200){
		planeTypeNum = 2;
	}else{
	   planeTypeNum = 1;
	}
	
	System.out.println(planeTypeNum);
}

//this method iterated through the letter and numbers to create the seating names

public static String seatlist(Integer b){
	
double counter = 0;
String tseat= "";
    

	 while(counter < b){
		 counter ++;

		if(n >= 20){
			c++;
			n=1;
		}
	
	  if(c <='f'){
		  //this is the final seat name
		tseat = ""+n+c;
		
	  }
	  n++;
	}

	return tseat;
}


//this function reads the file and fills in the array to show the already taken seats
private static Scanner scan;

public static void readRecord(String flightId, String filepath){
	boolean found = false;
	
	try{
		scan = new Scanner(new File(filepath));
		scan.useDelimiter("[,\n ]");
		while(scan.hasNext() && !found){
			id = scan.next();
			
		
			

		
			if(id.equals(flightId)){
				found = true;
				while(scan.hasNext()&& found){
				flightSeats.add(scan.next());
				}
			}
		}
		if(found){
			
			
			JOptionPane.showMessageDialog(null,id+" "+ flightSeats);
		}else{
			JOptionPane.showMessageDialog(null,"not found");
		}

	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"ops");

	}
}

public static void saveRecrod(String flightid, String filepath){

	try{
		FileWriter fw = new FileWriter(filepath, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.print(flightId+",");
		for(int b = 0; b <flightSeats.size(); b++){
			pw.print(flightSeats.get(b)+",");
		}

		
		pw.flush();
		pw.close();

		JOptionPane.showMessageDialog(null,"record saved");
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,"record not saved");

	}
	
}

public static boolean qcounter(String tquantity){
	int countseat;
	countseat = Integer.valueOf(tquantity);

	try{
		if(countseat < (selectedSeats.size()+1)){
			System.out.println("too much");
			moreSeats= true;
			

		}else{
			System.out.println("not enough");
			moreSeats = false;
			
		}		
	}catch(Exception e){
		JOptionPane.showMessageDialog(null,"something went wrong");


	}
	

	

	return moreSeats;
}

//looks if a button is in a list
public static boolean findSeat(String fN2){
	boolean found= false;
	try{
		/*List currentS = Arrays.asList(flightSeats);
		if(currentS.contains(fN2)){
			System.out.println(fN2);
			found= true;
		}else{
			System.out.println("fuck not here" + fN2);
			found = false;
		}*/
		if(flightSeats.contains(fN2)){
			System.out.println("we found it"+fN2);
			found = true;
		}
	}catch(Exception e){
		System.out.println("something is wrong");
	}

	return found;
}


static String seatDisplay="";
public void pannelName(String fN2) {

	seatDisplay= seatDisplay+" "+fN2;
	
}


////////////////////

	/**
	 * Create the frame.
	 */
	public seating1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("seating");
		Border blackbox = BorderFactory.createLineBorder(Color.black);
		
		JLabel seatS = new JLabel(seatDisplay);
		seatS.setBounds(10, 114, 296, 72);
		contentPane.add(seatS);
		
		JPanel panel = new JPanel();
		panel.setBounds(531, 11, 215, 103);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton thisCanBechanged_1 = new JButton("clear");
		thisCanBechanged_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flightSeats.clear();
				seatDisplay="";
				seatS.setText(seatDisplay);
				selectedSeats.clear();
			}
		});
		thisCanBechanged_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		
		JButton thisCanBechanged = new JButton("save");
		panel.add(thisCanBechanged);
		thisCanBechanged.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			
			saveRecrod(id, filepath);

			}
		});

//this handles quantity
		String tquantity;
		tquantity=JOptionPane.showInputDialog("how many tickets would you like to purchase");
		System.out.println(tquantity);
		JLabel lblNewLabel = new JLabel("please select "+ tquantity + " seats");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(232, 11, 182, 45);
		contentPane.add(lblNewLabel);
		qcounter(tquantity);

	

		//veriables
		Integer snum,nnum=1,lnum=1,xnum=1;

		
		JPanel testingArea = new JPanel();
		testingArea.setBounds(10, 197, 57, 272);
		contentPane.add(testingArea);
		testingArea.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel testingArea_1 = new JPanel();
		testingArea_1.setBounds(77, 197, 57, 272);
		contentPane.add(testingArea_1);
		testingArea_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel txtpnPlanename = new JLabel();
		txtpnPlanename.setFont(new Font("Serif", Font.PLAIN, 29));
		txtpnPlanename.setForeground(SystemColor.desktop);
		txtpnPlanename.setBackground(SystemColor.textInactiveText);
		txtpnPlanename.setText(planeModel);
		txtpnPlanename.setBounds(0, 0, 457, 103);
		txtpnPlanename.setBorder(blackbox);
		
		
		contentPane.add(txtpnPlanename);
		
		JButton testRead = new JButton("test read");
		testRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				readRecord(flightId, filepath);
			}
		});
		testRead.setBounds(432, 160, 89, 23);
		contentPane.add(testRead);
		
		JPanel b1= new JPanel();
		b1.setBounds(210, 197, 57, 272);
		contentPane.add(b1);
		b1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel b1_1 = new JPanel();
		b1_1.setBounds(277, 196, 57, 272);
		contentPane.add(b1_1);
		b1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel b1_1_1 = new JPanel();
		b1_1_1.setBounds(344, 197, 57, 272);
		contentPane.add(b1_1_1);
		b1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel b1_1_1_1 = new JPanel();
		b1_1_1_1.setBounds(411, 197, 57, 272);
		contentPane.add(b1_1_1_1);
		b1_1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel b1_1_1_1_1 = new JPanel();
		b1_1_1_1_1.setBounds(531, 197, 348, 313);
		contentPane.add(b1_1_1_1_1);
		b1_1_1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		

		
//First class


		//First class


		String N2;

				for(snum = 1 ; snum <= 6; snum++){
					
					N2 = seatlist(1);
					final String fN2 = N2;
					JButton tt = new JButton(N2);
					if(findSeat(N2)==true){
						tt.setBackground(Color.GRAY);
					}else{
					tt.setBackground(Color.white);
					}
				    testingArea.add(tt);
					tt.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						test_seatingNum=fN2;
						qcounter(tquantity);
						
						if(findSeat(fN2) == false && !qcounter(tquantity)){
						flightSeats.add(test_seatingNum);
						selectedSeats.add(test_seatingNum);
						System.out.println(flightSeats);
						tt.setBackground(Color.CYAN);
						pannelName(fN2);
						
						seatS.setText(seatDisplay);
						}else{
							
						}
						
					
			
						}
					});
				}
				
				
				for(snum = 1 ; snum <= 6; snum++){
					
					N2 = seatlist(1);
					final String fN2 = N2;
					JButton tt = new JButton(N2);
				    testingArea_1.add(tt);
					if(findSeat(N2)==true){
						tt.setBackground(Color.GRAY);
					}else{
					tt.setBackground(Color.white);
					}

					tt.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						test_seatingNum=fN2;
						qcounter(tquantity);
						
						if(findSeat(fN2) == false && !qcounter(tquantity)){
						flightSeats.add(test_seatingNum);
						selectedSeats.add(test_seatingNum);
						tt.setBackground(Color.CYAN);
						System.out.println(flightSeats);
						pannelName(fN2);
						
						
						seatS.setText(seatDisplay);
						}else{
							
						}
						
					
			
						}
					});
				}

//business
				
				for(snum = 1 ; snum <= 6; snum++){
					
					N2 = seatlist(1);
					final String fN2 = N2;
					JButton tt = new JButton(N2);
					b1.add(tt);
					if(findSeat(N2)==true){
						tt.setBackground(Color.GRAY);
					}else{
					tt.setBackground(Color.white);
					}

					tt.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						test_seatingNum=fN2;
						qcounter(tquantity);
						
						if(findSeat(fN2) == false && !qcounter(tquantity)){
						flightSeats.add(test_seatingNum);
						selectedSeats.add(test_seatingNum);
						tt.setBackground(Color.CYAN);
						System.out.println(flightSeats);
						pannelName(fN2);
						
						
						seatS.setText(seatDisplay);
						}else{
							
						}
						
					
			
						}
					});
				}
				
				
for(snum = 1 ; snum <= 6; snum++){
					
					N2 = seatlist(1);
					final String fN2 = N2;
					JButton tt = new JButton(N2);
					b1_1.add(tt);
					if(findSeat(N2)==true){
						tt.setBackground(Color.GRAY);
					}else{
					tt.setBackground(Color.white);
					}

					tt.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
						test_seatingNum=fN2;
						qcounter(tquantity);
						
						if(findSeat(fN2) == false && !qcounter(tquantity)){
						flightSeats.add(test_seatingNum);
						selectedSeats.add(test_seatingNum);
						tt.setBackground(Color.CYAN);
						System.out.println(flightSeats);
						pannelName(fN2);
						
						
						seatS.setText(seatDisplay);
						}else{
							
						}
						
					
			
						}
					});
				}

for(snum = 1 ; snum <= 6; snum++){
	
	N2 = seatlist(1);
	final String fN2 = N2;
	JButton tt = new JButton(N2);
	b1_1_1.add(tt);
	if(findSeat(N2)==true){
		tt.setBackground(Color.GRAY);
	}else{
	tt.setBackground(Color.white);
	}

	tt.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		test_seatingNum=fN2;
		qcounter(tquantity);
		
		if(findSeat(fN2) == false && !qcounter(tquantity)){
		flightSeats.add(test_seatingNum);
		selectedSeats.add(test_seatingNum);
		tt.setBackground(Color.CYAN);
		System.out.println(flightSeats);
		pannelName(fN2);
		
		
		seatS.setText(seatDisplay);
		}else{
			
		}
		
	

		}
	});
}

for(snum = 1 ; snum <= 6; snum++){
	
	N2 = seatlist(1);
	final String fN2 = N2;
	JButton tt = new JButton(N2);
	b1_1_1_1.add(tt);
	if(findSeat(N2)==true){
		tt.setBackground(Color.GRAY);
	}else{
	tt.setBackground(Color.white);
	}

	tt.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		test_seatingNum=fN2;
		qcounter(tquantity);
		
		if(findSeat(fN2) == false && !qcounter(tquantity)){
		flightSeats.add(test_seatingNum);
		selectedSeats.add(test_seatingNum);
		tt.setBackground(Color.CYAN);
		System.out.println(flightSeats);
		pannelName(fN2);
		
		
		seatS.setText(seatDisplay);
		}else{
			
		}
		
	

		}
	});
}

for(snum = 1 ; snum <= 54; snum++){
	
	N2 = seatlist(1);
	final String fN2 = N2;
	JButton tt = new JButton(N2);
	b1_1_1_1_1.add(tt);
	if(findSeat(N2)==true){
		tt.setBackground(Color.GRAY);
	}else{
	tt.setBackground(Color.white);
	}

	tt.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		test_seatingNum=fN2;
		qcounter(tquantity);
		
		if(findSeat(fN2) == false && !qcounter(tquantity)){
		flightSeats.add(test_seatingNum);
		selectedSeats.add(test_seatingNum);
		tt.setBackground(Color.CYAN);
		System.out.println(flightSeats);
		pannelName(fN2);
		
		
		seatS.setText(seatDisplay);
		}else{
			
		}
		
	

		}
	});
}

				
			}
		}
