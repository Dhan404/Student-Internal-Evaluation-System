package np.edu.nast.sies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.edu.nast.sies.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

	Optional<Subject> findById(Subject subjectId);

}
