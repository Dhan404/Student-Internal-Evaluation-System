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

import np.edu.nast.sies.entity.StudentCourse;
import np.edu.nast.sies.repository.StudentCourseRepository;

@RestController
@RequestMapping("/studentcourse")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentCourseController {
	@Autowired
	private StudentCourseRepository repo;
	// /studentcourse: GET => Display all StudentCourse info  
	@GetMapping
	public List<StudentCourse> findStudentCourse(){
		return repo.findAll();
	}
	// /studentcourse/1: GET => Display StudentCourse info of id 1
	@GetMapping("/{id}")
	public StudentCourse findById(@PathVariable Long id){
		StudentCourse r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /studentcourse: POST => Create StudentCourse record
	@PostMapping
	public StudentCourse createStudentCourse(@RequestBody StudentCourse c) {
		return repo.save(c);
	}
	// /studentcourse: PUT => Update StudentCourse info based on their id 
	@PutMapping()
	public StudentCourse updateStudentCourse(@RequestBody StudentCourse c) {
		return repo.save(c);
	}
	// /studentcourse/2: DELETE => Delete StudentCourse info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteStudentCourse(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
