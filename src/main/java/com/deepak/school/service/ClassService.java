package com.deepak.school.service;

import com.deepak.school.entity.Class;
import com.deepak.school.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository repository;
    public Class createClass(Class classes){
       return repository.save(classes);
    }

    public List<Class> getAllClasses() {
       return repository.findAll();
    }
}
