package ru.trainee.adminpanel.service;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.trainee.adminpanel.data.model.User;

public class Authentication {
    public User getUserFromAuthentication() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;

        try {
            if (!authentication.getName().equals("anonymousUser"))
                user = (User) authentication.getPrincipal();
            else
                user = new User();

        } catch (NullPointerException e) {
            System.out.println("There is no authentication user yet.");
        }

        return user;
    }
}
