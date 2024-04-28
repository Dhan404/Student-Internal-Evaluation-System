package np.edu.nast.sies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.edu.nast.sies.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>{

}
