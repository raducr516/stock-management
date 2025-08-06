package application.stock.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import application.stock.servicies.LogIn;
import application.stock.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class LogInController {

    private final LogIn logInService;

    @Autowired
    public LogInController(LogIn logInService) {
        this.logInService = logInService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return logInService.logIn(username, password);
    }
}