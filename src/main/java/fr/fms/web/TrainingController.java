package fr.fms.web;

import fr.fms.entities.Training;
import fr.fms.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/training")
    public List<Training> allTrainings() throws Exception {
        return implTrainingService.getTraining();
    }
 /*   @PostMapping("/training")
    public Training saveTraining(@RequestBody Training t){
        return implTrainingService.saveTraining(t);
    } */

    @DeleteMapping("/training/{id}")
    public void deleteTraining(@PathVariable("id") Long id) {
        implTrainingService.deleteTraining(id);
    }

    @GetMapping("/training/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable("id") Long id){
        Optional<Training> training = implTrainingService.readTraining(id);
        if(training.isPresent()) {
            return new ResponseEntity<>(training.get(), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/training")
    public ResponseEntity saveTraining(@RequestBody Training t){

        Training training = implTrainingService.saveTraining(t);
        if(Objects.isNull(training)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(training.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
