package np.edu.nast.sies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.CourseDTO;
import np.edu.nast.sies.entity.Course;
import np.edu.nast.sies.entity.Subject;
import np.edu.nast.sies.repository.SubjectRepository;

@Service
public class CourseService {
	@Autowired
	private SubjectRepository repo;
	
	public Course createCourse(CourseDTO courseDTO) {
		Course course = new Course();
		course.setCode(courseDTO.getCode());
		course.setCredit(courseDTO.getCredit());
		course.setSyllabus(courseDTO.getSyllabus());
		course.setNature(courseDTO.getNature());
		course.setTh(courseDTO.getTh());
		course.setPr(courseDTO.getPr());
		course.setRequirementType(courseDTO.getRequirementType());
		
		Subject subject= repo.findById(courseDTO.getSubjectId()).get();
		course.setSubject(subject);
		return course;
	}
}
