package com.deepak.school.controller;

import com.deepak.school.entity.Admin;
import com.deepak.school.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @PostMapping("/admin")
    public String createAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return "Success creating Admin";
    }
}
