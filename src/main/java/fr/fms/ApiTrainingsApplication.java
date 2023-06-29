package fr.fms;

import fr.fms.dao.TrainingRepository;
import fr.fms.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;
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

	}
}
