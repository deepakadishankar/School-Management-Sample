package com.deepak.school.controller;

import com.deepak.school.dto.classTeacher.ClassTeacherRequestDto;
import com.deepak.school.dto.student.StudentRequestDto;
import com.deepak.school.entity.ClassTeacher;
import com.deepak.school.entity.Student;
import com.deepak.school.mapper.ClassTeacherMapper;
import com.deepak.school.service.ClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassTeacherController {
    @Autowired
    ClassTeacherMapper mapper;
    @Autowired
    ClassTeacherService service;

    @PostMapping("/class-teachers")
    public ClassTeacher assignClassTeacher(@RequestBody ClassTeacherRequestDto requestDto){
        ClassTeacher classTeacher = mapper.mapClassTeacherRequestDtoToClassTeacher(requestDto);
        return service.createClassTeacher(classTeacher);
    }
}
