package fr.fms.web;

import fr.fms.entities.Training;
import fr.fms.exceptions.RecordNotFoundException;
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

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@CrossOrigin("*")
@RestController
@RequestMapping("/api") // environment.ts => localhost:8080/api
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings") // api/trainings
    public List<Training> allTrainings() throws Exception {
        return implTrainingService.getTraining();
    }
 /*   @PostMapping("/training")
    public Training saveTraining(@RequestBody Training t){
        return implTrainingService.saveTraining(t);
    } */

    @DeleteMapping("/training/{id}") // api/training/nom de la formation
    public void deleteTraining(@PathVariable("id") Long id) {
        implTrainingService.deleteTraining(id);
    }

    @GetMapping("/trainings/{id}")
    public Training getTrainingById(@PathVariable("id") Long id){
return implTrainingService.readTraining(id)
        .orElseThrow( ()-> new RecordNotFoundException("l'Id de la formation "+ id +" n'existe pas"));

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
    @PutMapping("/training/{id}")
    public ResponseEntity <Training> putTraining(@RequestBody Training train, @PathVariable Long id) {

        Optional<Training> existingTraining=implTrainingService.getTrainingById(id);
        if(existingTraining != null) {
             train.setId(id);
             Training updateTrainingStatus=implTrainingService.saveTraining(train);
            return new ResponseEntity<>(updateTrainingStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}