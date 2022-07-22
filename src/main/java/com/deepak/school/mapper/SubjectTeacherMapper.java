package com.deepak.school.mapper;

import com.deepak.school.dto.subjectRequestDto.SubjectRequestDto;
import com.deepak.school.dto.subjectTeacherRequestDto.SubjectTeacherRequestDto;
import com.deepak.school.entity.Subject;
import com.deepak.school.entity.SubjectTeacher;
import com.deepak.school.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class SubjectTeacherMapper {
    public SubjectTeacher mapSubjectTeacherDtoToSubjectTeacher(SubjectTeacherRequestDto requestDto){
        SubjectTeacher subjectTeacher = new SubjectTeacher();
        subjectTeacher.setAcademicYear(requestDto.getAcademicYear());
        Subject subject = new Subject();
        subject.setId(requestDto.getSubjectId());
        Teacher teacher = new Teacher();
        teacher.setId(requestDto.getTeacherId());
        subjectTeacher.setSubject(subject);
        subjectTeacher.setTeacher(teacher);
        return subjectTeacher;
    }
}
