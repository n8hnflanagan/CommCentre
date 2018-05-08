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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class ViewAvailablilityofFacil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5293805036864533882L;
	private JPanel contentPane;
	String dispAvailText="";
	
	
		
	
	
	

	public String getDispAvailText() {
		return dispAvailText;
	}

	public void setDispAvailText(String dispAvailText) {
		this.dispAvailText = dispAvailText;
	}

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAvailablilityofFacil frame = new ViewAvailablilityofFacil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void LaunchViewAvailFacil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAvailablilityofFacil frame = new ViewAvailablilityofFacil();
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
	public ViewAvailablilityofFacil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 660);
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
		btnBack.setBounds(481, 577, 89, 23);
		contentPane.add(btnBack);
		
		String lineFromFile="";
		String [] fileElements;
		String filename = "Facilities.txt";
		File file = new File(filename);
		Scanner in;
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
		String [] facilArr = new String[facils.get(0).size()];
		facils.get(1).toArray(facilArr);
		JComboBox <String>facilComboBox = new JComboBox<String>(facilArr);
		facilComboBox.setBounds(45, 88, 116, 20);
		contentPane.add(facilComboBox);
		
		JLabel lblViewFacilityAvail = new JLabel("View Facility Avail");
		lblViewFacilityAvail.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblViewFacilityAvail.setBounds(10, 11, 390, 23);
		contentPane.add(lblViewFacilityAvail);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 47, 424, 2);
		contentPane.add(separator);
		
		JLabel lblChooseFacility = new JLabel("Choose Facility: ");
		lblChooseFacility.setBounds(45, 63, 116, 14);
		contentPane.add(lblChooseFacility);
		
		JDateChooser dateChooseFrom = new JDateChooser();
		dateChooseFrom.setToolTipText("Select Your Date");
		dateChooseFrom.setBounds(45, 159, 105, 20);
		contentPane.add(dateChooseFrom);
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//String dateFrom = formatter.format(dateChooseFrom.getDate());
		//ZoneId defaultZoneId = ZoneId.systemDefault();
		//Instant instant = dateFrom.toInstant();
		//LocalDate locDateFrom = instant.atZone(defaultZoneId).toLocalDate();
		//System.out.println(locDateFrom);
		//LocalDate dateFromLoc = dateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		//System.out.println(dateFromLoc);
		
		
		JDateChooser dateChooseTo = new JDateChooser();
		dateChooseTo.setBounds(196, 159, 105, 20);
		contentPane.add(dateChooseTo);
		//Date dateTo = dateChooseTo.getDate();
		
		JLabel lblFromDate = new JLabel("From Date: ");
		lblFromDate.setBounds(45, 132, 89, 14);
		contentPane.add(lblFromDate);
		
		JLabel lblToDate = new JLabel("To Date: ");
		lblToDate.setBounds(196, 132, 89, 14);
		contentPane.add(lblToDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 234, 390, 116);
		contentPane.add(scrollPane);
		
		
		
		
		JButton btnGetDates = new JButton("Get Dates");
		btnGetDates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				try {
					String facilComboxString = String.valueOf(facilComboBox.getSelectedItem());
					String locStringDispAvailText="";
					String dateFrom = formatter.format(dateChooseFrom.getDate());
					String dateTo = formatter.format(dateChooseTo.getDate());
					System.out.println(dateFrom);  
					String [] dateElems = dateFrom.split("/");
					//System.out.println(replDateFrom);  
					System.out.println(dateTo);  
					//String replDateTo = dateTo.replace("/", ",");
					LocalDate locDateFrom = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
					dateElems = dateTo.split("/");
					LocalDate locDateTo = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
					System.out.println("LocalDateFrom: "+ locDateFrom);
					System.out.println("LocalDateTo: "+ locDateTo);
					String decomDate = facils.get(3).get(facils.get(1).indexOf(facilComboxString)); 
					System.out.println("DecomDate: "+decomDate);
					dateElems = decomDate.split("-");
					//LocalDate locDecomDate=new LocalDate();
					//if(!decomDate.equals("null"))
						//{
							//locDecomDate = LocalDate.of( (Integer.parseInt( dateElems[2])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[0])));
						//}
					//System.out.println("DecomDate: "+decomDate);
					//System.out.println("DecomDate: "+locDecomDate);
					if(decomDate.equals("null"))
						{
						JOptionPane.showMessageDialog(null, "All Dates are avilable. Site has not been decommissioned", "Available", JOptionPane.INFORMATION_MESSAGE );
						}else {
							   LocalDate locDecomDate = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
							   locStringDispAvailText+="Date: |\t Available: \tUnavailable\n------------------------------------------------------------------------\n";
							   if(locDateFrom.isBefore(locDecomDate)) 
							   {
								   String daysBetweenString = ""+locDateFrom.until(locDecomDate, ChronoUnit.DAYS);
								   int daysBetweenInt=Integer.parseInt(daysBetweenString);
									for(int i=0;i<=daysBetweenInt;i++)
									{
										locStringDispAvailText+=""+locDateFrom.plusDays(i)+"\t\t"+"Unavailable\n";
									} //End For
							   }//End If Print Dates before Decom
							   
							   if(locDateTo.isAfter(locDecomDate)) 
							   {
								   //System.out.println("if date is After");
								   //System.out.println(locDateFrom.compareTo(locDecomDate));
								   String daysBetweenString = ""+locDecomDate.until(locDateTo, ChronoUnit.DAYS);
								   int daysBetweenInt=Integer.parseInt(daysBetweenString);
									for(int i=1;i<=daysBetweenInt;i++)
									{
										locStringDispAvailText+=""+locDecomDate.plusDays(i)+"\t"+"Available\n";
										System.out.println("if date is After/For Loop"+locDecomDate.plusDays(i) );
									} //End For
							   }//End If Print Dates After Decom
							   //daysBetween = locDecomDate.until(locDecomDate);
							   if(locDateFrom.isEqual(locDateTo) && locDateFrom.isEqual(locDecomDate)) 
							   {
								   System.out.println("if date is the same");
										locStringDispAvailText+=""+"\t\t|"+"Unavailable(Decommissioned)";
									
							   }//End If Print Dates After Decom*/
							   locStringDispAvailText+="\n------------------------------------------------------------------------";
							   setDispAvailText(locStringDispAvailText);
							   
							   JLabel lblDecomDate = new JLabel("");
								lblDecomDate.setBounds(45, 394, 116, 16);
								contentPane.add(lblDecomDate);
								lblDecomDate.setText(""+locDecomDate);
							   
							   
							   
						} //End If No Decom Date
					JTextArea txtrDisplayAvailabilty = new JTextArea();
					scrollPane.setViewportView(txtrDisplayAvailabilty);
					txtrDisplayAvailabilty.setEditable(false);
					txtrDisplayAvailabilty.setText(dispAvailText);
					
					
					
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "One of the Date fields is blank. Please select a date", "ERROR", JOptionPane.ERROR_MESSAGE );
					//e.printStackTrace();
				}
				
			} //End Action Performed Get Date
		});
		btnGetDates.setBounds(45, 200, 89, 23);
		contentPane.add(btnGetDates);
		
		JLabel lblDecommissionRecommissionDate = new JLabel("Decommission/Recommission Date");
		lblDecommissionRecommissionDate.setBounds(45, 438, 218, 14);
		contentPane.add(lblDecommissionRecommissionDate);
		
		JDateChooser dateChooseDecom = new JDateChooser();
		dateChooseDecom.setToolTipText("Select Your Date");
		dateChooseDecom.setBounds(45, 465, 105, 20);
		contentPane.add(dateChooseDecom);
		
		JButton btnDecommissionRecommission = new JButton("Decommission / Recommission");
		btnDecommissionRecommission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				try {
					String locStringDispAvailText="";
					String dateToSetDecom = formatter.format(dateChooseDecom.getDate());
					
					System.out.println("Date To Set Decom: "+dateToSetDecom);  
					String [] dateElems = dateToSetDecom.split("/");
					
					LocalDate locDateToSetDecom = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
					System.out.println("LocalDateToSetDecom: "+ locDateToSetDecom);
					String StrlocDateToSetDecom = ""+locDateToSetDecom;
					String facilComboxString = String.valueOf(facilComboBox.getSelectedItem());
					String decomDate = facils.get(3).get(facils.get(1).indexOf(facilComboxString));
					System.out.println("DecomDate: "+decomDate);
					
					if(decomDate.equals("null")) {
						facils.get(3).set(facils.get(1).indexOf(facilComboxString),StrlocDateToSetDecom); 
						System.out.println("New Decom Date"+(facils.get(3).get(facils.get(1).indexOf(facilComboxString))));
						locStringDispAvailText="Site Decommissioned for Date:"+locDateToSetDecom;
						setDispAvailText(locStringDispAvailText);
						JTextArea txtrDisplayAvailabilty = new JTextArea();
						scrollPane.setViewportView(txtrDisplayAvailabilty);
						txtrDisplayAvailabilty.setEditable(false);
						txtrDisplayAvailabilty.setText(dispAvailText);
						FileWriter aFileWriter;
						try {
							aFileWriter = new FileWriter(filename);
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
						}
					}
					else{   
						    dateElems = decomDate.split("-");
							for(String e : dateElems) 
							{
							System.out.println("In Loop");	
							System.out.println(e);
							}
							LocalDate locDecomDate = LocalDate.of( (Integer.parseInt( dateElems[0])), (Integer.parseInt( dateElems[1])),(Integer.parseInt( dateElems[2])));
							
					        if(locDateToSetDecom.isEqual(locDecomDate))
							{
					        	FileWriter aFileWriter;
					        	try {
									aFileWriter = new FileWriter(filename);
									PrintWriter out = new PrintWriter(aFileWriter);
									facils.get(3).set(facils.get(1).indexOf(facilComboxString),"null");
									for (int i=0; i<facils.get(0).size();i++) 
									{
										out.println(facils.get(0).get(i)+","+facils.get(1).get(i)+","+facils.get(2).get(i)+","+facils.get(3).get(i));
										System.out.println(facils.get(0).get(i)+","+facils.get(1).get(i)+","+facils.get(2).get(i)+","+facils.get(3).get(i));
										
									}
									out.close();
									aFileWriter.close();
									
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							JOptionPane.showMessageDialog(null, "Site has been Recommissioned.\nCheck Dates Again.", "Recommissioned", JOptionPane.INFORMATION_MESSAGE );
							setDispAvailText("");
							JLabel lblDecomDate = new JLabel("");
							lblDecomDate.setBounds(45, 394, 116, 16);
							contentPane.add(lblDecomDate);
							lblDecomDate.setText("");
							}else 
								{
								FileWriter aFileWriter;
					        	try {
									aFileWriter = new FileWriter(filename);
									PrintWriter out = new PrintWriter(aFileWriter);
									facils.get(3).set(facils.get(1).indexOf(facilComboxString),""+locDateToSetDecom);
									for (int i=0; i<facils.get(0).size();i++) 
									{
										out.println(facils.get(0).get(i)+","+facils.get(1).get(i)+","+facils.get(2).get(i)+","+facils.get(3).get(i));
										System.out.println(facils.get(0).get(i)+","+facils.get(1).get(i)+","+facils.get(2).get(i)+","+facils.get(3).get(i));
										
									}
									out.close();
									aFileWriter.close();
									
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					        	JOptionPane.showMessageDialog(null, "Site has been Decommissioned.\nCheck Dates Again.", "Decommissioned", JOptionPane.INFORMATION_MESSAGE );
					        	
					        	System.out.println(dispAvailText);
						   
								} //End If No Decom Date
					JTextArea txtrDisplayAvailabilty = new JTextArea();
					scrollPane.setViewportView(txtrDisplayAvailabilty);
					txtrDisplayAvailabilty.setEditable(false);
					txtrDisplayAvailabilty.setText(dispAvailText);
					
					
					
					}
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Date field is blank. Please select a date", "ERROR", JOptionPane.ERROR_MESSAGE );
					//e.printStackTrace();
				}
			}// End ActionListener Decommission/Recommission
		});
		btnDecommissionRecommission.setBounds(45, 513, 218, 25);
		contentPane.add(btnDecommissionRecommission);
		
		JLabel lblDecommisionDate = new JLabel("Decommisioned Date:");
		lblDecommisionDate.setBounds(45, 374, 218, 16);
		contentPane.add(lblDecommisionDate);
		
		
		
		
		
		
	
		
		
		
		
		
		
	
	} //End JFrame
}
