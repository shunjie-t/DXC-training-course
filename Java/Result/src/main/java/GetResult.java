import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

public class GetResult extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con;
			PreparedStatement pstmt;
			ResultSet res;
			PrintWriter pw;
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver registered successfully");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "57RER20^4!f");
			System.out.println("Connection established successfully");
			
			pstmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
			
			int temp = Integer.parseInt(request.getParameter("id"));
			pstmt.setInt(1, temp);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int id = res.getInt(1); 
				String name = res.getString(2);
				int marks1 = res.getInt(3);
				int marks2 = res.getInt(4);
				int marks3 = res.getInt(5);
				pw = response.getWriter();
				pw.print(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
