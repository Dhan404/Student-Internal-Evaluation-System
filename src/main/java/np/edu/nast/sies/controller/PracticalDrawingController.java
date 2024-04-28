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

import np.edu.nast.sies.entity.PracticalDrawing;
import np.edu.nast.sies.repository.PracticalDrawingRepository;

@RestController
@RequestMapping("/practicaldrawing")
@CrossOrigin(origins = "http://localhost:4200")
public class PracticalDrawingController {
	@Autowired
	private PracticalDrawingRepository repo;
	// /PracticalDrawing: GET => Display all PracticalDrawing info  
	@GetMapping
	public List<PracticalDrawing> findPracticalDrawing(){
		return repo.findAll();
	}
	// /PracticalDrawing/1: GET => Display PracticalDrawing info of id 1
	@GetMapping("/{id}")
	public PracticalDrawing findById(@PathVariable Long id){
		PracticalDrawing r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /PracticalDrawing: POST => Create PracticalDrawing record
	@PostMapping
	public PracticalDrawing createPracticalDrawing(@RequestBody PracticalDrawing c) {
		return repo.save(c);
	}
	// /PracticalDrawing: PUT => Update PracticalDrawing info based on their id 
	@PutMapping()
	public PracticalDrawing updatePracticalDrawing(@RequestBody PracticalDrawing c) {
		return repo.save(c);
	}
	// /PracticalDrawing/2: DELETE => Delete PracticalDrawing info based on their id 2
	@DeleteMapping("/{id}")
	public void deletePracticalDrawing(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
