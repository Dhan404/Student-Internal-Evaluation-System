package np.edu.nast.sies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_courses")
@Data
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Subject subject;
	
	private String code;
	private String credit;
	private String requirementType; //compulsory or optional
	private String nature;
	private String th;
	private String pr;
	
	@Column(length = 100000)
	private String syllabus;
	
}
