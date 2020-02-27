package cloud.cholewa.warehouse.users.boundary;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@Setter
public class UserResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private String mail;
    private LocalDateTime createdAt;
}
