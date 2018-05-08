import java.awt.Color;
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
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class AddNewFacility extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2948570845314717751L;
	private JPanel contentPane;
	private JTextField txtFldFacilName;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewFacility frame = new AddNewFacility();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void LaunchAddNewFacil () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewFacility frame = new AddNewFacility();
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
	public AddNewFacility() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
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
		btnBack.setBounds(335, 402, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblAddNewFacility = new JLabel("Add New Facility");
		lblAddNewFacility.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblAddNewFacility.setBounds(10, 11, 242, 23);
		contentPane.add(lblAddNewFacility);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 45, 286, 2);
		contentPane.add(separator);
		
		txtFldFacilName = new JTextField();
		txtFldFacilName.setBounds(44, 81, 286, 20);
		contentPane.add(txtFldFacilName);
		txtFldFacilName.setColumns(10);
		
		JLabel lblEnterFacilityName = new JLabel("Enter Facility Name:");
		lblEnterFacilityName.setBackground(Color.WHITE);
		lblEnterFacilityName.setBounds(44, 58, 140, 14);
		contentPane.add(lblEnterFacilityName);
		
		JLabel lblFacilityAssignedSuccessfully = new JLabel("");
		lblFacilityAssignedSuccessfully.setBounds(44, 287, 177, 14);
		contentPane.add(lblFacilityAssignedSuccessfully);
		
		String [] prices2 = {"100.00","50.00","25.00","10.00","5.00"};
		JComboBox<String> priceComboBox = new JComboBox<String>(prices2);
		priceComboBox.setBounds(44, 137, 116, 20);
		contentPane.add(priceComboBox);
		
		JLabel lblSetPriceFor = new JLabel("Set Price for Facility");
		lblSetPriceFor.setBounds(44, 112, 116, 14);
		contentPane.add(lblSetPriceFor);
		
		JButton btnSetFacitilyName = new JButton("Set Details");
		btnSetFacitilyName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "Facilities.txt";
				File file = new File(filename);
				//if(file.exists()) {
				//	System.out.println("File Exists");
				//}
				Scanner in;
				String fileElements[]; 
				String lineFromFile="";
				
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
			if(facils.get(1).contains(txtFldFacilName.getText()))
					{
						JOptionPane.showMessageDialog(null, "Facility Already Exists", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						String price = String.valueOf(priceComboBox.getSelectedItem());
						System.out.println(price);
						
						int max=0, curr=0;
						for (int i=0;i<facils.get(0).size();i++)
						{
							curr= Integer.parseInt(facils.get(0).get(i));
							if(curr>max) 
								{
									max=curr;
								}
						
							
						
						}
						
						int intFacId=max+1;//Set Largest UserId from Array//Add one for next place in file
						
						  facils.get(0).add(Integer.toString(intFacId)); //Add UserId to ArrayList
						  facils.get(1).add(txtFldFacilName.getText()); //Add UserName to ArrayList
						  facils.get(2).add(price); //Add UserPass to ArrayList
						  facils.get(3).add("null"); //Add UserType to ArrayList
						  
						  lblFacilityAssignedSuccessfully.setText("Facility Successfully added to System");
						  
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
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			
			} // End Action performed
		});
		btnSetFacitilyName.setBounds(44, 320, 177, 23);
		contentPane.add(btnSetFacitilyName);	
		}
	}
