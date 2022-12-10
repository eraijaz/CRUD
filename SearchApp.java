package in.ineuron.files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class SearchApp {

	public static  void getSearch()  throws Exception {
		Connection connection=null;
		PreparedStatement ps=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the sid  to search:");
		int sid=sc.nextInt();
		System.out.println("enter new name :");
		String name=sc.next();
		
		String searchQuery="select sname from student where sid=?";
	
		try {
			connection=SqlConnection.getJdbcConnection();
			
			if(connection!=null)
			{ 
				
					ps=connection.prepareStatement(searchQuery);
				ps.setInt(1, sid);
					ResultSet rs =ps.executeQuery();
				if(rs!=null) {
				 if(rs.next()) 
				 {
					 System.out.println("inside search");
					String ssname= rs.getString(1);
					 System.out.println(ssname);
				 }
				 }
				 
			
			}
			
			
		}
		
			catch (SQLException se) {
				se.printStackTrace();
			}
		 catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			SqlConnection.closeConnection(null, ps, connection);
			if(sc!=null)
				sc.close();
			
		}
		

	}

}
