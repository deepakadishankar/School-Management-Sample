package com.deepak.school.controller;

import com.deepak.school.dto.subjectRequestDto.SubjectRequestDto;
import com.deepak.school.entity.Subject;
import com.deepak.school.errorHandling.NotFoundException;
import com.deepak.school.mapper.SubjectMapper;
import com.deepak.school.repository.SubjectRepository;
import com.deepak.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    SubjectMapper mapper;
    @Autowired
    SubjectService service;
    @Autowired
    SubjectRepository repository;

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody SubjectRequestDto requestDto){
        Subject subject = mapper.mapSubjectRequestDtoToSubject(requestDto);
        return service.createSubject(subject);
    }
    @GetMapping("/subjects/{id}")
    public Subject getSubject(@PathVariable int id){
        return service.getSubject(id);
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjectsByClassId(@RequestParam(required = false) Integer class_id){

        if (class_id == null){
            return service.getAllSubjects();
        }else {
            return service.getAllSubjectsByClassId(class_id);
        }
    }
    @PutMapping("/subjects/{id}")
    public Subject updateSubject(@PathVariable int id,@RequestBody SubjectRequestDto requestDto){
        Subject subject = mapper.mapSubjectRequestDtoToSubject(requestDto);
       return service.updateSubject(id,subject);
    }
}
