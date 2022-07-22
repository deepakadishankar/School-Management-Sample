package com.deepak.school.service;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.Student;


import com.deepak.school.errorHandling.NotFoundException;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.StudentRepository;

import com.deepak.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) {
        userRepository.save(student.getUser());
        int classId = student.getClasses().getId();
        Class classes = classRepository.getById(classId);
        student.getClasses().setName(classes.getName());
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(int id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student selectedStudent = optionalStudent.get();

            selectedStudent.getUser().setUsername(student.getUser().getUsername());
            selectedStudent.getUser().setPassword(student.getUser().getPassword());
            selectedStudent.getUser().setDisplayName(student.getUser().getDisplayName());
            selectedStudent.getUser().setEmail(student.getUser().getEmail());
            selectedStudent.getUser().setDateOfBirth(student.getUser().getDateOfBirth());
            selectedStudent.getUser().setRole(student.getUser().getRole());

            Class classes = classRepository.findById(student.getClasses().getId()).get();
            selectedStudent.setClasses(classes);
            return studentRepository.save(selectedStudent);
        } else {
            throw new NotFoundException("id:" + id);
        }
    }
    public void deleteStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            userRepository.deleteById(student.get().getUser().getId());
            studentRepository.deleteById(student.get().getId());
        } else {
            throw new NotFoundException("id:" + id);
        }

    }
    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByClassId(int class_id) {
        return studentRepository.findAllWithClassId(class_id);
    }
}
