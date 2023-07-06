package fr.fms.web;

import fr.fms.dao.ImageRepository;
import fr.fms.entities.Image;
import fr.fms.entities.Training;
import fr.fms.service.ImplTrainingService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    ImplTrainingService implTrainingService;

    @GetMapping("/images")
    public List<Image> getAllImages() throws Exception {
        return implTrainingService.getImage();

    }

    @PostMapping("/images")
    public Image saveImage(@RequestBody Image img) {
        return implTrainingService.saveImage(img);
    }

    @DeleteMapping("/images/{id}")
    public void deleteImage(@PathVariable("id") Long id) {
        implTrainingService.deleteImage(id);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable("id") Long id) {
        Optional<Image> image = implTrainingService.readImage(id);
        if (image.isPresent()) {
            return new ResponseEntity<>(image.get(), HttpStatus.OK);
        }
        return null;
    }

}
