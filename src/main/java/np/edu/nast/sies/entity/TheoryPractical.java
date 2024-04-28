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
@Table(name="tbl_theory_practicals")
@Data
@NoArgsConstructor
public class TheoryPractical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double attendanceAndClassParticapation;
	private double assignment;
	private double presentation_Viva_Quizes;
	private double termTest;
	private double attendanceAndClassParticapation_pr;
	private double report;
	private double viva;
	private double exam;
	private double totalInternal;
	
	@ManyToOne
	private NatureOfCourse natureOfCourse;
}

