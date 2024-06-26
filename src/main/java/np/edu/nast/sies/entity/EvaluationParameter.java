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
@Table(name = "tbl_evaluation_parameter")
@Data
@NoArgsConstructor
public class EvaluationParameter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nature;
	private String th;
	private String pr;
	private Integer weight;
	private Integer marks;
	
	@ManyToOne
	private Subject subject;
	
	@ManyToOne
	private Evaluation evaluation;
	
}
