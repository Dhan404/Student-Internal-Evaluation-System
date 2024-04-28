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

import np.edu.nast.sies.entity.Subject;
import np.edu.nast.sies.repository.SubjectRepository;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {
	@Autowired
	private SubjectRepository fr;
	// /subject: GET => Display all Subject info  
	@GetMapping
	public List<Subject> findSubject(){
		return fr.findAll();
	}
	// /subject/1: GET => Display Subject info of id 1
	@GetMapping("/{id}")
	public Subject findById(@PathVariable Long id){
		Subject subject=null;
		if(fr.existsById(id)) {
			subject= fr.findById(id).get();
		}
		return subject;
	}
	// /subject: POST => Create Subject record
	@PostMapping
	public Subject createSubject(@RequestBody Subject c) {
		return fr.save(c);
	}
	// /subject: PUT => Update Subject info based on their id 
	@PutMapping("/{id}")
	public Subject updateSubject(@PathVariable Long id,@RequestBody Subject c) {
		//return fr.save(c);
		if (fr.existsById(id)) {
	        c.setId(id); // Set the ID in the updated subject object
	        return fr.save(c);
	    }
	    return null;
	}
	// /subject/2: DELETE => Delete Subject info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteSubject(@PathVariable Long id) {
		fr.deleteById(id);
	}
}
