import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

public class RegisterUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5733918352429639524L;
	private JPanel contentPane;
	private JTextField textUserEmail;
	public static String userName="";

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		RegisterUser.userName = userName;
	}

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser frame = new RegisterUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//End Main*/
	
	public void LaunchRegisterUser(String useName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setUserName(useName);
					RegisterUser frame = new RegisterUser();
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
	public RegisterUser() {
		String filename = "Users.txt";
		File file = new File(filename);
		//if(file.exists()) {
		//	System.out.println("File Exists");
		//}
		Scanner in;
		String fileElements[]; 
		String lineFromFile="";
		
		ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		users.add(new ArrayList<String>()); // Add list to store UserId
		users.add(new ArrayList<String>()); // Add list to store UserName
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
				  users.get(1).add(fileElements[1]); //Add UserName to ArrayList
				  users.get(2).add(fileElements[2]); //Add UserPass to ArrayList
				  users.get(3).add(fileElements[3]); //Add UserType to ArrayList
			}
			
			in.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterAUser = new JLabel("Register a User");
		lblRegisterAUser.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblRegisterAUser.setBounds(39, 11, 180, 18);
		contentPane.add(lblRegisterAUser);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 40, 290, 2);
		contentPane.add(separator);
		
		textUserEmail = new JTextField();
		textUserEmail.setBounds(39, 87, 247, 20);
		contentPane.add(textUserEmail);
		textUserEmail.setColumns(10);
		
		JLabel lblEnterUserEmail = new JLabel("Enter User Email:");
		lblEnterUserEmail.setBounds(39, 62, 124, 14);
		contentPane.add(lblEnterUserEmail);
		
		
		
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(39, 148, 247, 14);
		contentPane.add(lblPassword);
		
		JLabel lblDisplayPass = new JLabel("");
		lblDisplayPass.setBounds(39, 165, 247, 14);
		contentPane.add(lblDisplayPass);
		
		JLabel lblSuccess = new JLabel("");
		lblSuccess.setBounds(39, 226, 247, 60);
		contentPane.add(lblSuccess);
		
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
		btnBack.setBounds(240, 365, 89, 23);
		contentPane.add(btnBack);
		
		
		
		JButton btnGeneratePass = new JButton("Generate Password and Add User");
		btnGeneratePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email= textUserEmail.getText();
				String pattern = "^(.+)@(.+)$";
				if(!email.matches(pattern)) 
				{
					JOptionPane.showMessageDialog(null, "Error in email", "ERROR", JOptionPane.ERROR_MESSAGE);
					textUserEmail.setText(null);
				}else {
						
						
						int max=0, curr=0;
						for (int i=0;i<users.get(0).size();i++)
						{
							curr= Integer.parseInt(users.get(0).get(i));
							if(curr>max) 
								{
									max=curr;
								}
						
							
						
						}
						
						int userId=max+1;//Set Largest UserId from Array//Add one for next place in file
						char[] charPassWd =RandomPasswordGenerator.generatePswd(8, 12, 1, 1, 1);
						lblDisplayPass.setText((new String(charPassWd)));
						
						  users.get(0).add(Integer.toString(userId)); //Add UserId to ArrayList
						  users.get(1).add(email); //Add UserName to ArrayList
						  users.get(2).add((new String(charPassWd))); //Add UserPass to ArrayList
						  users.get(3).add("2"); //Add UserType to ArrayList
						  
						 
						  lblSuccess.setText("<html><center>"+"User Successfully added to System"+"<br>"+"To Delete New User, Hit Back and Open Menu Again"+"</center></html>");
						  
						  FileWriter aFileWriter;
						try {
							aFileWriter = new FileWriter(filename);
							PrintWriter out = new PrintWriter(aFileWriter);
							
							for (int i=0; i<users.get(0).size();i++) 
							{
								out.println(users.get(0).get(i)+","+users.get(1).get(i)+","+users.get(2).get(i)+","+users.get(3).get(i));
								System.out.println(users.get(0).get(i)+","+users.get(1).get(i)+","+users.get(2).get(i)+","+users.get(3).get(i));
								
							}
							out.close();
							aFileWriter.close();
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						  
						  
				
				
				
				
				} //End Else
				
				
				
				
			}  //End Action Performed
			
			
		});
		btnGeneratePass.setBounds(39, 115, 249, 23);
		contentPane.add(btnGeneratePass);
		String [] usersArr = new String[users.get(0).size()];
		users.get(1).toArray(usersArr);
		JComboBox<String> userComboBox = new JComboBox<String>(usersArr);
		userComboBox.setBounds(39, 328, 97, 22);
		contentPane.add(userComboBox);
		
		JButton btnCopyToClipboard = new JButton("Copy To Clipboard");
		btnCopyToClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ctc = lblDisplayPass.getText().toString();
			    StringSelection stringSelection = new StringSelection(ctc);
			    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			    clpbrd.setContents(stringSelection, null);
			}
		});
		btnCopyToClipboard.setBounds(38, 190, 248, 23);
		contentPane.add(btnCopyToClipboard);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userComboxString = String.valueOf(userComboBox.getSelectedItem());
				if(userComboxString.equals(userName)) {
					JOptionPane.showMessageDialog(null, "You Cannot Delete Yourself!", "ERROR", JOptionPane.ERROR_MESSAGE );
				}else {
					int userIdInd = Integer.parseInt(users.get(0).get(users.get(1).indexOf(userComboxString)));
					userIdInd-=1; //Adjust for Array
					System.out.println("****UserIDIndex***: "+userIdInd);
					users.get(0).remove(userIdInd);
					users.get(1).remove(userIdInd);
					users.get(2).remove(userIdInd);
					users.get(3).remove(userIdInd);
					FileWriter aFileWriter;
					try {
						aFileWriter = new FileWriter(filename);
						PrintWriter out = new PrintWriter(aFileWriter);
						
						for (int i=0; i<users.get(0).size();i++) 
						{
							out.println(users.get(0).get(i)+","+users.get(1).get(i)+","+users.get(2).get(i)+","+users.get(3).get(i));
							System.out.println(users.get(0).get(i)+","+users.get(1).get(i)+","+users.get(2).get(i)+","+users.get(3).get(i));
							
						}
						out.close();
						aFileWriter.close();
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "User Deleted.\n Please re-open menu for further administration", "Deleted", JOptionPane.INFORMATION_MESSAGE );
					AdminPage lAdmin = new AdminPage();
					   lAdmin.LaunchAdminPage(null);
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
				}
			}
		});
		btnDeleteUser.setBounds(39, 363, 97, 25);
		contentPane.add(btnDeleteUser);
		
		JLabel lblChooseUser = new JLabel("Choose User:");
		lblChooseUser.setBounds(39, 299, 97, 16);
		contentPane.add(lblChooseUser);
		
		
		
		
		
		
	}
}
