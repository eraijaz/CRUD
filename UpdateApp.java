package in.ineuron.files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class UpdateApp {

	public static void main(String[] args) throws Exception {
		Connection connection=null;
		PreparedStatement ps=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the sid  to search:");
		int sid=sc.nextInt();
		System.out.println("enter new name :");
		String sname=sc.next();
		String updateQuery="update javacourse.student set sname=? where sid =?";
		try {
			connection=SqlConnection.getJdbcConnection();
			if (connection!=null)
			{
			ps=connection.prepareStatement(updateQuery);
			System.out.println("inside update ");
			
				System.out.println("inside updation");
				ps.setInt(2, sid);
			   ps.setString(1, sname);
				ps.executeUpdate();
				if(ps!=null)
				{
				int rowAffected=ps.executeUpdate();
				System.out.println("updated sucessfully");
				System.out.println("No of rows Affected is::"+rowAffected);
			}
			else
			{
				System.out.println("no record updated");
			}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
