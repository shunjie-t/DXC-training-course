package march31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class SQLSelect {

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
			res = stmt.executeQuery("SELECT * FROM student");
			
			ResultSetMetaData rsmd = res.getMetaData();
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i));
			}
			System.out.println("");
			
			pstmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the id of the student: ");
			int input = scan.nextInt();
			pstmt.setInt(1, input);
			res = pstmt.executeQuery();
			
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
