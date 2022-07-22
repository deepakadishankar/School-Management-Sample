package com.deepak.school.dto.subjectRequestDto;

import lombok.Data;

import javax.persistence.Id;
@Data
public class SubjectRequestDto {
    int id;
    String name;
    int classId;
    String className;
}
