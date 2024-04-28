package np.edu.nast.sies.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_programs")
@Data
@NoArgsConstructor
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String programCode;
	@Column(unique = true)
	private String programName;
	@ManyToOne
	@JoinColumn(name="faculty_name", referencedColumnName = "facultyName")
	private Faculty faculty;
}
