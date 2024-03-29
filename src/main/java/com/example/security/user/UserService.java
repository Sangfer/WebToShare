/*
*
*/

package com.example.security.user;

import com.example.security.user.User;
import com.example.security.user.UserRepository;
import com.example.security.user.UserRole;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author
 */
@Component
public class UserService implements UserDetailsService {
    
    @Inject
    UserRepository repo;
    
    public final PasswordEncoder encoder = new BCryptPasswordEncoder();
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repo.findOne(username);
        if (u == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(u.userName, u.derivedPassword, u.getRoles());
    }

    public void saveUserComputingDerivedPassword(User u, String rawPassword) {
        setComputingDerivedPassword(u, rawPassword);
        repo.save(u);
    }

    public void setComputingDerivedPassword(User u, String rawPassword) {
        String codedPassword = encoder.encode(rawPassword);
        u.setDerivedPassword(codedPassword);
    }

    public void makeUserAdmin(String username) {
        User u = repo.findOne(username);
        u.getRoles().add(UserRole.ADMIN);
        repo.save(u);
    }

    public List<User> listAllUsers() {
        return repo.findAllByOrderByUserName();
    }
    
}