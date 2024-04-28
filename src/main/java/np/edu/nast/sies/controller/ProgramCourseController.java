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

import np.edu.nast.sies.dto.ProgramCourseDTO;
import np.edu.nast.sies.entity.ProgramCourse;
import np.edu.nast.sies.repository.ProgramCourseRepository;
import np.edu.nast.sies.service.ProgramCourseService;

@RestController
@RequestMapping("/programcourse")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramCourseController {
	@Autowired
	private ProgramCourseRepository repo;
	
	@Autowired
    private ProgramCourseService service;
	
	// /programcourse: GET => Display all ProgramCourse info  
	@GetMapping
	public List<ProgramCourse> findProgramCourse(){
		return repo.findAll();
	}
	// /programcourse/1: GET => Display ProgramCourse info of id 1
	@GetMapping("/{id}")
	public ProgramCourse findById(@PathVariable Long id){
		ProgramCourse r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /programcourse: POST => Create ProgramCourse record
	@PostMapping
	public ProgramCourse createProgramCourse(@RequestBody ProgramCourseDTO c) {
		return repo.save(service.createProgramCourse(c));
	}
	// /programcourse: PUT => Update ProgramCourse info based on their id 
	@PutMapping("/{id}")
	public ProgramCourse updateProgramCourse(@PathVariable Long id, @RequestBody ProgramCourseDTO c) {
		ProgramCourse pc = service.createProgramCourse(c);
		pc.setId(id);
		return repo.save(pc);
	}
	// /programcourse/2: DELETE => Delete ProgramCourse info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteProgramCourse(@PathVariable Long id) {
		repo.deleteById(id);
	}
}

