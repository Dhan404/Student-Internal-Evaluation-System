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
import org.springframework.web.bind.annotation.RestController;

import np.edu.nast.sies.entity.Evaluation; // Change Subject to Evaluation
import np.edu.nast.sies.repository.EvaluationRepository; // Change SubjectRepository to EvaluationRepository

@RestController
@RequestMapping("/evaluation") // Change "/subject" to "/evaluation"
@CrossOrigin(origins = "http://localhost:4200")
public class EvaluationController { // Change SubjectController to EvaluationController

    @Autowired
    private EvaluationRepository fr; // Change SubjectRepository to EvaluationRepository

    // /evaluation: GET => Display all Evaluation info
    @GetMapping
    public List<Evaluation> findEvaluation() { // Change findSubject() to findEvaluation()
        return fr.findAll();
    }

    // /evaluation/1: GET => Display Evaluation info of id 1
    @GetMapping("/{id}")
    public Evaluation findById(@PathVariable Long id) { // Change Subject to Evaluation
        Evaluation evaluation = null; // Change Subject to Evaluation
        if (fr.existsById(id)) {
            evaluation = fr.findById(id).get(); // Change Subject to Evaluation
        }
        return evaluation; // Change Subject to Evaluation
    }

    // /evaluation: POST => Create Evaluation record
    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation c) { // Change Subject to Evaluation
        return fr.save(c);
    }

    // /evaluation: PUT => Update Evaluation info based on their id
    @PutMapping("/{id}")
    public Evaluation updateEvaluation(@PathVariable Long id, @RequestBody Evaluation c) { // Change Subject to Evaluation
        if (fr.existsById(id)) {
            c.setId(id); // Set the ID in the updated evaluation object // Change Subject to Evaluation
            return fr.save(c);
        }
        return null;
    }

    // /evaluation/2: DELETE => Delete Evaluation info based on their id 2
    @DeleteMapping("/{id}")
    public void deleteEvaluation(@PathVariable Long id) { // Change Subject to Evaluation
        fr.deleteById(id);
    }
}
