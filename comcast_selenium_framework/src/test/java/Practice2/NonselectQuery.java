package Practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonselectQuery {
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		int result=0;
		
		try{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("connection done");
		Statement stat = conn.createStatement();
		String query = "insert into project values('TY_PROJ_005','rakshu','12/01/2022','fifthproject','created','0')";
		 result = stat.executeUpdate(query);
		
	
	}catch(Exception e)
		{
	}
		finally{
		if(result==1){
			System.out.println("project inserted successfully");
		}else{
			System.out.println("project not inserted");
		}
		conn.close();
		System.out.println("connection closed");
		}
			
	
	}
}

