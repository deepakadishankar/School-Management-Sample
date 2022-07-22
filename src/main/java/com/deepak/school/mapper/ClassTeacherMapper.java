package com.deepak.school.mapper;

import com.deepak.school.dto.classTeacher.ClassTeacherRequestDto;
import com.deepak.school.entity.Class;
import com.deepak.school.entity.ClassTeacher;
import com.deepak.school.entity.Teacher;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassTeacherMapper {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public ClassTeacher mapClassTeacherRequestDtoToClassTeacher(ClassTeacherRequestDto requestDto){
        ClassTeacher classTeacher = new ClassTeacher();

        Class aClass = new Class();
        aClass.setId(requestDto.getClassId());
        classTeacher.setAClass(aClass);

        Teacher teacher = new Teacher();
        teacher.setId(requestDto.getTeacherId());
        classTeacher.setTeacher(teacher);

        return classTeacher;
    }
}
