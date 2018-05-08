import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class ViewBookingsForFacility extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8510218687826906788L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	public static ArrayList<ArrayList<String>> slots = new ArrayList<ArrayList<String>>(); 
	public static String dispAvailText="";
	public static String fileBookId="";
	public static String fileFacilId="";
	public static String userId="";
	public static String dateForFile="";
	public static String slotForFile="";
	public static String paymentReceived="";
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBookingsForFacility frame = new ViewBookingsForFacility();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void LaunchViewBooksFacil () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBookingsForFacility frame = new ViewBookingsForFacility();
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
	public ViewBookingsForFacility() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage lAdmin = new AdminPage();
				   lAdmin.LaunchAdminPage(null);
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
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
		JComboBox <String>facilComboBox = new JComboBox<String>(facilsArr);
		facilComboBox.setBounds(45, 88, 116, 20);
		contentPane.add(facilComboBox);
		
		JLabel lblViewFacilityAvail = new JLabel("View Bookings & Account Status");
		lblViewFacilityAvail.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblViewFacilityAvail.setBounds(10, 11, 513, 23);
		contentPane.add(lblViewFacilityAvail);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 47, 503, 2);
		contentPane.add(separator);
		
		JLabel lblChooseFacility = new JLabel("Choose Facility: ");
		lblChooseFacility.setBounds(45, 63, 116, 14);
		contentPane.add(lblChooseFacility);
		
		JDateChooser dateChoose = new JDateChooser();
		dateChoose.setToolTipText("Select Your Date");
		dateChoose.setBounds(45, 159, 105, 20);
		contentPane.add(dateChoose);
		//Date dateTo = dateChooseTo.getDate();
		
		JLabel lblChooseDate = new JLabel("Choose Date:");
		lblChooseDate.setBounds(45, 132, 89, 14);
		contentPane.add(lblChooseDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 234, 390, 189);
		contentPane.add(scrollPane);
		
		
		
		
		JButton btnGetDates = new JButton("View Booking Time Slots");
		btnGetDates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				try {
					String facilComboxString = String.valueOf(facilComboBox.getSelectedItem());
					String locStringDispAvailText="";
					String strDateChoose = formatter.format(dateChoose.getDate());
					//String dateTo = formatter.format(dateChoose.getDate());
					System.out.println(strDateChoose);  
					String [] dateElems = strDateChoose.split("/");
					//System.out.println(replDateFrom);  
					//System.out.println(dateTo);  
					//String replDateTo = dateTo.replace("/", ",");
					LocalDate locDateChoose = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
					dateForFile=""+locDateChoose;
					//dateElems = dateTo.split("/");
					//LocalDate locDateTo = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
					System.out.println("LocalDateChoose: "+ locDateChoose);
					//System.out.println("LocalDateTo: "+ locDateTo);
					String decomDate = facils.get(3).get(facils.get(1).indexOf(facilComboxString));
					System.out.println("DecomDate: "+decomDate);
					dateElems = decomDate.split("-");
					System.out.println("Before If Statement: ");
					
					if(decomDate.equals("null"))
						{
							//JOptionPane.showMessageDialog(null, "All Dates are avilable. Choose your time slots below", "Available", JOptionPane.INFORMATION_MESSAGE );
							//String facilComboxString = String.valueOf(facilComboBox.getSelectedItem());
							String facilId = facils.get(0).get(facils.get(1).indexOf(facilComboxString));
							fileFacilId = facils.get(0).get(facils.get(1).indexOf(facilComboxString));
							locStringDispAvailText+="Date: "+"                Slots:\t Available:\t Paid:\n"+locDateChoose+"\n------------------------------------------------------------------------\n";
							System.out.println(bookings.size());
							for(int i=0; i<bookings.get(0).size();i++) {
								System.out.println("bookings get3 get i"+(bookings.get(3).get(i)));
								String bookingFacilId = bookings.get(1).get(i);
								String bookEls [] = bookings.get(3).get(i).split("-");
								System.out.println("bookEls0: "+Integer.parseInt(bookEls[0]));
								System.out.println("LocaldatebookEls of: "+(LocalDate.of(Integer.parseInt(bookEls[0]), Integer.parseInt(bookEls[2]), Integer.parseInt(bookEls[2]))));
								System.out.println("LocDateChoose: " + locDateChoose);
								System.out.println("FacilId: "+facilId+" bookingFacilId: "+bookingFacilId);
								System.out.println("facil Id equals bookFacilID?: "+facilId.equals(bookingFacilId));
								System.out.println("Loc Date is equal?: "+locDateChoose.isEqual( (LocalDate.of(Integer.parseInt(bookEls[0]), Integer.parseInt(bookEls[1]), Integer.parseInt(bookEls[2])))));
								
								if(facilId.equals(bookingFacilId) && locDateChoose.isEqual( (LocalDate.of(Integer.parseInt(bookEls[0]), Integer.parseInt(bookEls[1]), Integer.parseInt(bookEls[2])))))
										{
											System.out.println("Slots Add get4 get i: "+bookings.get(4).get(i));
											slots.get(0).add(bookings.get(4).get(i));
											slots.get(1).add(bookings.get(5).get(i));
										}
								} // End For to Add Taken slots
							System.out.println("Slots: "+slots);
							for(int i=1;i<=9;i++) 
							{
								//String paid ="";
								
								if(slots.get(0).contains( (Integer.toString(i)))  ) 
								{
									int slotIndex= slots.get(0).indexOf((Integer.toString(i)));
									locStringDispAvailText+="               "+"\t "+i+" \t Unavailable"+"\t "+slots.get(1).get(slotIndex)+"\n";
								}else {
									locStringDispAvailText+="               "+"\t "+i+" \t Available\n";
								}
							} //End For Slots
							slots.get(0).clear();
							slots.get(1).clear();
							System.out.println("Slots: "+slots);
							dispAvailText=locStringDispAvailText;
							JTextArea txtrDisplayAvailabilty = new JTextArea();
							scrollPane.setViewportView(txtrDisplayAvailabilty);
							txtrDisplayAvailabilty.setEditable(false);
							txtrDisplayAvailabilty.setText(dispAvailText);
							System.out.println("End*********************************\n");
						}else {/**/
								System.out.println("In the Else statement");
							
								
							   LocalDate locDecomDate = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
							   
							   //locStringDispAvailText+="Date: \t Available: \tUnavailable\n------------------------------------------------------------------------\n";
							   if(locDateChoose.isBefore(locDecomDate)) 
							   {
								   JOptionPane.showMessageDialog(null, "Site is Decommissioned until "+ locDecomDate+" \nChoose Later Date!", "Choose Later Date", JOptionPane.INFORMATION_MESSAGE );
							   }//End If Print Dates before Decom
							   
							   if(locDateChoose.isAfter(locDecomDate)) 
							   {
								   String facilId = facils.get(0).get(facils.get(1).indexOf(facilComboxString));
								   fileFacilId = facils.get(0).get(facils.get(1).indexOf(facilComboxString));
									locStringDispAvailText+="Date:"+locDateChoose+"\t Slots: \t Available:\n------------------------------------------------------------------------\n";
									System.out.println(bookings.size());
									for(int i=0; i<bookings.get(0).size();i++) {
										System.out.println("bookings get3 get i"+(bookings.get(3).get(i)));
										String bookingFacilId = bookings.get(1).get(i);
										String bookEls [] = bookings.get(3).get(i).split("-");
										System.out.println("bookEls0: "+Integer.parseInt(bookEls[0]));
										System.out.println("LocaldatebookEls of: "+(LocalDate.of(Integer.parseInt(bookEls[0]), Integer.parseInt(bookEls[2]), Integer.parseInt(bookEls[2]))));
										System.out.println("LocDateChoose: " + locDateChoose);
										System.out.println("FacilId: "+facilId+" bookingFacilId: "+bookingFacilId);
										System.out.println("facil Id equals bookFacilID?: "+facilId.equals(bookingFacilId));
										System.out.println("Loc Date is equal?: "+locDateChoose.isEqual( (LocalDate.of(Integer.parseInt(bookEls[0]), Integer.parseInt(bookEls[1]), Integer.parseInt(bookEls[2])))));
										
										if(facilId.equals(bookingFacilId) && locDateChoose.isEqual( (LocalDate.of(Integer.parseInt(bookEls[0]), Integer.parseInt(bookEls[1]), Integer.parseInt(bookEls[2])))))
										{
											System.out.println("Slots Add get4 get i: "+bookings.get(4).get(i));
											slots.get(0).add(bookings.get(4).get(i));
											slots.get(1).add(bookings.get(5).get(i));
										}
								} // End For to Add Taken slots
							System.out.println("Slots: "+slots);
							for(int i=1;i<=9;i++) 
							{
								//String paid ="";
								
								if(slots.get(0).contains( (Integer.toString(i)))  ) 
								{
									int slotIndex= slots.get(0).indexOf((Integer.toString(i)));
									locStringDispAvailText+="               "+"\t "+i+" \t Unavailable\n"+"\t "+slots.get(1).get(slotIndex);
								}else {
									locStringDispAvailText+="               "+"\t "+i+" \t Available\n";
								}
									} //End For Slots
									slots.clear();
									System.out.println("Slots: "+slots);
									dispAvailText=locStringDispAvailText;
									JTextArea txtrDisplayAvailabilty = new JTextArea();
									scrollPane.setViewportView(txtrDisplayAvailabilty);
									txtrDisplayAvailabilty.setEditable(false);
									txtrDisplayAvailabilty.setText(dispAvailText);
									System.out.println("End*********************************\n");
							   }//End If Booking Dates After Decom
							   
							   //daysBetween = locDecomDate.until(locDecomDate);
							   if(locDateChoose.isEqual(locDecomDate) ) 
							   {
								   JOptionPane.showMessageDialog(null, "Site is Decommissioned until "+ locDecomDate+" \nChoose Later Date!", "Choose Later Date", JOptionPane.INFORMATION_MESSAGE );
									
							   }//End If Bookings date equals Decom date
							   locStringDispAvailText+="\n------------------------------------------------------------------------";
							   //setDispAvailText(locStringDispAvailText);
							   
							   JLabel lblDecomDate = new JLabel("");
								lblDecomDate.setBounds(45, 394, 116, 16);
								contentPane.add(lblDecomDate);
								lblDecomDate.setText(""+locDecomDate);
							   
							   
							   
						} //End ElseIf No Decom Date
					/*
					JTextArea txtrDisplayAvailabilty = new JTextArea();
					scrollPane.setViewportView(txtrDisplayAvailabilty);
					txtrDisplayAvailabilty.setEditable(false);
					txtrDisplayAvailabilty.setText(dispAvailText);*/
						
					
					
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "One of the Date fields is blank. Please select a date", "ERROR", JOptionPane.ERROR_MESSAGE );
					//e.printStackTrace();
				}
				
			} //End Action Performed Get Date
		});
		btnGetDates.setBounds(45, 200, 179, 23);
		contentPane.add(btnGetDates);
		
		JLabel lblChooseTimeSlot = new JLabel("Choose Time Slot: ");
		lblChooseTimeSlot.setBounds(45, 425, 116, 14);
		contentPane.add(lblChooseTimeSlot);
		
		String [] timeSlotArr = new String[9];
		for(int i=0;i<timeSlotArr.length;i++)
		{
			timeSlotArr[i]=""+(i+1);
		}
		JComboBox <String>timeSlotComboBox = new JComboBox<String>(timeSlotArr);
		timeSlotComboBox.setBounds(45, 451, 116, 20);
		contentPane.add(timeSlotComboBox);
		
		String [] usersArr = new String[users.get(0).size()];
		users.get(1).toArray(usersArr);
		JComboBox<String> userComboBox = new JComboBox<String>(usersArr);
		userComboBox.setBounds(192, 451, 140, 20);
		contentPane.add(userComboBox);
		
		JRadioButton rdbtnPaymentReceived = new JRadioButton("Payment Received");
		rdbtnPaymentReceived.setBounds(45, 480, 133, 25);
		contentPane.add(rdbtnPaymentReceived);
		
		JLabel lblChooseUser = new JLabel("Choose User: ");
		lblChooseUser.setBounds(192, 425, 140, 14);
		contentPane.add(lblChooseUser);
		
		
		JButton btnBookSlot = new JButton("Book Slot");
		btnBookSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fileFacilId.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Booking Time must be Viewed Before booking\n Click View Booking Time Slots", "ERROR", JOptionPane.ERROR_MESSAGE );
				}else{
						String userComboxString = String.valueOf(userComboBox.getSelectedItem());
						userId = users.get(0).get(users.get(1).indexOf(userComboxString));
						slotForFile = String.valueOf(timeSlotComboBox.getSelectedItem());
						System.out.println("Slot For File: "+slotForFile);
						System.out.println("UserId: "+userId);
						if(rdbtnPaymentReceived.isSelected()) 
						{
							paymentReceived="y";
						}else {
							paymentReceived="n";
						}
						//Set Booking Id to max number
						int max=0, curr=0;
						for (int i=0;i<bookings.get(0).size();i++)
						{
							curr= Integer.parseInt(bookings.get(0).get(i));
							if(curr>max) 
								{
									max=curr;
								}
						} //End find max number for loop
						
						int bookId=max+1;//Set Largest UserId from Array//Add one for next place in file
						int bookArrSize=bookings.get(0).size();
						boolean canWrite =true;
						for(int i=0;i<bookArrSize;i++) 
						{
						  if(bookings.get(1).get(i).contains(fileFacilId)&&bookings.get(3).get(i).contains(dateForFile)&&bookings.get(4).get(i).contains(slotForFile))
						  {
							  canWrite =false;
							  System.out.println("CanWriteChecked and Value:"+canWrite);
						  }
						}
						fileBookId=Integer.toString(bookId);
						
						
						System.out.println("CanWrite Value:"+canWrite);
						
						if(canWrite==false) //Boolean True/False
						{
							JOptionPane.showMessageDialog(null, "Slot is already taken", "ERROR", JOptionPane.ERROR_MESSAGE );
						}else {
							bookings.get(0).add(fileBookId);
							bookings.get(1).add(fileFacilId);
							bookings.get(2).add(userId);
							bookings.get(3).add(dateForFile);
							bookings.get(4).add(slotForFile);
							bookings.get(5).add(paymentReceived);
						//Begin FileWriting
						FileWriter aFileWriter;
						try {
							aFileWriter = new FileWriter(fileBookings);
							PrintWriter out = new PrintWriter(aFileWriter);
							
							for (int i=0; i<bookings.get(0).size();i++) 
							{
								out.println(bookings.get(0).get(i)+","+bookings.get(1).get(i)+","+bookings.get(2).get(i)+","+bookings.get(3).get(i)+","+bookings.get(4).get(i)+","+bookings.get(5).get(i) );
								System.out.println(bookings.get(0).get(i)+","+bookings.get(1).get(i)+","+bookings.get(2).get(i)+","+bookings.get(3).get(i)+","+bookings.get(4).get(i)+","+bookings.get(5).get(i));
								
							}
							out.close();
							aFileWriter.close();
							JLabel lblDecomDate = new JLabel("");
							lblDecomDate.setBounds(45, 394, 116, 16);
							contentPane.add(lblDecomDate);
							lblDecomDate.setText("---------");
							JOptionPane.showMessageDialog(null, "Booking Confirmed \nClick View Booking Time Slots To See Updated Info!", "Confirmed", JOptionPane.INFORMATION_MESSAGE );
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//End File Writing
						}//End File writing Else
						}//End Else for View Booking Time Slots not clicked
			} //End Book Slot Listener
		});
		btnBookSlot.setBounds(45, 518, 116, 25);
		contentPane.add(btnBookSlot);
		
		JButton btnRemoveFacility = new JButton("Remove Facility");
		btnRemoveFacility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileFacilId.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Facility Must Be Selected\n Click View Booking Time Slots", "ERROR", JOptionPane.ERROR_MESSAGE );
				}else {
					if(bookings.get(1).contains(fileFacilId))
					{
						JOptionPane.showMessageDialog(null, "Facility has bookings and cannot be deleted", "ERROR", JOptionPane.ERROR_MESSAGE );
					}else {
						int facilIdtoDelete = Integer.parseInt(facils.get(0).get(facils.get(0).indexOf(fileFacilId)));
						facilIdtoDelete-=1;
						System.out.println(facilIdtoDelete);
						facils.get(0).remove(facilIdtoDelete);
						facils.get(1).remove(facilIdtoDelete);
						facils.get(2).remove(facilIdtoDelete);
						facils.get(3).remove(facilIdtoDelete);
						FileWriter aFileWriter;
						try {
							aFileWriter = new FileWriter(filefacils);
							PrintWriter out = new PrintWriter(aFileWriter);
							
							for (int i=0; i<facils.get(0).size();i++) 
							{
								out.println(facils.get(0).get(i)+","+facils.get(1).get(i)+","+facils.get(2).get(i)+","+facils.get(3).get(i));
								System.out.println(facils.get(0).get(i)+","+facils.get(1).get(i)+","+facils.get(2).get(i)+","+facils.get(3).get(i));
								
							}
							out.close();
							aFileWriter.close();
							JLabel lblDecomDate = new JLabel("");
							lblDecomDate.setBounds(45, 394, 116, 16);
							contentPane.add(lblDecomDate);
							lblDecomDate.setText("---------");
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//End File Writer
						JOptionPane.showMessageDialog(null, "Facility Deleted.\n Please re-open menu for further administration", "Deleted", JOptionPane.INFORMATION_MESSAGE );
						AdminPage lAdmin = new AdminPage();
						   lAdmin.LaunchAdminPage(null);
						JComponent comp = (JComponent) e.getSource();
						  Window win = SwingUtilities.getWindowAncestor(comp);
						  win.dispose();
						
						
					}
				}
			}
		});
		btnRemoveFacility.setBounds(334, 556, 189, 25);
		contentPane.add(btnRemoveFacility);
		
		JButton btnRemoveSlot = new JButton("Remove Slot");
		btnRemoveSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fileFacilId.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Facility Must Be Selected\n Click View Booking Time Slots", "ERROR", JOptionPane.ERROR_MESSAGE );
				}else {
						int bookArrSize=bookings.get(0).size();
						boolean canWrite =false;
						int bookIdtoDelete=0;;
						for(int i=0;i<bookArrSize;i++) 
						{
						  if(bookings.get(1).get(i).contains(fileFacilId)&&bookings.get(3).get(i).contains(dateForFile)&&bookings.get(4).get(i).contains(slotForFile))
						  {
							  canWrite =true;
							  System.out.println("CanWriteChecked and Value:"+canWrite);
							  bookIdtoDelete=i;
							  System.out.println("BookIdtoDelete: "+bookIdtoDelete);
						  }
						}
						if(canWrite==false) //Boolean True/False
						{
							JOptionPane.showMessageDialog(null, "Slot does not exist", "ERROR", JOptionPane.ERROR_MESSAGE );
						}else {
							
							//bookIdtoDelete-=1;
							System.out.println("*******************BookId to Delete: "+bookIdtoDelete);
							bookings.get(0).remove(bookIdtoDelete);
							bookings.get(1).remove(bookIdtoDelete);
							bookings.get(2).remove(bookIdtoDelete);
							bookings.get(3).remove(bookIdtoDelete);
							bookings.get(4).remove(bookIdtoDelete);
							bookings.get(5).remove(bookIdtoDelete);
						//Begin FileWriting
						FileWriter aFileWriter;
						try {
							aFileWriter = new FileWriter(fileBookings);
							PrintWriter out = new PrintWriter(aFileWriter);
							
							for (int i=0; i<bookings.get(0).size();i++) 
							{
								out.println(bookings.get(0).get(i)+","+bookings.get(1).get(i)+","+bookings.get(2).get(i)+","+bookings.get(3).get(i)+","+bookings.get(4).get(i)+","+bookings.get(5).get(i) );
								System.out.println(bookings.get(0).get(i)+","+bookings.get(1).get(i)+","+bookings.get(2).get(i)+","+bookings.get(3).get(i)+","+bookings.get(4).get(i)+","+bookings.get(5).get(i));
								
							}
							out.close();
							aFileWriter.close();
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "Booking Deleted.\n Please re-book or view further bookings", "Deleted", JOptionPane.INFORMATION_MESSAGE );
						
						}//End Else Can Write
				} //End Else facil Id blank
			} //End Action Listener
		});
		btnRemoveSlot.setBounds(45, 556, 116, 25);
		contentPane.add(btnRemoveSlot);
		
		JButton btnUpdatePayment = new JButton("Update Payment");
		btnUpdatePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fileFacilId.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Facility Must Be Selected\n Click View Booking Time Slots", "ERROR", JOptionPane.ERROR_MESSAGE );
				}else {
						int bookArrSize=bookings.get(0).size();
						slotForFile = String.valueOf(timeSlotComboBox.getSelectedItem());
						boolean canWrite =false;
						int bookIdtoUpdate=0;
						for(int i=0;i<bookArrSize;i++) 
						{
						  if(bookings.get(1).get(i).contains(fileFacilId)&&bookings.get(3).get(i).contains(dateForFile)&&bookings.get(4).get(i).contains(slotForFile))
						  {
							  canWrite =true;
							  System.out.println("CanWriteChecked and Value:"+canWrite);
							  bookIdtoUpdate=i;
							  if(rdbtnPaymentReceived.isSelected()) 
								{
									paymentReceived="y";
								}else {
									paymentReceived="n";
								}
							  
							  System.out.println("Bookings get 5 get I: "+ bookings.get(5).get(i));
						  }
						}
						if(canWrite==false) //Boolean True/False
						{
							JOptionPane.showMessageDialog(null, "Slot does not exist", "ERROR", JOptionPane.ERROR_MESSAGE );
						}else {
							
							bookings.get(5).set(bookIdtoUpdate, paymentReceived);	
						//Begin FileWriting
						FileWriter aFileWriter;
						try {
							aFileWriter = new FileWriter(fileBookings);
							PrintWriter out = new PrintWriter(aFileWriter);
							
							for (int i=0; i<bookings.get(0).size();i++) 
							{
								out.println(bookings.get(0).get(i)+","+bookings.get(1).get(i)+","+bookings.get(2).get(i)+","+bookings.get(3).get(i)+","+bookings.get(4).get(i)+","+bookings.get(5).get(i) );
								System.out.println(bookings.get(0).get(i)+","+bookings.get(1).get(i)+","+bookings.get(2).get(i)+","+bookings.get(3).get(i)+","+bookings.get(4).get(i)+","+bookings.get(5).get(i));
								
							}
							out.close();
							aFileWriter.close();
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "Payment Updated.\n Please review bookings", "Deleted", JOptionPane.INFORMATION_MESSAGE );
						
						}//End Else Can Write
				} //End Else facil Id blank
				
				
			}//End Action Performed Update Payment
		});//End Action Listener Update Payment
		btnUpdatePayment.setBounds(192, 484, 140, 25);
		contentPane.add(btnUpdatePayment);
		
		JButton btnViewAccountStatement = new JButton("View Account Statement");
		btnViewAccountStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String locStringDispAvailText="User:\t Facility:\t Date:\t Paid:\n";
				String userComboxString = String.valueOf(userComboBox.getSelectedItem());
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
		btnViewAccountStatement.setBounds(344, 449, 179, 25);
		contentPane.add(btnViewAccountStatement);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 627, 503, 2);
		contentPane.add(separator_1);
		
		
		
		
		
		
		
		
		
	
	} //End JFrame
}


