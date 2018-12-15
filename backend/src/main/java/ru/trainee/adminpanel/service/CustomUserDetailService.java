package ru.trainee.adminpanel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.trainee.adminpanel.data.model.CustomUserDetail;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.data.repository.UserRepository;

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