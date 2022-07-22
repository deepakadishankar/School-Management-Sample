package com.deepak.school.service;

import com.deepak.school.entity.Exam;
import com.deepak.school.entity.Mark;
import com.deepak.school.entity.Student;
import com.deepak.school.entity.Subject;
import com.deepak.school.repository.ExamRepository;
import com.deepak.school.repository.MarkRepository;
import com.deepak.school.repository.StudentRepository;
import com.deepak.school.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    MarkRepository markRepository;

    public Mark createMark(Mark mark) {
        Student student = studentRepository.findById(mark.getStudent().getId()).get();
        Exam exam = examRepository.findById(mark.getExam().getId()).get();
        Subject subject = subjectRepository.findById(mark.getSubject().getId()).get();
        mark.setStudent(student);
        mark.setExam(exam);
        mark.setSubject(subject);
        return markRepository.save(mark);
    }

    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    public List<Mark> getAllMarksByExamId(Integer exam_id) {
        return markRepository.findByExamId(exam_id);
    }

    public List<Mark> getAllMarksBySubjectId(Integer subject_id) {
        return markRepository.findBySubjectId(subject_id);
    }
}
