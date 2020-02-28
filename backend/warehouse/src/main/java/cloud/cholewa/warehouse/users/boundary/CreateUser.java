package cloud.cholewa.warehouse.users.boundary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUser {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mail;
}
