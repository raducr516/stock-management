package application.stock.servicies;

import application.stock.data.User;
import application.stock.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LogIn {
    private final UserRepository userRepo;
    public LogIn(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    public User logIn(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful for user: " + username);
            return user;
        }
        System.out.println("Invalid username or password");
        return null;
    }
}
