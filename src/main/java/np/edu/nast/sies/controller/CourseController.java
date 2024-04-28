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

import np.edu.nast.sies.dto.CourseDTO;
import np.edu.nast.sies.entity.Course;
import np.edu.nast.sies.repository.CourseRepository;
import np.edu.nast.sies.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private CourseService service;
	
	// /course: GET => Display all course info  
	@GetMapping
	public List<Course> findCourses(){
		return courseRepo.findAll();
	}
	// /course/1: GET => Display course info of id 1
	@GetMapping("/{id}")
	public Course findById(@PathVariable Long id){
		Course course=null;
		if(courseRepo.existsById(id)) {
			course= courseRepo.findById(id).get();
		}
		return course;
	}
	// /course: POST => Create course record
	@PostMapping
	public Course createCourse(@RequestBody CourseDTO c) {
		return courseRepo.save(service.createCourse(c));
	}
	// /course: PUT => Update course info based on their id 
	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody CourseDTO c) {
		
		Course course = service.createCourse(c);
		course.setId(id);
		return courseRepo.save(course);
	}
	// /course/2: DELETE => Delete course info based on their id 2
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseRepo.deleteById(id);
	}
}
