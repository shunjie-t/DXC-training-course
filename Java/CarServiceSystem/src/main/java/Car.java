public class Car {
	private String cun;
	private String carmodel;
	private String cartype;
	private String carplate;
	private String servicerequest;
	private String status;
	
	@Override
	public String toString() {
		return "Car [cun=" + cun + ", carmodel=" + carmodel + ", cartype=" + cartype + ", carplate=" + carplate
				+ ", servicerequest=" + servicerequest + ", status=" + status + "]";
	}
	public Car(String cun, String carmodel, String cartype, String carplate, String servicerequest, String status) {
		super();
		this.cun = cun;
		this.carmodel = carmodel;
		this.cartype = cartype;
		this.carplate = carplate;
		this.servicerequest = servicerequest;
		this.status = status;
	}
	public String getCun() {
		return cun;
	}
	public void setCun(String cun) {
		this.cun = cun;
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
	public String getCarplate() {
		return carplate;
	}
	public void setCarplate(String carplate) {
		this.carplate = carplate;
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
	
	
}
