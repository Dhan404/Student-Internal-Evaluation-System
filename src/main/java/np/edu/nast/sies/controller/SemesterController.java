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

import np.edu.nast.sies.entity.Semester;
import np.edu.nast.sies.repository.SemesterRepository;

@RestController
@RequestMapping("/semester")
@CrossOrigin(origins = "http://localhost:4200")
public class SemesterController {
	@Autowired
	private SemesterRepository repo;
	// /semester: GET => Display all Semester info  
	@GetMapping
	public List<Semester> findSemester(){
		return repo.findAll();
	}
	// /semester/1: GET => Display Semester info of id 1
	@GetMapping("/{id}")
	public Semester findById(@PathVariable Long id){
		Semester r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /semester: POST => Create Semester record
	@PostMapping
	public Semester createSemester(@RequestBody Semester c) {
		return repo.save(c);
	}
	// /semester: PUT => Update Semester info based on their id 
	@PutMapping("/{id}")
	public Semester updateSemester(@PathVariable Long id, @RequestBody Semester c) {
//		return repo.save(c);
		if (repo.existsById(id)) {
	        c.setId(id); // Set the ID in the updated subject object
	        return repo.save(c);
	    }
	    return null;
	}
	// /semester/2: DELETE => Delete Semester info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteSemester(@PathVariable Long id) {
		repo.deleteById(id);
	}
}

