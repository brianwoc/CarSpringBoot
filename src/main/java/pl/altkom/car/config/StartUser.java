package pl.altkom.car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.altkom.car.model.User;
import pl.altkom.car.repository.UsersRepositoryJpa;

@Configuration
public class StartUser {


    public StartUser(UsersRepositoryJpa userDao, PasswordEncoder passwordEncoder) {
        User user1 = new User();
        user1.setUsername("brian");
        user1.setPassword(passwordEncoder.encode("1234"));
        user1.setEmail("br.skrzynka@gmail.com");
        user1.setEnabled(true);
        user1.setRole("ROLE_ADMIN");
        userDao.save(user1);
    }
}
