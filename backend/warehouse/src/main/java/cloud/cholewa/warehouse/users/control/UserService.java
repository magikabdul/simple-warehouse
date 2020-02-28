package cloud.cholewa.warehouse.users.control;

import cloud.cholewa.warehouse.configuration.DefaultAdmin;
import cloud.cholewa.warehouse.exceptions.UserCreationError;
import cloud.cholewa.warehouse.users.boundary.CreateUser;
import cloud.cholewa.warehouse.users.boundary.UserRepository;
import cloud.cholewa.warehouse.users.boundary.UserResponse;
import cloud.cholewa.warehouse.users.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private DefaultAdmin admin;

    @EventListener(ApplicationReadyEvent.class)
    public void addDefaultAdmin() {
        if (!userRepository.findById(1L).isPresent()) {
            User user = new User();
            user.setUsername(admin.getUsername());
            user.setPassword(encoder.encode(admin.getPassword()));
            user.setFirstName("");
            user.setLastName("");
            user.setMail("");
            user.setCreatedAt(LocalDateTime.now());

            userRepository.save(user);
        }
    }

    public UserResponse addUser(CreateUser createUser) {
        if (userRepository.findByUsername(createUser.getUserName()).isPresent()) {
            throw new UserCreationError("Username already exists");
        }

        if (userRepository.findByMail(createUser.getMail()).isPresent()) {
            throw new UserCreationError("Mail already exists");
        }

        User user = new User();
        user.setUsername(createUser.getUserName());
        user.setPassword(encoder.encode(createUser.getUserName()));
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setMail(createUser.getMail());
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(savedUser.getUsername());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setMail(savedUser.getMail());
        userResponse.setCreatedAt(savedUser.getCreatedAt());

        return userResponse;
    }
}
