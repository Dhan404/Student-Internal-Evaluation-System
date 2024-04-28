package np.edu.nast.sies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.StudentDTO;
import np.edu.nast.sies.entity.Student;
import np.edu.nast.sies.entity.User;
import np.edu.nast.sies.entity.Program;
import np.edu.nast.sies.entity.Semester;
import np.edu.nast.sies.repository.UserRepository;
import np.edu.nast.sies.repository.ProgramRepository;
import np.edu.nast.sies.repository.SemesterRepository;

@Service
public class StudentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setLastName(studentDTO.getLastName());
        student.setGender(studentDTO.getGender());
        student.setDob(studentDTO.getDob());
        student.setAddress(studentDTO.getAddress());
        student.setRegistrationNo(studentDTO.getRegistrationNo());
        student.setExamRoll(studentDTO.getExamRoll());
        student.setEmail(studentDTO.getEmail());
        student.setMobile(studentDTO.getMobile());
        student.setProfilePic(studentDTO.getProfilePic());

        // Assuming the userId is already available in the DTO
        User user= userRepository.findById(studentDTO.getUserId()).get();
		student.setUser(user);

        // Assuming the programId is already available in the DTO
		Program program= programRepository.findById(studentDTO.getProgramId()).get();
		student.setProgram(program);

        // Assuming the semesterId is already available in the DTO
		Semester semester= semesterRepository.findById(studentDTO.getSemesterId()).get();
		student.setSemester(semester);

        return student;
    }
}
