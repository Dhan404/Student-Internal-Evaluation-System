package np.edu.nast.sies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.sies.dto.EvaluationParameterDTO;
import np.edu.nast.sies.entity.Evaluation;
import np.edu.nast.sies.entity.EvaluationParameter;
import np.edu.nast.sies.entity.Subject;
import np.edu.nast.sies.repository.EvaluationRepository;
import np.edu.nast.sies.repository.SubjectRepository;

@Service
public class EvaluationParameterService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	 @Autowired
	 private EvaluationRepository evaluationRepository;
	
	public EvaluationParameter createEvaluationParameter(EvaluationParameterDTO evaluationParameterDTO) {
		EvaluationParameter evaluationParameter = new EvaluationParameter();
		evaluationParameter.setWeight(evaluationParameterDTO.getWeight());
		evaluationParameter.setMarks(evaluationParameterDTO.getMarks());
		evaluationParameter.setNature(evaluationParameterDTO.getNature());
		evaluationParameter.setTh(evaluationParameterDTO.getTh());
		evaluationParameter.setPr(evaluationParameterDTO.getPr());
		
		Subject subject = subjectRepository.findById(evaluationParameterDTO.getSubjectId()).get();
		evaluationParameter.setSubject(subject);
		
		// Assuming there is a repository for Evaluation entity (EvaluationRepository), you can fetch the Evaluation object here
		 Evaluation evaluation = evaluationRepository.findById(evaluationParameterDTO.getEvaluationId()).get();
		 evaluationParameter.setEvaluation(evaluation);
		
		return evaluationParameter;
	}
}
