import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Model {
	private String name;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String newEmail;
	
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
	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public int createAccount() {
		int rows = 0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver loaded successfully");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","57RER20^4!f");
			System.out.println("Connection established successfully");
			
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO userdetails(name,username,password,email) VALUES(?,?,?,?)");
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
	
	public int verify() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver loaded successfully");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","57RER20^4!f");
			System.out.println("Connection established successfully");
			
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM userdetails WHERE username = ?");
			pstmt.setString(1, getUsername());
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				setName(res.getString(1));
				setUsername(res.getString(2));
				setEmail(res.getString(4));
				
				if(res.getString("password").equals(password)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updatePassword() {
		int row = 0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver loaded successfully");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","57RER20^4!f");
			System.out.println("Connection established successfully");
			
			PreparedStatement pstmt = con.prepareStatement("UPDATE userdetails SET password = ? WHERE username = ?");
			
			pstmt.setString(1,password);
			pstmt.setString(2,username);
			row = pstmt.executeUpdate();
			
			return row;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateEmail() {
		int row = 0;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver loaded successfully");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","57RER20^4!f");
			System.out.println("Connection established successfully");
			
			PreparedStatement pstmt = con.prepareStatement("UPDATE userdetails SET email = ? WHERE username = ?");
			
			pstmt.setString(1,newEmail);
			pstmt.setString(2, confirmPassword);
			row = pstmt.executeUpdate();
			
			return row;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
