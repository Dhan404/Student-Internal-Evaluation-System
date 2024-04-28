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

import np.edu.nast.sies.dto.TeacherDTO;
import np.edu.nast.sies.entity.Teacher;
import np.edu.nast.sies.repository.TeacherRepository;
import np.edu.nast.sies.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private TeacherService service;
	
	// /teacher: GET => Display all teachers info
	@GetMapping
	public List<Teacher> findStudents(){
		return teacherRepo.findAll();
	}
	
	// /teacher/1: GET =>Display teacher info of id 1
	@GetMapping("/{id}")
	public Teacher findById(@PathVariable Long id) {
		Teacher teacher=null;
		if(teacherRepo.existsById(id)) {
			teacher = teacherRepo.findById(id).get();
		}
		return teacher;
	}
	
		// /teacher : POST => Create teacher record
		@PostMapping
		public Teacher createTeacher(@RequestBody TeacherDTO t) {
			return teacherRepo.save(service.createTeacher(t));
		}
		
		// /teacher: PUT => Update teacher info based on their id
		@PutMapping("/{id}")
		public  Teacher updateStudent(@PathVariable Long id,@RequestBody TeacherDTO t) {
			
			Teacher teacher = service.createTeacher(t);
			teacher.setId(id);
			return teacherRepo.save(teacher);
		}
		
		//  /teacher/2 :DELETE => Delete teacher info based on their id
		@DeleteMapping("/{id}")
		public void deleteTeacher(@PathVariable Long id) {
			teacherRepo.deleteById(id);
		}	
}
