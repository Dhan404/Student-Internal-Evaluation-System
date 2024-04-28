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

import np.edu.nast.sies.dto.ProgramDTO;
import np.edu.nast.sies.entity.Program;
import np.edu.nast.sies.repository.ProgramRepository;
import np.edu.nast.sies.service.ProgramService;

@RestController
@RequestMapping("/program")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramController {
	@Autowired
	private ProgramRepository repo;
	
	@Autowired
	private ProgramService proService;
	// /program: GET => Display all Program info  
	@GetMapping
	public List<Program> findProgram(){
		return repo.findAll();
	}
	// /program/1: GET => Display Program info of id 1
	@GetMapping("/{id}")
	public Program findById(@PathVariable Long id){
		Program r=null;
		if(repo.existsById(id)) {
			r = repo.findById(id).get();
		}
		return r;
	}
	// /program: POST => Create Program record
	@PostMapping
	public Program createProgram(@RequestBody ProgramDTO c) {
		
//		System.out.println(c.getFacultyId());
//		System.out.println(c.getProgramCode());
//		System.out.println(c.getProgramName());
		return repo.save(proService.createProgram(c));
	}
	// /program: PUT => Update Program info based on their id 
	@PutMapping("/{id}")
	public Program updateProgram(@PathVariable Long id, @RequestBody ProgramDTO c) {
		
		Program program = proService.createProgram(c);
		program.setId(id);
		return repo.save(program);
	}
	// /program/2: DELETE => Delete Program info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteProgram(@PathVariable Long id) {
		repo.deleteById(id);
	}
}

