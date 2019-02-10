package co.nilin.oauth2.demo.data.repository;

import co.nilin.oauth2.demo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);

}
