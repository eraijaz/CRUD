package dateOperation.insertion.retrieva;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class Retrieve {

	public static void main(String[] args)
	{
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Id you want to search:");
		int id=scanner.nextInt();
		String searchQuery="select * from admission where stdid=?";
		try {
			connection=SqlConnection.getJdbcConnection();
			if(connection!=null)
			{
				ps=connection.prepareStatement(searchQuery);
				ps.setInt(1, id);
				rs=ps.executeQuery();
				if(rs!=null) {
					 if(rs.next()) 
					 {
					 System.out.println("inside search");
					 System.out.println("id \t"+" name\t"+"address\t"+"gender\t"+"dob\t\t"+"doj\t\t"+"dom");
					 Integer sid=rs.getInt(7);
					 String sname= rs.getString(6); 
					String saddress= rs.getString(1);
					String sgender= rs.getString(2);
					java.sql.Date sqlDobDate = rs.getDate(3);//dob sqldate to string converion starts here
					long time=sqlDobDate.getTime();   
					java.util.Date dobUtil = new java.util.Date(time);
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String dobdate = sdf.format(dobUtil);//sqldate to string converion finishes here
					
					java.sql.Date sqlDojDate = rs.getDate(4);
					// doj sqldate to string converion starts here
					long timesqlDojDate=sqlDobDate.getTime();   
					java.util.Date dojUtil = new java.util.Date(timesqlDojDate);
					SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
					String dojdate = sdf2.format(dobUtil);//doj sqldate to string converion finishes here
					
					java.sql.Date sqlDomDate = rs.getDate(5);// dom sqldate to string converion starts here
					long timesqlDomDate=sqlDobDate.getTime();   
					java.util.Date domUtil = new java.util.Date(timesqlDomDate);
					SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy");
					String domdate = sdf3.format(domUtil);//dom sqldate to string converion finishes here
					
					
					
					 System.out.println(sid+"\t"+sname+"\t"+saddress+"\t"+sgender+"\t"+dobdate+"\t"+dojdate+"\t"+domdate);
						
						
					 }
					 }
			}
			
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}

}
