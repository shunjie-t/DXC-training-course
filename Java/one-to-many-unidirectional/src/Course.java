import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="studentid")
	private Student student;
	
	// since course is refering to the reviews it will have property of list of associated class 
	// i.e. Review object
//	@OneToMany(mappedBy="courseid",cascade=CascadeType.ALL)
	
	
//	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL) // eager loading (default)
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL) // lazy loading
	@JoinColumn(name="courseid")
	private List<Review> reviews;
	
	public Course() {
		
	}
	
	public Course(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	public void addReview(Review rv) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(rv);
	}
}
