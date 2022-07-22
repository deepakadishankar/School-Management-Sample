package com.deepak.school.controller;

import com.deepak.school.dto.classes.ClassRequestDto;
import com.deepak.school.entity.Class;
import com.deepak.school.mapper.ClassMapper;
//import com.deepak.school.propertyEditor.ClassPropertyEditor;
import com.deepak.school.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassMapper mapper;
    @Autowired
    ClassService service;

    @PostMapping("/classes")
    public Class createClass(@RequestBody ClassRequestDto requestDto) {
        Class classes = mapper.mapClassRequestDtoToClass(requestDto);
        return service.createClass(classes);
    }
    @GetMapping("/classes")
    public List<Class> getAllTeacher(){
        return service.getAllClasses();
    }

}
