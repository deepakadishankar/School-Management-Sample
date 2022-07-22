package com.deepak.school.mapper;

import com.deepak.school.dto.AssignmentSubmissionRequestDto;
import com.deepak.school.entity.Assignment;
import com.deepak.school.entity.AssignmentSubmission;
import com.deepak.school.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class AssignmentSubmissionMapper {

    public AssignmentSubmission mapAssignmentSubmissionRequestDtoToAssignmentSubmission(AssignmentSubmissionRequestDto requestDto){
        Student student = new Student();
        student.setId(requestDto.getAssignmentId());
        Assignment assignment = new Assignment();
        assignment.setId(requestDto.getAssignmentId());
        AssignmentSubmission assignmentSubmission = new AssignmentSubmission();
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setAssignment(assignment);
        assignmentSubmission.setFileId(requestDto.getFilePath());
        return assignmentSubmission;
    }
}
