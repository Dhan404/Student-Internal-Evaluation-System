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

import np.edu.nast.sies.entity.Batch;
import np.edu.nast.sies.repository.BatchRepository;

@RestController
@RequestMapping("/batch")
@CrossOrigin(origins = "http://localhost:4200")
public class BatchController {
	@Autowired
	private BatchRepository repo;
	// /batch: GET => Display all Batch info  
	@GetMapping
	public List<Batch> findBatch(){
		return repo.findAll();
	}
	// /batch/1: GET => Display Batch info of id 1
	@GetMapping("/{id}")
	public Batch findById(@PathVariable Long id){
		Batch r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /batch: POST => Create Batch record
	@PostMapping
	public Batch createBatch(@RequestBody Batch c) {
		return repo.save(c);
	}
	// /batch: PUT => Update Batch info based on their id 
	@PutMapping()
	public Batch updateBatch(@RequestBody Batch c) {
		return repo.save(c);
	}
	// /batch/2: DELETE => Delete Batch info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteBatch(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
