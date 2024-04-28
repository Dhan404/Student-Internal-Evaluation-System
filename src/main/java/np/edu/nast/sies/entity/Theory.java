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
@Table(name="tbl_theories")
@Data
@NoArgsConstructor
public class Theory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double attendanceAndClassParticapation;
	private double assignment;
	private double presentation_MCQ;
	private double termExam;
	private double totalInternal;
	
	@ManyToOne
	private NatureOfCourse natureOfCourse;
}

