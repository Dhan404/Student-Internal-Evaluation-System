package np.edu.nast.sies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.ProgramDTO;
import np.edu.nast.sies.entity.Faculty;
import np.edu.nast.sies.entity.Program;
import np.edu.nast.sies.repository.FacultyRepository;

@Service
public class ProgramService {
	@Autowired
	private FacultyRepository repo;
	
	public Program createProgram(ProgramDTO programDTO) {
		Program program = new Program();
		program.setProgramCode(programDTO.getProgramCode());
		program.setProgramName(programDTO.getProgramName());
		
		Faculty faculty= repo.findById(programDTO.getFacultyId()).get();
		program.setFaculty(faculty);
		return program;
	}
}
