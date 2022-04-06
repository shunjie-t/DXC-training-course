import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Model {
	private String name;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int createAccount() {
		Connection con = null;
		PreparedStatement pstmt;
		int rows = 0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver loaded successfully");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","57RER20^4!f");
			System.out.println("Connection established successfully");
			
			pstmt = con.prepareStatement("INSERT INTO userdetails(name,username,password,email) VALUES(?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
}
