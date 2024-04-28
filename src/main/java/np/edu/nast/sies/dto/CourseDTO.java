package np.edu.nast.sies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
	private Long id;
	private Long subjectId;
	private String code;
	private String credit;
	private String syllabus;
	private String nature;
	private String th;
	private String pr;
	private String requirementType;
}
