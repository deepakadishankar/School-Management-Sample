package com.deepak.school.mapper;

import com.deepak.school.dto.subjectRequestDto.SubjectRequestDto;
import com.deepak.school.entity.Class;
import com.deepak.school.entity.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
@Component
public class SubjectMapper {

    public Subject mapSubjectRequestDtoToSubject(@RequestBody SubjectRequestDto requestDto){
        Subject subject = new Subject();
        subject.setId(requestDto.getId());
        subject.setName(requestDto.getName());
        Class classes = new Class();
        classes.setId(requestDto.getClassId());
        subject.setClasses(classes);
        return subject;
    }
}
