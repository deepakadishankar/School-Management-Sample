package com.deepak.school.controller;

import com.deepak.school.dto.AssignmentSubmissionRequestDto;
import com.deepak.school.entity.AssignmentSubmission;
import com.deepak.school.mapper.AssignmentSubmissionMapper;
import com.deepak.school.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentSubmissionController {
    @Autowired
    AssignmentSubmissionMapper mapper;
    @Autowired
    AssignmentSubmissionService service;

    @PostMapping("/assignment-submissions")
    public AssignmentSubmission createAssignmentSubmission(@RequestBody AssignmentSubmissionRequestDto requestDto) {
        AssignmentSubmission assignmentSubmission = mapper.mapAssignmentSubmissionRequestDtoToAssignmentSubmission(requestDto);
        return service.createAssignmentSubmission(assignmentSubmission);
    }
}
