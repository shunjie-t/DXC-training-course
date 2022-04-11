package april1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class SQLRollback {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		PreparedStatement pstmt;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver is registered successfully.");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "57RER20^4!f");
			System.out.println("Connection established.");
			
			con.setAutoCommit(false);
			
			Scanner scan = new Scanner(System.in);
			
			pstmt = con.prepareStatement("UPDATE student SET marks1 = ? WHERE id = ?");
			System.out.println("Enter marks 1 to be updated");
			int temp1 = scan.nextInt();
			System.out.println("Enter the id");
			int temp2 = scan.nextInt();
			pstmt.setInt(1, temp1);
			pstmt.setInt(2, temp2);
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement("UPDATE student SET marks2 = ? WHERE id = ?");
			System.out.println("Enter marks 2 to be updated");
			int temp3 = scan.nextInt();
			System.out.println("Enter the id");
			int temp4 = scan.nextInt();
			pstmt.setInt(1, temp3);
			pstmt.setInt(2, temp4);
			pstmt.executeUpdate();
			
			con.commit();
		}
		catch(SQLException e) {
			con.rollback();
			System.out.println("Executions have been rolled back");
			e.printStackTrace();
		}
	}
}
