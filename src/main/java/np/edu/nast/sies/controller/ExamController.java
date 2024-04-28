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

import np.edu.nast.sies.entity.Exam;
import np.edu.nast.sies.repository.ExamRepository;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {
	@Autowired
	private ExamRepository repo;
	// /exam: GET => Display all Exam info  
	@GetMapping
	public List<Exam> findExam(){
		return repo.findAll();
	}
	// /exam/1: GET => Display Exam info of id 1
	@GetMapping("/{id}")
	public Exam findById(@PathVariable Long id){
		Exam r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /exam: POST => Create Exam record
	@PostMapping
	public Exam createExam(@RequestBody Exam c) {
		return repo.save(c);
	}
	// /exam: PUT => Update Exam info based on their id 
	@PutMapping()
	public Exam updateExam(@RequestBody Exam c) {
		return repo.save(c);
	}
	// /exam/2: DELETE => Delete Exam info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteExam(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
