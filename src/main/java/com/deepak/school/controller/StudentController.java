package com.deepak.school.controller;

import com.deepak.school.dto.student.StudentResponseDto;
import com.deepak.school.dto.teacher.TeacherRequestDto;
import com.deepak.school.errorHandling.NotFoundException;
import com.deepak.school.dto.student.StudentRequestDto;
import com.deepak.school.entity.Student;
import com.deepak.school.mapper.StudentMapper;
import com.deepak.school.repository.StudentRepository;
import com.deepak.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentMapper mapper;
    @Autowired
    StudentRepository repository;

    @Autowired
    StudentService service;

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto createStudent(@RequestBody StudentRequestDto requestDto){
        Student student = mapper.mapStudentRequestDtoToStudent(requestDto);
       return mapper.mapStudentToStudentResponseDto(service.createStudent(student));
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents(@RequestParam(required = false) Integer class_id){
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        List<Student> studentList;
        if (class_id == null){
            studentList = service.getAllStudents();
            for (Student student: studentList) {
                StudentResponseDto studentResponseDto = mapper.mapStudentToStudentResponseDto(student);
                studentResponseDtoList.add(studentResponseDto);
            }
        }else {
            studentList = service.getAllStudentsByClassId(class_id);
            for (Student student: studentList) {
                StudentResponseDto studentResponseDto = mapper.mapStudentToStudentResponseDto(student);
                studentResponseDtoList.add(studentResponseDto);
            }
        }
        return studentResponseDtoList;
    }

    @GetMapping("/students/{id}")
    public StudentResponseDto getStudent(@PathVariable int id) {
        Optional<Student> optionalTeacher = repository.findById(id);
        if (optionalTeacher.isPresent()) {
            return mapper.mapStudentToStudentResponseDto(optionalTeacher.get());
        } else throw new NotFoundException("id:" + id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id ,@RequestBody StudentRequestDto requestDto){
        Student student = mapper.mapStudentRequestDtoToStudent(requestDto);
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Deletion Successful";
    }

    @DeleteMapping("/students")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStudent(){
        service.deleteAllStudent();
        return "Deleted All Successfully";
    }


}
