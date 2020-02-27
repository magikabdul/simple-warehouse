package cloud.cholewa.warehouse.users.control;

import cloud.cholewa.warehouse.users.boundary.CreateUser;
import cloud.cholewa.warehouse.users.boundary.UserRepository;
import cloud.cholewa.warehouse.users.boundary.UserResponse;
import cloud.cholewa.warehouse.users.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    public UserResponse addUser(CreateUser createUser) {
        User user = new User();
        user.setUserName(createUser.getUserName());
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setMail(createUser.getMail());
        user.setCreateAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(savedUser.getUserName());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setMail(savedUser.getMail());
        userResponse.setCreatedAt(savedUser.getCreateAt());

        return new UserResponse();
    }
}
