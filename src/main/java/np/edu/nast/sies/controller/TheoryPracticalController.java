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

import np.edu.nast.sies.entity.TheoryPractical;
import np.edu.nast.sies.repository.TheoryPracticalRepository;

@RestController
@RequestMapping("/theorypractical")
@CrossOrigin(origins = "http://localhost:4200")
public class TheoryPracticalController {
	@Autowired
	private TheoryPracticalRepository repo;
	// /nature: GET => Display all TheoryPractical info  
	@GetMapping
	public List<TheoryPractical> findTheoryPractical(){
		return repo.findAll();
	}
	// /theorypractical/1: GET => Display TheoryPractical info of id 1
	@GetMapping("/{id}")
	public TheoryPractical findById(@PathVariable Long id){
		TheoryPractical r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /theorypractical: POST => Create TheoryPractical record
	@PostMapping
	public TheoryPractical createTheoryPractical(@RequestBody TheoryPractical c) {
		return repo.save(c);
	}
	// /theorypractical: PUT => Update TheoryPractical info based on their id 
	@PutMapping()
	public TheoryPractical updateTheoryPractical(@RequestBody TheoryPractical c) {
		return repo.save(c);
	}
	// /theorypractical/2: DELETE => Delete TheoryPractical info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteTheoryPractical(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
