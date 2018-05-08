import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class AdminPage {

	private JFrame frame;
	public static String useName ="";
	public static String getUseName() {
		return useName;
	}
	public static void setUseName(String useName) {
		AdminPage.useName = useName;
	}
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
    public void LaunchAdminPage(String userName){
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setUseName(userName);
					AdminPage window = new AdminPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 500, 600, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(25, 30);
		
		JLabel lblHeading = new JLabel("Community Centre Admin Page");
		lblHeading.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblHeading.setBounds(39, 11, 329, 29);
		frame.getContentPane().add(lblHeading);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(49, 45, 457, 3);
		frame.getContentPane().add(separator);
		
		JButton btnRegister = new JButton("Register / Delete a user");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterUser lRegUser = new RegisterUser();
				lRegUser.LaunchRegisterUser(useName);
				frame.dispose();
			}
		});
		btnRegister.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnRegister.setBounds(59, 63, 447, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnAddNewFacility = new JButton("Add New Facility");
		btnAddNewFacility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNewFacility lAddNewF = new AddNewFacility();
				lAddNewF.LaunchAddNewFacil();
				frame.dispose();
			}
		});
		btnAddNewFacility.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAddNewFacility.setBounds(59, 97, 447, 23);
		frame.getContentPane().add(btnAddNewFacility);
		
		JButton btnViewFacilityAvailability = new JButton("View Facility Availability and De/Recommission");
		btnViewFacilityAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAvailablilityofFacil lAvailFacil = new ViewAvailablilityofFacil();
				lAvailFacil.LaunchViewAvailFacil();
				frame.dispose();
			}
		});
		btnViewFacilityAvailability.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnViewFacilityAvailability.setBounds(59, 131, 447, 23);
		frame.getContentPane().add(btnViewFacilityAvailability);
		
		JButton btnViewBookingsFor = new JButton("");
		btnViewBookingsFor.setText("<html><center>"+"View Bookings For Facility and Remove Facility"+"<br>"+"and Account Status"+"</center></html>");
		btnViewBookingsFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBookingsForFacility lViewBooksFacils = new ViewBookingsForFacility();
				lViewBooksFacils.LaunchViewBooksFacil();
				frame.dispose();
			}
		});
		btnViewBookingsFor.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnViewBookingsFor.setBounds(59, 165, 447, 49);
		frame.getContentPane().add(btnViewBookingsFor);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Login.main(null);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogOut.setBounds(388, 490, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(473, 615, 97, 25);
		frame.getContentPane().add(btnExit);
	}
}
