package com.deepak.school.mapper;

import com.deepak.school.dto.student.StudentRequestDto;
import com.deepak.school.dto.student.StudentResponseDto;
import com.deepak.school.entity.Class;
import com.deepak.school.entity.Student;
import com.deepak.school.entity.User;
import com.deepak.school.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    @Autowired
    ClassRepository classRepository;

    public Student mapStudentRequestDtoToStudent(StudentRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setPassword(requestDto.getPassword());
        user.setDisplayName(requestDto.getDisplayName());
        user.setEmail(requestDto.getEmail());
        user.setDateOfBirth(requestDto.getDateOfBirth());
        user.setRole("STUDENT");
        Student student = new Student();
        student.setUser(user);
        Class classes = new Class();
        classes.setId(requestDto.getClassId());
          student.setClasses(classes);
        return student;
    }
    public StudentResponseDto mapStudentToStudentResponseDto(Student student){
        User user = student.getUser();
        Class classes = student.getClasses();
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setStudentId(student.getId());
        studentResponseDto.setUsername(user.getUsername());
        studentResponseDto.setDisplayName(user.getDisplayName());
        studentResponseDto.setEmail(user.getEmail());
        studentResponseDto.setDateOfBirth(user.getDateOfBirth());
        studentResponseDto.setClassName(classes.getName());
        return studentResponseDto;
    }

}
