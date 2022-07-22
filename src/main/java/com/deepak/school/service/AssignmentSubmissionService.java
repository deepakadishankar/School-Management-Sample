package com.deepak.school.service;

import com.deepak.school.entity.Assignment;
import com.deepak.school.entity.AssignmentSubmission;
import com.deepak.school.entity.Student;
import com.deepak.school.repository.AssignmentRepository;
import com.deepak.school.repository.AssignmentSubmissionRepository;
import com.deepak.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentSubmissionService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AssignmentRepository assignmentRepository;
    @Autowired
    AssignmentSubmissionRepository assignmentSubmissionRepository;
    public AssignmentSubmission createAssignmentSubmission(AssignmentSubmission assignmentSubmission){
        Student student = studentRepository.findById(assignmentSubmission.getStudent().getId()).get();
        Assignment assignment = assignmentRepository.findById(assignmentSubmission.getAssignment().getId()).get();
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setAssignment(assignment);
        assignmentSubmission.setFileId(assignmentSubmission.getFileId());
        return assignmentSubmissionRepository.save(assignmentSubmission);
    }
}
