package dateOperation.insertion.retrieva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class InsertRetrieveApp {

	public static void main(String[] args) throws Exception {
		System.out.println("hello");
	    Connection connection=null;
	    PreparedStatement pstmt=null;

	    Scanner scanner=new Scanner(System.in);
	    System.out.println("enter name");
	    String sname= scanner.next();

	    System.out.println("enter age");
	  int sage=scanner.nextInt();
	    
	    System.out.println("enter address");
	    String saddr=scanner.next();

	    
	    
	    String InsertQuery="insert into student (sname,sage,saddr)values(?,?,?)";
	    try {
	    connection=SqlConnection.getJdbcConnection();
	    if (connection!=null)
		{
	    	pstmt=connection.prepareStatement(InsertQuery);
		}
		if (pstmt!=null)
		{
			pstmt.setString(1,sname);
			pstmt.setInt(2,sage);
			pstmt.setString(3,saddr);
		int rowAffected=pstmt.executeUpdate();
		System.out.println("No of rows Affected is::"+rowAffected);
		}
	}
	catch (SQLException se) {
			se.printStackTrace();
	}
		
	 catch (Exception e) {
		
		e.printStackTrace();
	}
	finally {
		SqlConnection.closeConnection(null,pstmt, connection);
		if (scanner !=null)
			scanner.close();
		
	}
		

	}

}
