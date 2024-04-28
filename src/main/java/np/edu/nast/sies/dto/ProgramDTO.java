package np.edu.nast.sies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDTO {	
	private Long id;
	private String programName;
	private String programCode;
	private Long facultyId;
}
