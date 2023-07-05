package fr.fms.web;

import fr.fms.dao.ImageRepository;
import fr.fms.entities.Image;
import fr.fms.service.ImplTrainingService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ImageController  {
    @Autowired
    ImplTrainingService implTrainingService;

    @GetMapping("/images")
    public List<Image> getAllImages() throws Exception {
       return implTrainingService.getImage();

    }
}
