package com.deepak.school.service;

import com.deepak.school.entity.*;
import com.deepak.school.entity.Class;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.SubjectRepository;
import com.deepak.school.repository.SubjectTeacherRepository;
import com.deepak.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectTeacherService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SubjectTeacherRepository subjectTeacherRepository;

    public SubjectTeacher createSubjectTeacher(SubjectTeacher subjectTeacher){
        SubjectTeacher subjectTeacher1 = new SubjectTeacher();
        subjectTeacher1.setAcademicYear(subjectTeacher.getAcademicYear());
        Subject subject = subjectRepository.findById(subjectTeacher.getSubject().getId()).get();
        Teacher teacher = teacherRepository.findById(subjectTeacher.getTeacher().getId()).get();
        subjectTeacher1.setSubject(subject);
        subjectTeacher1.setTeacher(teacher);
        subjectTeacherRepository.save(subjectTeacher1);
        return subjectTeacher1;
    }
}
