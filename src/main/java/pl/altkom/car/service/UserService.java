package pl.altkom.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.altkom.car.model.User;
import pl.altkom.car.repository.UsersRepositoryJpa;

@Service
public class UserService  {
    private UsersRepositoryJpa usersRepositoryJpa;

    @Autowired
    public UserService(UsersRepositoryJpa usersRepositoryJpa) {
        this.usersRepositoryJpa = usersRepositoryJpa;
    }


    public  void addUser(User user){
        usersRepositoryJpa.save(user);
    }


}
