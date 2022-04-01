package March31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class SQLUpdate {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet res;
		PreparedStatement pstmt;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver is registered successfully.");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "57RER20^4!f");
			System.out.println("Connection established.");
			
			pstmt = con.prepareStatement("UPDATE student SET marks1 = ? WHERE id = ?");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter marks to be updated");
			int temp1 = scan.nextInt();
			
			System.out.println("Enter the ID of the student whose marks has to be updated.");
			int temp2 = scan.nextInt();
			
			pstmt.setInt(1, temp1);
			pstmt.setInt(2, temp2);
			
			int rowsUpdated = pstmt.executeUpdate();
			System.out.println(rowsUpdated);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
