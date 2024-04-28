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

import np.edu.nast.sies.entity.Faculty;
import np.edu.nast.sies.repository.FacultyRepository;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultyController {
	@Autowired
	private FacultyRepository fr;
	// /faculty: GET => Display all faculty info  
	@GetMapping
	public List<Faculty> findfaculty(){
		return fr.findAll();
	}
	// /course/1: GET => Display course info of id 1
	@GetMapping("/{id}")
	public Faculty findById(@PathVariable Long id){
		Faculty faculty=null;
		if(fr.existsById(id)) {
			faculty= fr.findById(id).get();
		}
		return faculty;
	}
	// /faculty: POST => Create faculty record
	@PostMapping
	public Faculty createFaculty(@RequestBody Faculty c) {
		return fr.save(c);
	}
	// /faculty: PUT => Update course info based on their id 
	@PutMapping("/{id}")
	public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty c) {
	    // Check if the faculty with the given ID exists before updating
	    if (fr.existsById(id)) {
	        c.setId(id); // Set the ID in the updated faculty object
	        return fr.save(c);
	    }
	    return null; // Or you can throw an exception or handle the not-found case as needed
	}

	// /faculty/2: DELETE => Delete faculty info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteFaculty(@PathVariable Long id) {
		fr.deleteById(id);
	}
}
