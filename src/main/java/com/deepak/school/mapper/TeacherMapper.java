package com.deepak.school.mapper;

import com.deepak.school.dto.teacher.TeacherRequestDto;
import com.deepak.school.dto.teacher.TeacherResponseDto;
import com.deepak.school.entity.*;
import com.deepak.school.entity.Class;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
@Component
public class TeacherMapper {
    public Teacher mapTeacherRequestDtoToTeacher(TeacherRequestDto requestDto){
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setPassword(requestDto.getPassword());
        user.setDisplayName(requestDto.getDisplayName());
        user.setEmail(requestDto.getEmail());
        user.setDateOfBirth(requestDto.getDateOfBirth());
        user.setRole("TEACHER");
        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacher.setSpecialization(requestDto.getSpecialization());
        return teacher;
    }
    public TeacherResponseDto mapTeacherToTeacherResponseDto(Teacher teacher){
        User user = teacher.getUser();
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
        teacherResponseDto.setTeacherID(teacher.getId());
        teacherResponseDto.setUsername(user.getUsername());
        teacherResponseDto.setDisplayName(user.getDisplayName());
        teacherResponseDto.setEmail(user.getEmail());
        teacherResponseDto.setDateOfBirth(user.getDateOfBirth());
        teacherResponseDto.setSpecialization(teacher.getSpecialization());
        return teacherResponseDto;
    }
}
