package april1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class SQLBatchWithRollback {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement stmt;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver is registered successfully.");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "57RER20^4!f");
			System.out.println("Connection established.");
			
			con.setAutoCommit(false);
			 
			stmt = con.createStatement();
			stmt.addBatch("UPDATE student SET marks3 = 44 WHERE id = 1");
			stmt.addBatch("UPDATE student SET marks3 = 55 WHERE id = 2");
			stmt.addBatch("UPDATE student SET marks3 = 66 WHERE id = 3");
			
			int[] rows = stmt.executeBatch();
			
			if(rows.length == 2) {
				con.commit();
			}
		}
		catch(SQLException e) {
			con.rollback();
			System.out.println("Executions have been rolled back");
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}

}
