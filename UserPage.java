import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class UserPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122877368824539554L;
	private JPanel contentPane;
	public static ArrayList<ArrayList<String>> slots = new ArrayList<ArrayList<String>>(); 
	public static String dispAvailText="";
	public static String fileBookId="";
	public static String fileFacilId="";
	public static String userId="";
	public static String userName="";
	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		UserPage.userName = userName;
	}

	public static String dateForFile="";
	public static String slotForFile="";
	public static String paymentReceived="";

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void UserPageLaunch(String UserName) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
					setUserName(UserName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 */
	public UserPage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Exit");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBack.setBounds(481, 718, 89, 23);
		contentPane.add(btnBack);
		
		String lineFromFile="";
		String [] fileElements;
		String filefacils = "Facilities.txt";
		String fileBookings = "Bookings.txt";
		String fileUsers = "Users.txt";
		slots.add(new ArrayList<String>()); // Add list to store FacilId
		slots.add(new ArrayList<String>()); // Add list to store FacilName
		
		File file = new File(filefacils);
		Scanner in;
		//ArrayList of Facils File
		ArrayList<ArrayList<String>> facils = new ArrayList<ArrayList<String>>();
		facils.add(new ArrayList<String>()); // Add list to store FacilId
		facils.add(new ArrayList<String>()); // Add list to store FacilName
		facils.add(new ArrayList<String>()); // Add list to store FacilCostperHour
		facils.add(new ArrayList<String>()); // Add list to store Decommission Date
		try {
			in = new Scanner(file);
			while(in.hasNext())
			{
				  lineFromFile = in.nextLine();
				  System.out.println("Linefromfile"+lineFromFile);
				  fileElements = lineFromFile.split(",");
				  System.out.println("TEST1" + fileElements[0]);
				  System.out.println(fileElements[1]);
				  System.out.println(fileElements[2]);
				  System.out.println(fileElements[3]);
				  facils.get(0).add(fileElements[0]); //Add FacilId to ArrayList
				  facils.get(1).add(fileElements[1]); //Add FacilName to ArrayList
				  facils.get(2).add(fileElements[2]); //Add FacilCostperHour to ArrayList
				  facils.get(3).add(fileElements[3]); //Add Decommission to ArrayList
			}
			
			in.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//End build facils Arraylist
		
		//Arraylist for Bookings File
		file = new File(fileBookings);
		ArrayList<ArrayList<String>> bookings = new ArrayList<ArrayList<String>>();
		bookings.add(new ArrayList<String>()); // Add list to store BookingsId
		bookings.add(new ArrayList<String>()); // Add list to store FacilId
		bookings.add(new ArrayList<String>()); // Add list to store Booked by User
		bookings.add(new ArrayList<String>()); // Add list to store Booking Date
		bookings.add(new ArrayList<String>()); // Add list to store TimeSlot
		bookings.add(new ArrayList<String>()); // Add list to store Payment made
		try {
			in = new Scanner(file);
			while(in.hasNext())
			{
				  lineFromFile = in.nextLine();
				  System.out.println("Bookings Linefromfile"+lineFromFile);
				  fileElements = lineFromFile.split(",");
				  System.out.println("Bookings" + fileElements[0]);
				  System.out.println(fileElements[1]);
				  System.out.println(fileElements[2]);
				  System.out.println("Bookings File El3: "+fileElements[3]);
				  bookings.get(0).add(fileElements[0]); //Add BookingsId to ArrayList
				  bookings.get(1).add(fileElements[1]); //Add FacilId to ArrayList
				  bookings.get(2).add(fileElements[2]); //Add Booked by User to ArrayList
				  bookings.get(3).add(fileElements[3]); //Add Booking Date to ArrayList
				  bookings.get(4).add(fileElements[4]); //Add Booking Date to ArrayList
				  bookings.get(5).add(fileElements[5]); //Add Booking Date to ArrayList
			}
			
			in.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//End build Arraylist for bookings file
		
		//Arraylist for Users File
				file = new File(fileUsers);
				ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
				users.add(new ArrayList<String>()); // Add list to store UserId
				users.add(new ArrayList<String>()); // Add list to store Username
				users.add(new ArrayList<String>()); // Add list to store UserPassword
				users.add(new ArrayList<String>()); // Add list to store UserType
				
				try {
					in = new Scanner(file);
					while(in.hasNext())
					{
						  lineFromFile = in.nextLine();
						  System.out.println("Linefromfile"+lineFromFile);
						  fileElements = lineFromFile.split(",");
						  System.out.println("TEST1" + fileElements[0]);
						  System.out.println(fileElements[1]);
						  System.out.println(fileElements[2]);
						  System.out.println(fileElements[3]);
						  users.get(0).add(fileElements[0]); //Add UserId to ArrayList
						  users.get(1).add(fileElements[1]); //Add Username to ArrayList
						  users.get(2).add(fileElements[2]); //Add UserPassword to ArrayList
						  users.get(3).add(fileElements[3]); //Add UserType to ArrayList
						  
					}
					
					in.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//End build Arraylist for Users file
		
		String [] facilsArr = new String[facils.get(0).size()];
		facils.get(1).toArray(facilsArr);
		
		JLabel lblViewFacilityAvail = new JLabel("View Bookings & Account Status");
		lblViewFacilityAvail.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblViewFacilityAvail.setBounds(10, 11, 513, 23);
		contentPane.add(lblViewFacilityAvail);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 47, 503, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 96, 390, 189);
		contentPane.add(scrollPane);
		
		String [] timeSlotArr = new String[9];
		for(int i=0;i<timeSlotArr.length;i++)
		{
			timeSlotArr[i]=""+(i+1);
		}
		
		String [] usersArr = new String[users.get(0).size()];
		users.get(1).toArray(usersArr);
		
		JButton btnViewAccountStatement = new JButton("View Account Statement");
		btnViewAccountStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String locStringDispAvailText="User:\t Facility:\t Date:\t Paid:\n";
				String userComboxString = userName;
				userId = users.get(0).get(users.get(1).indexOf(userComboxString));
				locStringDispAvailText+=userComboxString+"\n----------------------------------------------------------------------------------------------\n";
				double ammountOwed=0;
				for(int i=0;i<bookings.get(0).size();i++)
				{
					if(bookings.get(2).get(i).equals(userId)) 
					{
						locStringDispAvailText+="\t"+facils.get(1).get(Integer.parseInt(bookings.get(1).get(i))); //Add Facility Name
						if(bookings.get(5).get(i).equals("n"))
						{
							ammountOwed+=Double.parseDouble(facils.get(2).get(Integer.parseInt(bookings.get(1).get(i))));
						}
						locStringDispAvailText+="\t"+bookings.get(3).get(i);
						locStringDispAvailText+="\t"+bookings.get(5).get(i)+"\n";
					}
				}
				locStringDispAvailText+="\n----------------------------------------------------------------------------------------------\n";
			    String amm2 = String.format("%,.2f", ammountOwed);
			    locStringDispAvailText+="Ammount Owed:"+amm2;
				dispAvailText=locStringDispAvailText;
				JTextArea txtrDisplayAvailabilty = new JTextArea();
				scrollPane.setViewportView(txtrDisplayAvailabilty);
				txtrDisplayAvailabilty.setEditable(false);
				txtrDisplayAvailabilty.setText(dispAvailText);
			}
		});
		btnViewAccountStatement.setBounds(20, 341, 179, 25);
		contentPane.add(btnViewAccountStatement);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 627, 503, 2);
		contentPane.add(separator_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
					Login.main(null);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogOut.setBounds(380, 717, 89, 23);
		contentPane.add(btnLogOut);
		
		
		
		
		
		
		
		
		
	
	
	}

}
