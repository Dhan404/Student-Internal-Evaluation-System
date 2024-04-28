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

import np.edu.nast.sies.entity.Practical;
import np.edu.nast.sies.repository.PracticalRepository;

@RestController
@RequestMapping("/practical")
@CrossOrigin(origins = "http://localhost:4200")
public class PracticalController {
	@Autowired
	private PracticalRepository repo;
	// /practical: GET => Display all Practical info  
	@GetMapping
	public List<Practical> findPractical(){
		return repo.findAll();
	}
	// /practical/1: GET => Display Practical info of id 1
	@GetMapping("/{id}")
	public Practical findById(@PathVariable Long id){
		Practical practical=null;
		if(repo.existsById(id)) {
			practical = repo.findById(id).get();
		}
		return practical;
	}
	// /practical: POST => Create Practical record
	@PostMapping
	public Practical createPractical(@RequestBody Practical c) {
		return repo.save(c);
	}
	// /practical: PUT => Update Practical info based on their id 
	@PutMapping()
	public Practical updatePractical(@RequestBody Practical c) {
		return repo.save(c);
	}
	// /practical/2: DELETE => Delete Practical info based on their id 2
	@DeleteMapping("/{id}")
	public void deletePractical(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
