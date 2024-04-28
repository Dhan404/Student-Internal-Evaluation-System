package np.edu.nast.sies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.ProgramCourseDTO;
import np.edu.nast.sies.entity.Course;
import np.edu.nast.sies.entity.Program;
import np.edu.nast.sies.entity.ProgramCourse;
import np.edu.nast.sies.entity.Semester;
import np.edu.nast.sies.repository.CourseRepository;
import np.edu.nast.sies.repository.ProgramRepository;
import np.edu.nast.sies.repository.SemesterRepository;

@Service
public class ProgramCourseService {
	
	@Autowired
	private SemesterRepository repo;
	
	@Autowired
	private ProgramRepository repop;
	
	@Autowired
	private CourseRepository repoc;
	
	public ProgramCourse createProgramCourse(ProgramCourseDTO programCourseDTO) {
		ProgramCourse pc = new ProgramCourse();
		
		
		Semester semester= repo.findById(programCourseDTO.getSemesterId()).get();
		pc.setSemester(semester);
		
		Program program= repop.findById(programCourseDTO.getProgramId()).get();
		pc.setProgram(program);
		
		Course course= repoc.findById(programCourseDTO.getCourseId()).get();
		pc.setCourse(course);
		
		return pc;
		
	}
}
