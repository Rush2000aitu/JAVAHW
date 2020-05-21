package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CalkCost{

    private static final String url = "jdbc:mysql://localhost:3306/javadb";
    private static final String user = "root";
    private static final String password = "13579abc";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    public final static int Acost = 20000;
	public final static int WaterCost = 2000;
	public final static int StoneCost = 35000;
	public final static int earthCost = 54000;
	
	public static void main(String args[]){  
		
		
		SetFish fish = new SetFish();
		SetFish.Gills();
		SetFish.Fins();
		
		SetReptile reptile = new SetReptile();
		SetReptile.Walk();
		SetReptile.Lugs();
		
		
		try{  
			
			String query1 = "select count(*) from fish";
			
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query1);
			
			int count = 0;
			while (rs.next()) {
                count = rs.getInt(1);
                System.out.println("Total number of fishes : " + count);
            }
			
			String query2 = "select count(*) from reptile";
			
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query2);
			
			int count1 = 0;
			while (rs.next()) {
                count1 = rs.getInt(1);
                System.out.println("Total number of reptiles : " + count1);
            }
			
			int sum = 0;
				String query = "select price from fish";
				
				con = DriverManager.getConnection(url, user, password);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
	                sum += rs.getInt(1);
	            }
				System.out.println("Total cost of all of fishes : " + sum);
			    

				int sum1 = 0;
					String query3 = "select price from reptile";
					
					con = DriverManager.getConnection(url, user, password);
					stmt = con.createStatement();
					rs = stmt.executeQuery(query3);
					while (rs.next()) {
		                sum1 += rs.getInt(1);
		            }
					System.out.println("Total cost of all of reptiles : " + sum1);
				 
					int total = sum+sum1+Acost+WaterCost+StoneCost+earthCost;
							System.out.println("Total cost of whole Aquarium : "+total+ " Tenge");
					
				}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
				return;
				}   
		
		
		}
	
	
}


