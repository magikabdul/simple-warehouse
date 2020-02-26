package cloud.cholewa.warehouse.users.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @GetMapping
    public String test() {
        return "works!!";
    }
}
