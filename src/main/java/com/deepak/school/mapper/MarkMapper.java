package com.deepak.school.mapper;

import com.deepak.school.dto.MarkRequestDto;
import com.deepak.school.entity.Exam;
import com.deepak.school.entity.Mark;
import com.deepak.school.entity.Student;
import com.deepak.school.entity.Subject;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Component;

@Component
public class MarkMapper {
    public Mark mapMarkRequestDtoToMark(MarkRequestDto requestDto){
        Student student = new Student();
        student.setId(requestDto.getStudentId());
        Exam exam = new Exam();
        exam.setId(requestDto.getExamId());
        Subject subject = new Subject();
        subject.setId(requestDto.getSubjectId());
        Mark mark = new Mark();
        mark.setStudent(student);
        mark.setExam(exam);
        mark.setSubject(subject);
        mark.setMark(requestDto.getMark());
        return mark;
    }
}
