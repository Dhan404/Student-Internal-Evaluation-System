package np.edu.nast.sies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import np.edu.nast.sies.entity.StudentSemester;
import np.edu.nast.sies.repository.StudentSemesterRepository;

@RestController
@RequestMapping("/studentsemester")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentSemesterController {
	@Autowired
	private StudentSemesterRepository repo;
	// /studentsemester: GET => Display all StudentSemester info  
	@GetMapping
	public List<StudentSemester> findStudentSemester(){
		return repo.findAll();
	}
	// /studentsemester/1: GET => Display StudentSemester info of id 1
	@GetMapping("/{id}")
	public StudentSemester findById(@PathVariable Long id){
		StudentSemester r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /studentsemester: POST => Create StudentSemester record
	@PostMapping
	public StudentSemester createStudentSemester(@RequestBody StudentSemester c) {
		return repo.save(c);
	}
	// /studentsemester: PUT => Update StudentSemester info based on their id 
	@PutMapping()
	public StudentSemester updateStudentSemester(@RequestBody StudentSemester c) {
		return repo.save(c);
	}
	// /studentsemester/2: DELETE => Delete StudentSemester info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteStudentSemester(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
