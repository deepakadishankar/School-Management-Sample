package com.deepak.school.dto;

import lombok.Data;

import javax.persistence.OneToOne;
@Data
public class ExamRequestDto {
    int examId;
    String examName;
    int classId;
}
