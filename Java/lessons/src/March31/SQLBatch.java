package March31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class SQLBatch {

	public static void main(String[] args) {
		try {
			Connection con;
			PreparedStatement pstmt;
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver is registered successfully.");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "57RER20^4!f");
			System.out.println("Connection established.");
			
			pstmt = con.prepareStatement("UPDATE student SET marks1 = 10 WHERE id = 1");
			pstmt.addBatch();
			
			pstmt = con.prepareStatement("UPDATE student SET marks1 = 20 WHERE id = 2");
			pstmt.addBatch();
			
			pstmt = con.prepareStatement("UPDATE student SET marks1 = 30 WHERE id = 3");
			pstmt.addBatch();
			
			pstmt.executeBatch();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
