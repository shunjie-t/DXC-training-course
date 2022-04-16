import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	private String servicerequest;
	private String status;
	private ArrayList<Customer> custAl = new ArrayList<Customer>();
	private ArrayList<Car> carAl = new ArrayList<Car>();
	
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
	
	@Override
	public String toString() {
		return "Model [custAl=" + custAl + "]";
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

	public String getServicerequest() {
		return servicerequest;
	}

	public void setServicerequest(String servicerequest) {
		this.servicerequest = servicerequest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
			PreparedStatement pstmt = con.prepareStatement("insert into cardetails values(?,?,?,?,?,?)");
			pstmt.setString(1, cun);
			pstmt.setString(2, carmodel);
			pstmt.setString(3, cartype);
			pstmt.setString(4, carregnumber);
			pstmt.setString(5, "");
			pstmt.setString(6, "");
			
			int rows = pstmt.executeUpdate();
			return rows;
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	int updateCarService() {
		try {
			PreparedStatement pstmt = con.prepareStatement("update cardetails set servicerequest = ?, status = ? where cun = ?");
			pstmt.setString(1, servicerequest);
			pstmt.setString(2, status);
			pstmt.setString(3, cun);
			
			return pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	ArrayList<Customer> getRegisteredCustomers() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from CustomerDB");
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				cname = res.getString("cname");
				cun = res.getString("cun");
				cpwd = res.getString("cpwd");
				cemail = res.getString("email");
				custAl.add(new Customer(cname,cun,cpwd,cemail));
			}
			
			return custAl;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return custAl;
	}
	
	ArrayList<Car> getPendingRequest() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from cardetails where status = ?");
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				cun = res.getString("cun");
				carmodel = res.getString("carmodel");
				cartype = res.getString("carmodel");
				carregnumber = res.getString("carplate");
				servicerequest = res.getString("servicereq");
				status = res.getString("status");
				carAl.add(new Car(cun, carmodel, cartype, carregnumber, servicerequest, status));
			}
			
			return carAl;
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return carAl;
	}
	
	int UpdateStatus() {
		try {
			PreparedStatement pstmt = con.prepareStatement("update cardetails set status = 'true' where cun = ?");
			pstmt.setString(1, cun);
			int row = pstmt.executeUpdate();
			System.out.println("row is: " + row);
			
			return row;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	int checkUpdate() {
		try {
			PreparedStatement pstmt = con.prepareStatement("select status from cardetails where cun = ?");
			pstmt.setString(1, cun);
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				status = res.getString("status");
			}
			
			return 1;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
