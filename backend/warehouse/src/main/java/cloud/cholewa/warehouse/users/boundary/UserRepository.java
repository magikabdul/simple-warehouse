package cloud.cholewa.warehouse.users.boundary;

import cloud.cholewa.warehouse.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);

    Optional<User> findByMail(String mail);
}
