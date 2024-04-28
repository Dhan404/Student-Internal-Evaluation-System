package np.edu.nast.sies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_practicals")
@Data
@NoArgsConstructor
public class Practical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double attendanceAndClassParticapation;
	private double assignment;
	private double quizzes_MCQ;
	private double classTest;
	private double assessmentExam;
	private double intenalFinalExam;
	
	@ManyToOne
	private NatureOfCourse natureOfCourse;
}
