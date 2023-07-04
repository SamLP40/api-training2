package fr.fms.dao;

import fr.fms.entities.Training;
import fr.fms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
