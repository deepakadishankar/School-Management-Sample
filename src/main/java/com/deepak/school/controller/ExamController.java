package com.deepak.school.controller;

import com.deepak.school.dto.ExamRequestDto;
import com.deepak.school.entity.Exam;
import com.deepak.school.mapper.ExamMapper;
import com.deepak.school.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    ExamMapper mapper;

    @Autowired
    ExamService service;

    @PostMapping("/exams")
    public Exam createExam(@RequestBody ExamRequestDto requestDto){
        Exam exam = mapper.mapExamRequestDtoToExam(requestDto);
        return service.createExam(exam);
    }
    @GetMapping("/exams")
    public List<Exam> getAllExams(){
        return service.getAllExams();
    }

}
