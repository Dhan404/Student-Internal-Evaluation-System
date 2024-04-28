package np.edu.nast.sies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import np.edu.nast.sies.dto.EvaluationParameterDTO;
import np.edu.nast.sies.entity.EvaluationParameter;
import np.edu.nast.sies.repository.EvaluationParameterRepository;
import np.edu.nast.sies.service.EvaluationParameterService;

@RestController
@RequestMapping("/evaluation-parameter")
@CrossOrigin(origins = "http://localhost:4200")
public class EvaluationParameterController {

    @Autowired
    private EvaluationParameterRepository evaluationParameterRepo;

    @Autowired
    private EvaluationParameterService evaluationParameterService;
    
    @GetMapping
    public List<EvaluationParameter> findEvaluationParameters() {
        return evaluationParameterRepo.findAll();
    }

    @GetMapping("/{id}")
    public EvaluationParameter findById(@PathVariable Long id) {
        return evaluationParameterRepo.findById(id).orElse(null);
    }
    
    @GetMapping("/parameters")
    public List<EvaluationParameter> findEvaluationParametersBySubjectId(@RequestParam Long subjectId) {
    	System.out.println(subjectId);
        return evaluationParameterRepo.findBySubjectId(subjectId);
    }
    
    

    @PostMapping
    public EvaluationParameter createEvaluationParameter(@RequestBody EvaluationParameterDTO evaluationParameterDTO) {
        EvaluationParameter evaluationParameter = evaluationParameterService.createEvaluationParameter(evaluationParameterDTO);
        return evaluationParameterRepo.save(evaluationParameter);
    }
    @PutMapping("/{id}")
    public EvaluationParameter updateEvaluationParameter(@PathVariable Long id, @RequestBody EvaluationParameterDTO evaluationParameterDTO) {
        EvaluationParameter evaluationParameter = evaluationParameterService.createEvaluationParameter(evaluationParameterDTO);
        evaluationParameter.setId(id);
        return evaluationParameterRepo.save(evaluationParameter);
    }

    @DeleteMapping("/{id}")
    public void deleteEvaluationParameter(@PathVariable Long id) {
        evaluationParameterRepo.deleteById(id);
    }
}
