package pl.altkom.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.altkom.car.repository.UsersRepositoryJpa;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    private UsersRepositoryJpa usersRepositoryJpa;

    @Autowired
    public UserDetailsServiceImpl(UsersRepositoryJpa usersRepositoryJpa) {
        this.usersRepositoryJpa = usersRepositoryJpa;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepositoryJpa.findByUsername(username).get();
    }
}
