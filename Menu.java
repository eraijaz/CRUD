package in.ineuron.menu;
import in.ineuron.files.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.connection.SqlConnection;

public class Menu {

	public static void main(String[] args) throws Exception 
	{
		Connection connection=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter your operation you want to perform");
		System.out.println("1.insert , 2.search,3.delete,4.update");
		int ch=scanner.nextInt();
	
		if(ch==1) 
		{
			System.out.println("=============Insert block=========");
			InsertOperation.getInsert();
		}
		else if(ch==2)
		{
		
			System.out.println("=============search block=========");
		    
		      SearchOperation.getSearch();
		}
		else if(ch==3)
		{
			System.out.println("=============Delete block=========");
			DeleteOperation.getDelete();
		}
		else if (ch==4)
		{
			System.out.println("=============Update block=========");
			UpdateOperation.getUpdate();
		}
		
		else {
			System.out.println("Enter valid value");
			
		}
	}

}
