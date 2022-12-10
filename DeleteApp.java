package in.ineuron.files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class DeleteApp {

	public static void main(String[] args) {
		System.out.println("hello");
        Connection connection=null;
        PreparedStatement pstmt=null;

        Scanner scanner=new Scanner(System.in);
        System.out.println("enter id you want to delete");
        int sid= scanner.nextInt();

        String InsertQuery="delete from student where sid=?";
        try {
        connection=SqlConnection.getJdbcConnection();
        if (connection!=null)
        {
        	pstmt=connection.prepareStatement(InsertQuery);
        if(pstmt!=null)
        {
        	pstmt.setInt(1, sid);
        	pstmt.executeUpdate();
        	System.out.println("record -> "+sid+" deleted successfully");
        }
        	
        }
        }
        catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
