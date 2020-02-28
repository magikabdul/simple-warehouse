package cloud.cholewa.warehouse.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "admin.default")
@Getter
@Setter
public class DefaultAdmin {
    private String username;
    private String password;
}
