package ru.trainee.adminPanel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trainee.adminPanel.model.Admin;
import ru.trainee.adminPanel.repository.AdminRepository;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin getAdminByLogin(String login){
        Optional<Admin> admin = adminRepository.findById(login);
        return admin.get();
    }
}
