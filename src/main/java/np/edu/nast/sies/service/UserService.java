package np.edu.nast.sies.service;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.UserDTO;
import np.edu.nast.sies.entity.Role;
import np.edu.nast.sies.entity.User;
import np.edu.nast.sies.repository.RoleRepository;

@Service
public class UserService {
    @Autowired
    private RoleRepository roleRepository;

    public User createUser(UserDTO u) {
        User user = new User();
        user.setCreatedAt(new Date());
        user.setStatus(1);
        user.setLocked(false);
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());

        // Fetch Role entity based on the provided role ID
        Role role = roleRepository.findById(u.getRoleId()).get();

        System.out.println(role.getId());
        user.setRole(role);
        return user;
    }
}

