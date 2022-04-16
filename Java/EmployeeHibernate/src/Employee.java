public class Employee {
	private int eid;
	private String efirstname;
	private String esecondname;
	private String eemail;
	
	public Employee() {
		super();
	}
	public Employee(int eid, String efirstname, String esecondname, String eemail) {
		super();
		this.eid = eid;
		this.efirstname = efirstname;
		this.esecondname = esecondname;
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
	public String getEsecondname() {
		return esecondname;
	}
	public void setEsecondname(String esecondname) {
		this.esecondname = esecondname;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", efirstname=" + efirstname + ", esecondname=" + esecondname + ", eemail=" + eemail
				+ "]";
	}	
}
