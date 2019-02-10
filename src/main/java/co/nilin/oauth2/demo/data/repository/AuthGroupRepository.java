package co.nilin.oauth2.demo.data.repository;

import co.nilin.oauth2.demo.data.entity.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup,Long> {
    List<AuthGroup> findByUsername(String username);
}
