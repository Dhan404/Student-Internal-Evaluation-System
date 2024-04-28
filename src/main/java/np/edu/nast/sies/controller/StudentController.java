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

import np.edu.nast.sies.dto.StudentDTO;
import np.edu.nast.sies.entity.Student;
import np.edu.nast.sies.repository.StudentRepository;
import np.edu.nast.sies.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private StudentService service;
	
	//Student: GET => Display all students info
	@GetMapping
	public List<Student> findStudents(){
		return studentRepo.findAll();
	}
	
	//student/1: GET =>Display student info of id 1
	@GetMapping("/{id}")
	public Student findById(@PathVariable Long id) {
		Student student=null;
		if(studentRepo.existsById(id)) {
			student= studentRepo.findById(id).get();
		}
		return student;
	}
	
		// student:POST => Create student record
		@PostMapping
		public Student createStudent(@RequestBody StudentDTO s) {
			return studentRepo.save(service.createStudent(s));
		}
		
		// /student:PUT => Update student info based on their id
		@PutMapping("/{id}")
		public  Student updateStudent(@PathVariable Long id,@RequestBody StudentDTO s) {
			Student student = service.createStudent(s);
			student.setId(id);
			return studentRepo.save(student);
		}
		
		// /student/2:DELETE => Delete student info based on their id
		@DeleteMapping("/{id}")
		public void deleteStudent(@PathVariable Long id) {
			studentRepo.deleteById(id);
		}	
}
