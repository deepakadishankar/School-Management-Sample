package com.deepak.school.service;

import com.deepak.school.entity.Assignment;
import com.deepak.school.entity.Subject;
import com.deepak.school.repository.AssignmentRepository;
import com.deepak.school.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    AssignmentRepository assignmentRepository;
    public Assignment createAssignment(Assignment assignment){
        Subject subject = subjectRepository.findById(assignment.getSubject().getId()).get();
        assignment.setSubject(subject);
        return assignmentRepository.save(assignment);
    }
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}
