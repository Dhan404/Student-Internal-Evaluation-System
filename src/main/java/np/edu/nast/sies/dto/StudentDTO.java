package np.edu.nast.sies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String dob;
	private String address;
	private String registrationNo;
	private String examRoll;
	private String email;
	private String mobile;
	private String profilePic;
	private Long userId;
	private Long programId;
	private Long semesterId;
}
