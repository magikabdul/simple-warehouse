package cloud.cholewa.warehouse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserCreationError extends RuntimeException {
    public UserCreationError(String message) {
        super(message);
    }
}
