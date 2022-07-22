package com.deepak.school.dto;

import lombok.Data;

@Data
public class AssignmentSubmissionRequestDto {
    int studentId;
    int assignmentId;
    String filePath;
}
