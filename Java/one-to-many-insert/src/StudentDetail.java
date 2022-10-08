import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentdetail")
public class StudentDetail {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="company")
	private String company;
	
	@Column(name="experience")
	private int experience;
	
	@OneToOne(mappedBy = "studentid", cascade = CascadeType.ALL) // "studentid" matches the variable from Student.java
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDetail [id=" + id + ", company=" + company + ", experience=" + experience + "]";
	}

	public StudentDetail(String company, int experience) {
		super();
		this.company = company;
		this.experience = experience;
	}
	
	public StudentDetail() {

	}
}
