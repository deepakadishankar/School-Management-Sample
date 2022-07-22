package com.deepak.school.dto.subjectTeacherRequestDto;

import lombok.Data;

import java.time.Year;

@Data
public class SubjectTeacherRequestDto {
    Year academicYear;
    int teacherId;
    int subjectId;
}
