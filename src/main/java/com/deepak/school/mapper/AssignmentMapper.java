package com.deepak.school.mapper;

import com.deepak.school.dto.AssignmentRequestDto;
import com.deepak.school.entity.Assignment;
import com.deepak.school.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {

    public Assignment mapAssignmentRequestDtoToAssignment(AssignmentRequestDto requestDto){
        Subject subject = new Subject();
        subject.setId(requestDto.getSubjectId());
        Assignment assignment = new Assignment();
//        assignment.setId(assignment.getId());
        assignment.setTitle(requestDto.getTitle());
        assignment.setSubject(subject);
        return assignment;
    }
}
