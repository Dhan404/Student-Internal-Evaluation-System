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

import np.edu.nast.sies.entity.Allocation;
import np.edu.nast.sies.repository.AllocationRepository;

@RestController
@RequestMapping("/allocation")
@CrossOrigin(origins = "http://localhost:4200")
public class AllocationController {
	@Autowired
	private AllocationRepository repo;
	// /allocation: GET => Display all allocation info  
	@GetMapping
	public List<Allocation> findAllocation(){
		return repo.findAll();
	}
	// /allocation/1: GET => Display Allocation info of id 1
	@GetMapping("/{id}")
	public Allocation findById(@PathVariable Long id){
		Allocation r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /allocation: POST => Create Allocation record
	@PostMapping
	public Allocation createAllocation(@RequestBody Allocation c) {
		return repo.save(c);
	}
	// /allocation: PUT => Update Allocation info based on their id 
	@PutMapping()
	public Allocation updateAllocation(@RequestBody Allocation c) {
		return repo.save(c);
	}
	// /allocation/2: DELETE => Delete Allocation info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteAllocation(@PathVariable Long id) {
		repo.deleteById(id);
	}
}

