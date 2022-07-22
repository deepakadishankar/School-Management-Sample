package com.deepak.school.service;

import com.deepak.school.dto.teacher.TeacherResponseDto;
import com.deepak.school.entity.Class;
import com.deepak.school.entity.Student;
import com.deepak.school.entity.Teacher;
import com.deepak.school.errorHandling.NotFoundException;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.TeacherRepository;
import com.deepak.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        userRepository.save(teacher.getUser());
        return teacherRepository.save(teacher);
    }

    public void deleteStudent(int id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            teacherRepository.delete(optionalTeacher.get());
        } else {
            throw new NotFoundException("id:" + id);
        }
    }

    public Teacher updateTeacher(int id, Teacher teacher) {
        Optional<Teacher> optionalStudent = teacherRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Teacher selectedTeacher = optionalStudent.get();

            selectedTeacher.getUser().setUsername(teacher.getUser().getUsername());
            selectedTeacher.getUser().setPassword(teacher.getUser().getPassword());
            selectedTeacher.getUser().setDisplayName(teacher.getUser().getDisplayName());
            selectedTeacher.getUser().setEmail(teacher.getUser().getEmail());
            selectedTeacher.getUser().setDateOfBirth(teacher.getUser().getDateOfBirth());
            selectedTeacher.getUser().setRole(teacher.getUser().getRole());

            selectedTeacher.setSpecialization(teacher.getSpecialization());

            return teacherRepository.save(selectedTeacher);

        } else {
            throw new NotFoundException("id:" + id);
        }
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public List<Teacher> getAllTeachersBySpecialization(String specialization) {
        return teacherRepository.findAllBySpecialization(specialization);
    }
}
