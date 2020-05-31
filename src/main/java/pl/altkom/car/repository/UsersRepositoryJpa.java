package pl.altkom.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.car.model.User;

import java.util.Optional;

@Repository
public interface UsersRepositoryJpa extends JpaRepository<User, Long> {

 Optional<User> findByUsername(String username);
}
