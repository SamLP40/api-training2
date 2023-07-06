package fr.fms.service;

import fr.fms.dao.ImageRepository;
import fr.fms.dao.TrainingRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Image;
import fr.fms.entities.Training;
import fr.fms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingService implements ITrainingService {
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ImageRepository imageRepository;
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

    @Override
    public List<User> getUser() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public List<Image> getImage() throws Exception {
        return imageRepository.findAll();
    }
    @Override
    public Image saveImage(Image img) { return imageRepository.save(img); }

    @Override
    public void deleteImage(Long id) {
    }

    public Optional<Image> getImageById(Long id) {
        return Optional.empty();
    }
    public Optional<Image> readImage(Long id) {
        Optional<Image> optional = imageRepository.findById(id);
        return optional.isPresent() ? optional : null;
    }

}