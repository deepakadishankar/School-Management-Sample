package com.deepak.school.controller;

import com.deepak.school.dto.subjectTeacherRequestDto.SubjectTeacherRequestDto;
import com.deepak.school.entity.SubjectTeacher;
import com.deepak.school.mapper.SubjectTeacherMapper;
import com.deepak.school.repository.SubjectTeacherRepository;
import com.deepak.school.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectTeacherController {
    @Autowired
    SubjectTeacherMapper mapper;
    @Autowired
    SubjectTeacherService service;
    @Autowired
    SubjectTeacherRepository subjectTeacherRepository;
    @PostMapping("/subject-teachers")
    public SubjectTeacher assignSubjectTeacher(@RequestBody SubjectTeacherRequestDto requestDto){
        SubjectTeacher subjectTeacher = mapper.mapSubjectTeacherDtoToSubjectTeacher(requestDto);
        return service.createSubjectTeacher(subjectTeacher);
    }
    @GetMapping("/subject-teachers")
    public List<SubjectTeacher> getAllSubjectTeachers(){
        return subjectTeacherRepository.findAll();
    }
}
