import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login {
	public static void main(String [] args) throws FileNotFoundException {
		String userName   = "",      userPassword   = "";
		String usernameMessage = "Please enter your username";
		String passwordMessage = "Please enter your password";
		String detailsNotFoundMessage = "Log-in details do not match records.\nPlease try again. You have " ;
		String deniedMessage = "3 failed log-ins.\nAccess denied.";
		Scanner in; 
		int chance = 1, attemptsRemaining = 3;
		boolean validInput  = false, validAccessDetails = false;

		File adminFile = new File("Users.txt");
		String fileElements[]; 
		
		ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		users.add(new ArrayList<String>()); // Add list to store UserId
		users.add(new ArrayList<String>()); // Add list to store UserName
		users.add(new ArrayList<String>()); // Add list to store UserPassword
		users.add(new ArrayList<String>()); // Add list to store UserType
		
		String lineFromFile;
		in = new Scanner(adminFile);
		String userType="";
		while (in.hasNext()) 
		{
		  lineFromFile = in.nextLine();
		  fileElements = lineFromFile.split(",");
		  users.get(0).add(fileElements[0]); //Add UserId to ArrayList
		  users.get(1).add(fileElements[1]); //Add UserName to ArrayList
		  users.get(2).add(fileElements[2]); //Add UserPass to ArrayList
		  users.get(3).add(fileElements[3]); //Add UserType to ArrayList
		  
		  
		  //allUserDetails.add(lineFromFile);	
		}	
		in.close();
		while((!(validInput)) && (chance <= 3))
		{
		  userName = JOptionPane.showInputDialog(null, usernameMessage);
		  if (userName != null)
		  {
			userPassword = JOptionPane.showInputDialog(null, passwordMessage);  
			if (userPassword != null)
			{				
			   //tempUser = adminName + "," + adminPassword;
			   for (int i=0; i<users.get(0).size();i++)
				{
				    System.out.println("Users.get(0).get("+i+")"  + users.get(0).get(i));
				    System.out.println("Users.get(1).get("+i+")"  + users.get(1).get(i));
					System.out.println("Users.get(2).get("+i+")"  + users.get(2).get(i));
					System.out.println("Users.get(3).get("+i+")"  + users.get(3).get(i));
					System.out.println("Username: "+ userName + " UserPass: "+ userPassword);
							if( (userName.equals(users.get(1).get(i)))  && (userPassword.equals(users.get(2).get(i)))  ) 
							{
								validInput = true;
								validAccessDetails = true;
								System.out.println("Success");
								userType = (users.get(3).get(i));
								
							}
						
				}//End for
			   System.out.println("End Pass-----------------");
			   
			   
				 
			   if(validAccessDetails==true) {
				   
			   }		
			   else{
				   chance += 1;
				if (chance <= 3)
				{
					attemptsRemaining--;
					JOptionPane.showMessageDialog(null, detailsNotFoundMessage + " " + attemptsRemaining + " attempts remaining", "Error", 2);	
				}
					else
					{
						JOptionPane.showMessageDialog(null, deniedMessage, "Access denied", 0);
						validInput = true;
						
					}
			   }
				}else 
					validInput = true;
				
							  }
							  else
								validInput = true;				
		}
			
		
		//int position, adminID;
		//String entryAtThisPosition;
		if (validAccessDetails)
		{
		   //position = users.indexOf(tempUser);
		   //entryAtThisPosition = allUserDetails.get(position);
		   //position = entryAtThisPosition.indexOf(",");
		   //adminID  = Integer.parseInt(entryAtThisPosition.substring(0,position));
		   JOptionPane.showMessageDialog(null, "Welcome " + userName + "!", "Log-in Successful", 1);
		   if( userType.contains("1") ) 
		   {
		   //AdminPage admin = new AdminPage();
		   AdminPage lAdmin = new AdminPage();
		   lAdmin.LaunchAdminPage(userName);
		   }else {
			   UserPage user = new UserPage();
			   user.UserPageLaunch(userName);
		   }
		}
	}
}
