package dateOperation.insertion.retrieva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class DateOperations {

	public static void main(String[] args) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name:: ");
		String sname = scanner.next();
		
		System.out.print("Enter the address:: ");
		String saddress = scanner.next();
		
		System.out.print("Enter the gender M/F:: ");
		String sgender = scanner.next();

		System.out.print("Enter the dob::(dd-MM-yyyy) ");
		String dob = scanner.next();
		
		System.out.print("Enter the doj::(MM-dd-yyyy) ");
		String doj = scanner.next();
		
		System.out.print("Enter the dom::(yyyy-MM-dd) ");
		String dom = scanner.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dobUtil = sdf.parse(dob);
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date dojUtil = sdf.parse(doj);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date domdate = sdf2.parse(dom);

		long time1 = dobUtil.getTime();
		java.sql.Date sqlDateDob = new java.sql.Date(time1);
		long time2 = dobUtil.getTime();
		java.sql.Date sqlDateDoj = new java.sql.Date(time2);
		long time3= domdate.getTime();
		java.sql.Date sqlDomDate = new java.sql.Date(time3);

		System.out.println("String dob is  :: " + dob);
		System.out.println("Util date is   :: " + dobUtil);
		System.out.println("SQL  date is   :: " + sqlDateDob);
		
		System.out.println("String dob is  :: " + doj);
		System.out.println("Util date is   :: " + dojUtil);
		System.out.println("SQL  date is   :: " + sqlDateDoj);
		
		System.out.println("no formatted SQL  date is   :: " +domdate);
		
		
		

		String sqlInsertQuery = "insert into admission(`saddress`,`sgender`,`dob`,`doj`,`dom`,`sname`) values (?,?,?,?,?,?)";

		try {

			 connection=SqlConnection.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {
				pstmt.setString(1, saddress);
				pstmt.setString(2,sgender);
				pstmt.setDate(3, sqlDateDob);
				pstmt.setDate(4, sqlDateDoj);
				pstmt.setDate(5, sqlDomDate);
				pstmt.setString(6,sname);

				int rowAffected = pstmt.executeUpdate();

				System.out.println("No of rows affected is:: " + rowAffected);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				SqlConnection.closeConnection(null, pstmt, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (scanner != null) {
				scanner.close();
			}
		}


	}

}
