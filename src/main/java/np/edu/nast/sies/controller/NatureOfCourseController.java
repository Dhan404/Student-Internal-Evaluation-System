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

import np.edu.nast.sies.entity.NatureOfCourse;
import np.edu.nast.sies.repository.NatureOfCourseRepository;

@RestController
@RequestMapping("/nature")
@CrossOrigin(origins = "http://localhost:4200")
public class NatureOfCourseController {
	@Autowired
	private NatureOfCourseRepository repo;
	// /nature: GET => Display all NatureOfCourse info  
	@GetMapping
	public List<NatureOfCourse> findNatureOfCourse(){
		return repo.findAll();
	}
	// /nature/1: GET => Display NatureOfCourse info of id 1
	@GetMapping("/{id}")
	public NatureOfCourse findById(@PathVariable Long id){
		NatureOfCourse r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /nature: POST => Create NatureOfCourse record
	@PostMapping
	public NatureOfCourse createNatureOfCourse(@RequestBody NatureOfCourse c) {
		return repo.save(c);
	}
	// /nature: PUT => Update NatureOfCourse info based on their id 
	@PutMapping()
	public NatureOfCourse updateNatureOfCourse(@RequestBody NatureOfCourse c) {
		return repo.save(c);
	}
	// /nature/2: DELETE => Delete NatureOfCourse info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteNatureOfCourse(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
