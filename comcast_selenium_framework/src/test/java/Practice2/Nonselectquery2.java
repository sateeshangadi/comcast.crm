package Practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselectquery2 {
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		int result=0;
		try{
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		Statement stat = conn.createStatement();
		String query="insert into project values('TY_PROJ_007','shreya','17/01/2022','sixthproject','created','0')";
		result=stat.executeUpdate(query);
		
		}catch(Exception e){
			
		}finally{
			if(result==1){
				System.out.println("inserted successfully");
			}else{
				System.out.println("insertion not successful");
			}
			conn.close();
		}
		
		
	}
	}


