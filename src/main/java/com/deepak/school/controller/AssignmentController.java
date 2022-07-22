package com.deepak.school.controller;

import com.deepak.school.dto.AssignmentRequestDto;
import com.deepak.school.entity.Assignment;
import com.deepak.school.mapper.AssignmentMapper;
import com.deepak.school.repository.AssignmentRepository;
import com.deepak.school.service.AssignmentService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentMapper mapper;
    @Autowired
    AssignmentService service;

    @PostMapping("/assignments")
    public Assignment createAssignment(@RequestBody AssignmentRequestDto requestDto) {
        Assignment assignment = mapper.mapAssignmentRequestDtoToAssignment(requestDto);
        return service.createAssignment(assignment);
    }
    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments(){
        return service.getAllAssignments();
    }
}
