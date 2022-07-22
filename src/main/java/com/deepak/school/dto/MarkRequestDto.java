package com.deepak.school.dto;

import lombok.Data;

@Data
public class MarkRequestDto {
        int studentId;
        int examId;
        int subjectId;
        int mark;
}
