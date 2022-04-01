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

public class SQLInsert {

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
			
			stmt = con.createStatement();
			
			pstmt = con.prepareStatement("INSERT INTO student(id,name,marks1,marks2,marks3) VALUES(?,?,?,?,?)");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the id of the student: ");
			int intInput1 = scan.nextInt();
			
			System.out.println("Enter the name of the student: ");
			String strInput = scan.next();
			
			System.out.println("Enter the marks1 of the student: ");
			int intInput2 = scan.nextInt();
			
			System.out.println("Enter the marks2 of the student: ");
			int intInput3 = scan.nextInt();
			
			System.out.println("Enter the marks3 of the student: ");
			int intInput4 = scan.nextInt();
			
			pstmt.setInt(1, intInput1);
			pstmt.setString(2, strInput);
			pstmt.setInt(3, intInput2);
			pstmt.setInt(4, intInput3);
			pstmt.setInt(5, intInput4);
			res = pstmt.executeQuery();
			
			res = stmt.executeQuery("SELECT * FROM student");
			while(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				int marks1 = res.getInt(3);
				int marks2 = res.getInt(4);
				int marks3 = res.getInt(5);
				
				System.out.printf("%d   %s   %d   %d   %d%n",id,name,marks1,marks2,marks3);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
