package pl.altkom.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.altkom.car.model.User;
import pl.altkom.car.repository.UsersRepositoryJpa;

@Service
public class UserService  {
    private UsersRepositoryJpa usersRepositoryJpa;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UsersRepositoryJpa usersRepositoryJpa, PasswordEncoder passwordEncoder) {
        this.usersRepositoryJpa = usersRepositoryJpa;
        this.passwordEncoder = passwordEncoder;
    }

    public  void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        usersRepositoryJpa.save(user);

    }


}
