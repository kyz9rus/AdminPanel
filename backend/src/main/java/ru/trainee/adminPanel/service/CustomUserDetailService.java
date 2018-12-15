package ru.trainee.adminPanel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.trainee.adminPanel.model.CustomUserDetail;
import ru.trainee.adminPanel.model.User;
import ru.trainee.adminPanel.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(login);

        user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user.
                map(CustomUserDetail::new).get();
    }
}