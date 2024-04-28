package np.edu.nast.sies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.edu.nast.sies.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Boolean existsByUsernameAndPassword(String username, String password);
	public User findByUsernameAndPassword(String username, String password);
	
}
