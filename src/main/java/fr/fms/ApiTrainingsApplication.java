package fr.fms;

import fr.fms.dao.TrainingRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.Training;
import fr.fms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiTrainingsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		trainingRepository.save(new Training(null, "Java", "SE8", 1500.0,10));
		trainingRepository.save(new Training(null, "DotNet", "Core", 2000.0,10));
		trainingRepository.save(new Training(null, "PowerBi", "Business Intelligence", 1650.0,7));
		trainingRepository.save(new Training(null, "Php", "HTML mais en moins bien", 400.0,13));
		trainingRepository.save(new Training(null, "Python", "Django", 2500.0,3));
		trainingRepository.save(new Training(null, "NodeJS", "JS", 999.99,6));
		trainingRepository.save(new Training(null, "Word", "Office", 1350.0,30));
		userRepository.save(new User(null, "test@gmail.com", "test"));

	}

//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/images/")
//				.addResourceLocations("file:/path/to/your/images/directory/");
//	}
}

// Requêtes à tester sur Postman :
// Get/Post = OK, retourne 200 (get) et 201 (post)
// Delete = fonctionne, la dernière donnée (User) a été supprimée (retourne 204)
// Put(Update) = OK, passer par un get, modifier en passant par le body, copier, et entrer la requête put (avec l'id)