package cloud.cholewa.warehouse.users.boundary;

import cloud.cholewa.warehouse.users.control.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserApi {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody CreateUser createUser) {
        UserResponse userResponse = userService.addUser(createUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
