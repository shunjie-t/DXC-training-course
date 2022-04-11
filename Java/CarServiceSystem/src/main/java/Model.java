import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Model {
	private String aun;
	private String apwd;
	private Connection con;
	private String cname;
	private String cun;
	private String cpwd;
	private String cemail;
	private String carmodel;
	private String cartype;
	private String carregnumber;
	
	Model() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver loaded successfully");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","57RER20^4!f");
			System.out.println("Connection established successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getAun() {
		return aun;
	}
	
	public void setAun(String aun) {
		this.aun = aun;
	}
	
	public String getApwd() {
		return apwd;
	}
	
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCun() {
		return cun;
	}

	public void setCun(String cun) {
		this.cun = cun;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarregnumber() {
		return carregnumber;
	}

	public void setCarregnumber(String carregnumber) {
		this.carregnumber = carregnumber;
	}

	int adminVerify() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from AdminDB where aun = ?");
			pstmt.setString(1, aun);
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				return 1;
			}
			else {
				return 0;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	int addCustomerDetails() {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into CustomerDB values(?,?,?,?)");
			pstmt.setString(1, cname);
			pstmt.setString(2, cun);
			pstmt.setString(3, cpwd);
			pstmt.setString(4, cemail);
			
			int rows = pstmt.executeUpdate();
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	int customerVerify() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from CustomerDB where cun = ?");
			pstmt.setString(1, cun);
			ResultSet res = pstmt.executeQuery();
			
			
			if(res.next()) {
				String dcpwd = res.getString("cpwd");
				cname = res.getString("cname");
				
				if(cpwd.equals(dcpwd)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			else {
				return -1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	int updateCarDetails() {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into CUSTOMERCARDETAILS values(?,?,?)");
			pstmt.setString(1, carmodel);
			pstmt.setString(2, cartype);
			pstmt.setString(3, carregnumber);
			
			int rows = pstmt.executeUpdate();
			return rows;
		} 
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
}
