package fr.fms.web;

import fr.fms.entities.User;
import fr.fms.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/users")
    public List<User> getUsers() throws Exception {
        return implTrainingService.getUser();
    }
}
