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

import np.edu.nast.sies.entity.Theory;
import np.edu.nast.sies.repository.TheoryRepository;

@RestController
@RequestMapping("/theory")
@CrossOrigin(origins = "http://localhost:4200")
public class TheoryController {
	@Autowired
	private TheoryRepository repo;
	// /theory: GET => Display all Theory info  
	@GetMapping
	public List<Theory> findTheory(){
		return repo.findAll();
	}
	// /nature/1: GET => Display Theory info of id 1
	@GetMapping("/{id}")
	public Theory findById(@PathVariable Long id){
		Theory r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /theory: POST => Create Theory record
	@PostMapping
	public Theory createTheory(@RequestBody Theory c) {
		return repo.save(c);
	}
	// /theory: PUT => Update Theory info based on their id 
	@PutMapping()
	public Theory updateTheory(@RequestBody Theory c) {
		return repo.save(c);
	}
	// /theory/2: DELETE => Delete Theory info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteTheory(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
