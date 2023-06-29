package fr.fms.service;

import fr.fms.dao.TrainingRepository;
import fr.fms.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements ITrainingService {
    @Autowired
    TrainingRepository trainingRepository;
    @Override
    public List<Training> getTraining() throws Exception {

        return trainingRepository.findAll();
    }
    @Override
    public Training saveTraining(Training t) {
        return trainingRepository.save(t);
    }
    @Override
    public void deleteTraining(Long id) {
    }

    @Override
    public Optional<Training> getTrainingById(Long id) {
        return Optional.empty();
    }

    public Optional<Training> readTraining(Long id) {
        Optional<Training> optional = trainingRepository.findById(id);
        return optional.isPresent() ? optional : null;
    }
}
