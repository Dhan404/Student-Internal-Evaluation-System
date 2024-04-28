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
@Table(name="tbl_practical_drawings")
@Data
@NoArgsConstructor
public class PracticalDrawing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double internalAssessment;
	private double finalExamination;
	
	@ManyToOne
	private NatureOfCourse natureOfCourse;
}
