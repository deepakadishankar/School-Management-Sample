package com.deepak.school.dto;

import com.deepak.school.entity.Assignment;
import com.deepak.school.entity.Subject;
import lombok.Data;

@Data
public class AssignmentRequestDto {
    String title;
    int subjectId;
}
