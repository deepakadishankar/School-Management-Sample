package com.deepak.school.service;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.ClassTeacher;
import com.deepak.school.entity.Teacher;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.ClassTeacherRepository;
import com.deepak.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassTeacherService {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ClassTeacherRepository classTeacherRepository;

    public ClassTeacher createClassTeacher(ClassTeacher classTeacher){
        ClassTeacher classTeacher1 = new ClassTeacher();
        Class aClass = classRepository.findById(classTeacher.getAClass().getId()).get();
        Teacher teacher = teacherRepository.findById(classTeacher.getTeacher().getId()).get();
        classTeacher1.setAClass(aClass);
        classTeacher1.setTeacher(teacher);
        classTeacherRepository.save(classTeacher1);
        return classTeacher1;
    }
}
