package np.edu.nast.sies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationParameterDTO {
    private Long id;
    private Long subjectId;
    private String nature;
	private String th;
	private String pr;
    private Integer weight;
    private Integer marks;
    private Long evaluationId;
}
