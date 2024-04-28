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

import np.edu.nast.sies.entity.Role;
import np.edu.nast.sies.repository.RoleRepository;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
	///role: GET => Display all roles info
	///role/1: GET =>Display role info of id 1
	///role:POST => Create role record
	///role:PUT =>Update role info based on their id
	///role/2:DELETE => Delete role info based on their id
	@Autowired
	private RoleRepository roleRepo;
	///role: GET => Display all roles info
	@GetMapping
	public List<Role> findRoles() {
		return roleRepo.findAll();
	}
	
	///role/1: GET =>Display role info of id 1
	@GetMapping("/{id}")
	public Role findById(@PathVariable Long id) {
		Role role=null;
		if(roleRepo.existsById(id)) {
			role= roleRepo.findById(id).get();
		}
		return role;
	}
	///role:POST => Create role record
	@PostMapping
	public Role createRole(@RequestBody Role r) {
		return roleRepo.save(r);
	}
	
	///role:PUT =>Update role info based on their id
	@PutMapping
	public  Role updateRole(@RequestBody Role role) {
		return roleRepo.save(role);
	}
	
	///role/2:DELETE => Delete role info based on their id
	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable Long id) {
		roleRepo.deleteById(id);
	}	
}
