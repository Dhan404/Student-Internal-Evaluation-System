package np.edu.nast.sies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.edu.nast.sies.entity.EvaluationParameter;

@Repository
public interface EvaluationParameterRepository extends JpaRepository<EvaluationParameter, Long> {

	List<EvaluationParameter> findBySubjectId(Long subjectId);
}