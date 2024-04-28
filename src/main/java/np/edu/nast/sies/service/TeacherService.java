package np.edu.nast.sies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.TeacherDTO;
import np.edu.nast.sies.entity.Teacher;
import np.edu.nast.sies.entity.User; // 
import np.edu.nast.sies.repository.UserRepository; // Assuming you have the UserRepository

@Service
public class TeacherService {
    

    @Autowired
    private UserRepository userRepository;

    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setMiddleName(teacherDTO.getMiddleName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setGender(teacherDTO.getGender());
        teacher.setDob(teacherDTO.getDob());
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setMobile(teacherDTO.getMobile());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setPanNumber(teacherDTO.getPanNumber());
        teacher.setDepartment(teacherDTO.getDepartment());
        teacher.setQualification(teacherDTO.getQualification());
        teacher.setExperience(teacherDTO.getExperience());
        teacher.setProfilePic(teacherDTO.getProfilePic());

        // Assuming the userId is already available in the DTO
//        Long userId = teacherDTO.getUserId();
//        User user = userRepository.findById(userId).orElse(null);
//        teacher.setUser(user);
        User user= userRepository.findById(teacherDTO.getUserId()).get();
		teacher.setUser(user);

        return teacher;
    }
}
