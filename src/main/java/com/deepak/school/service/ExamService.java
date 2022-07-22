package com.deepak.school.service;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.Exam;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;
    @Autowired
    ClassRepository classRepository;

    public Exam createExam(Exam exam){
        Class aClass = classRepository.findById(exam.getAClass().getId()).get();
        exam.setAClass(aClass);
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }
}
