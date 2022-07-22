package com.deepak.school.mapper;

import com.deepak.school.dto.ExamRequestDto;
import com.deepak.school.entity.Class;
import com.deepak.school.entity.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {
    public Exam mapExamRequestDtoToExam(ExamRequestDto requestDto){
        Exam exam = new Exam();
        exam.setId(requestDto.getExamId());
        exam.setName(requestDto.getExamName());
        Class aClass = new Class();
        aClass.setId(requestDto.getClassId());
        exam.setAClass(aClass);
        return exam;
    }
}
