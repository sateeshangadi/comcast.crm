package Practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Selectquery {
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try{
		Driver driverRef=new Driver();
		//step 1 load or register mysql database
		DriverManager.registerDriver(driverRef);
		
		//step 2 connect to DB
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		System.out.println("connection done");
		
		//step3 create query statement
		Statement stat = conn.createStatement();
		String query = "select * from project";
		
		//step4 execute query
		ResultSet resultset = stat.executeQuery(query);
		while(resultset.next()){
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
		}
		}
		catch(Exception e){
		}
		finally{
			//step 5 close connection
			conn.close();
			System.out.println("connection closed");
						
		}	
		
	}

}
