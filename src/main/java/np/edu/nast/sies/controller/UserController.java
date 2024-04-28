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

import np.edu.nast.sies.dto.UserDTO;
import np.edu.nast.sies.entity.User;
import np.edu.nast.sies.repository.UserRepository;
import np.edu.nast.sies.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
//	/user: GET => Display all users info
//	/user/1: GET =>Display user info of id 1
//	/user:POST => Create User record
//	/user:PUT =>Update user info based on their id
//	/user/2:DELETE => Delete user info based on their id
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	///role: GET => Display all users info
	@GetMapping
	public List<User> findUsers() {
		return userRepo.findAll();
	}
	
	///role/1: GET =>Display user info of id 1
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user=null;
		if(userRepo.existsById(id)) {
			user= userRepo.findById(id).get();
		}
		return user;
	}
	///role:POST => Create user record
	@PostMapping
	public User createUser(@RequestBody UserDTO u) {
//		User user = userService.createUser(u);
//		userRep.save(user);
		
		return userRepo.save(userService.createUser(u));
//		u.setCreatedAt(new Date());
//		return userRepo.save(u);
	}
	
	///role:PUT =>Update user info based on their id
	@PutMapping("/{id}")
	public  User updateUser(@PathVariable Long id, @RequestBody UserDTO u) {
		User user = userService.createUser(u);
		user.setId(id);
		return userRepo.save(user);
	}
	
	///role/2:DELETE => Delete user info based on their id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
	}
	@PostMapping("/authenticate")
	public User authenticate(@RequestBody UserDTO user) {
		if(userRepo.existsByUsernameAndPassword(user.getUsername(), user.getPassword())) {
			return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		}
	else {
		return null;
		}

	}
}
