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
import javax.servlet.http.HttpSession;

import oracle.jdbc.driver.OracleDriver;

public class InsertData extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con;
			PreparedStatement pstmt;
			int rows;
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver registered successfully");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "57RER20^4!f");
			System.out.println("Connection established successfully");
			
			pstmt = con.prepareStatement("INSERT INTO student(id,name,marks1,marks2,marks3) VALUES(?,?,?,?,?)");
			
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int mk1 = Integer.parseInt(request.getParameter("marks1"));
			int mk2 = Integer.parseInt(request.getParameter("marks2"));
			int mk3 = Integer.parseInt(request.getParameter("marks3"));
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, mk1);
			pstmt.setInt(4, mk2);
			pstmt.setInt(5, mk3);
			
			rows = pstmt.executeUpdate();
			
			if(rows == 0) {
				response.sendRedirect("failure.html");
			}
			else {
				response.sendRedirect("success.html");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
