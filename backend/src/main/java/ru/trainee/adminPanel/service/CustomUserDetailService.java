package ru.trainee.adminPanel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.trainee.adminPanel.model.CustomUserDetails;
import ru.trainee.adminPanel.model.User;
import ru.trainee.adminPanel.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomAdminDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user.
                map(CustomUserDetails::new).get();
    }
}