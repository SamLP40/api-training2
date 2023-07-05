package fr.fms.dao;

import fr.fms.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

//@CrossOrigin("*")
//@RepositoryRestResource
public interface TrainingRepository extends JpaRepository <Training, Long> {
}

// Note : Via RepositoryRestRessource, le lien utilisé n'est plus localhost:8080/api/trainings, mais juste localhost:8080/trainings !