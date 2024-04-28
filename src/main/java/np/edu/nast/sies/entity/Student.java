package np.edu.nast.sies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_students")
@Data
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private User user;
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
	
	@ManyToOne
	private Program program;
	
	@ManyToOne
	private Semester semester;
	
	
}
