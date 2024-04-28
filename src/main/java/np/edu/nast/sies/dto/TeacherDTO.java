package np.edu.nast.sies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String dob;
	private String address;
	private String mobile;
	private String email;
	private String panNumber;
	private String department;
	private String qualification;
	private String experience;
	private String profilePic;
	private Long userId;
}
