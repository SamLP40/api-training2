package fr.fms.service;

import fr.fms.entities.Training;
import fr.fms.entities.User;

import java.util.List;
import java.util.Optional;

public interface ITrainingService  {


    public List<Training> getTraining() throws Exception;
    public Training saveTraining(Training t);
    public void deleteTraining(Long id);
    public Optional<Training> getTrainingById(Long id);

    List<User> getUser() throws Exception;
}
