package db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class SetFish implements Animal{
	public static String name;
	public static String color;
	public static int price;
	

    public static Statement stmt;
    public static ResultSet rs;
	
    
	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver"); 
		java.sql.Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/javadb","root","13579abc"); 
				  
				
			
				Scanner in = new Scanner(System.in);
		    	System.out.print("Name of Fish: ");
		    	name = in.nextLine();
		    	
		        
		        System.out.print("Input a color: ");
		        color = in.nextLine();
		        
		        System.out.print("Input a price: ");
		        price = in.nextInt();
		          
		        System.out.println("Your fish is "+name+ " with "+color+" colour.");
		        in.close();
				
		        String query = "INSERT INTO `fish` (`name`, `color`,`price`) VALUES (?,?,?)";
		        
				// create the mysql insert preparedstatement
			    PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
			    preparedStmt.setString (1, name);
			    preparedStmt.setString (2, color);;
			    preparedStmt.setInt    (3, price);

			    // execute the preparedstatement
			    preparedStmt.execute();
			    
				while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
				con.close();  
				}catch(Exception e){ System.out.println(e);
				e.printStackTrace();
				return;
				}   
		
		}
	
	
	
	@Override
	public void Swim() {
		// TODO Auto-generated method stub
		System.out.println("Swimming...");
		
	} 
	
	public static void Gills() {
		System.out.println("Fish is Breathe with gills...");
		
	} 

	public static void Fins() {
		System.out.println("Fish is Wave with fins...");
		
	} 
}
