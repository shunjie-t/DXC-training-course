import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@Column(name="e_id")
	private int eid;
	
	@Column(name="e_first_name")
	private String efirstname;
	
	@Column(name="e_last_name")
	private String elastname;
	
	@Column(name="e_email")
	private String eemail;
	public Employee() {
		
	}
	public Employee(String efirstname, String elastname, String eemail) {
		super();
		this.efirstname = efirstname;
		this.elastname = elastname;
		this.eemail = eemail;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEfirstname() {
		return efirstname;
	}
	public void setEfirstname(String efirstname) {
		this.efirstname = efirstname;
	}
	public String getElastname() {
		return elastname;
	}
	public void setElastname(String elastname) {
		this.elastname = elastname;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", efirstname=" + efirstname + ", elastname=" + elastname + ", eemail=" + eemail
				+ "]";
	}
}
