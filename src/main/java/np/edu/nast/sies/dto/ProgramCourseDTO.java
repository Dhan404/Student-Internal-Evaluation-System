package np.edu.nast.sies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramCourseDTO {
	private Long id;
	private Long semesterId;
	private Long programId;
	private Long courseId;
}
