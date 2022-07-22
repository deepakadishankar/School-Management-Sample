package com.deepak.school.controller;

import com.deepak.school.dto.teacher.TeacherRequestDto;
import com.deepak.school.dto.teacher.TeacherResponseDto;
import com.deepak.school.entity.Teacher;
import com.deepak.school.errorHandling.NotFoundException;
import com.deepak.school.mapper.TeacherMapper;
import com.deepak.school.repository.TeacherRepository;
import com.deepak.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository repository;
    @Autowired
    TeacherMapper mapper;
    @Autowired
    TeacherService service;

    @PostMapping("/teachers")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponseDto createTeacher(@RequestBody TeacherRequestDto requestDto) {
        Teacher teacher = mapper.mapTeacherRequestDtoToTeacher(requestDto);
        return mapper.mapTeacherToTeacherResponseDto(service.createTeacher(teacher));
    }
    @GetMapping("/teachers")
    public List<TeacherResponseDto> getAllTeachers(@RequestParam(required = false)String specialization){
        List<TeacherResponseDto> teacherRequestDtoList = new ArrayList<>();
        List<Teacher > teacherList;
        if (specialization == null){
           teacherList =  service.getAllTeachers();
            for (Teacher teacher: teacherList) {
                TeacherResponseDto teacherResponseDto = mapper.mapTeacherToTeacherResponseDto(teacher);
                teacherRequestDtoList.add(teacherResponseDto);
            }
            return teacherRequestDtoList;
        }else {
            teacherList =  service.getAllTeachersBySpecialization(specialization);
            for (Teacher teacher: teacherList) {
                TeacherResponseDto teacherResponseDto = mapper.mapTeacherToTeacherResponseDto(teacher);
                teacherRequestDtoList.add(teacherResponseDto);
            }
            return teacherRequestDtoList;
        }
    }
    @GetMapping("/teachers/{id}")
    public TeacherResponseDto getTeacherById(@PathVariable int id){
        Optional<Teacher> optionalTeacher = repository.findById(id);
        if (optionalTeacher.isPresent()) {
            return mapper.mapTeacherToTeacherResponseDto(optionalTeacher.get());
        } else throw new NotFoundException("id:" + id);
    }
    @PutMapping("/teachers/{id}")
    public Teacher updateTeacher(@PathVariable int id,@RequestBody TeacherRequestDto requestDto){
        Teacher teacher= mapper.mapTeacherRequestDtoToTeacher(requestDto);
        return service.updateTeacher(id,teacher);
    }
    @DeleteMapping("/teachers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Deletion Successful";
    }
    @DeleteMapping("/teachers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAllTeachers(){
        repository.deleteAll();
        return "Deleted Successfully";
    }

}
