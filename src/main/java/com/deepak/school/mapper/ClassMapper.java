package com.deepak.school.mapper;

import com.deepak.school.dto.classes.ClassRequestDto;
import com.deepak.school.entity.Class;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {
    public Class mapClassRequestDtoToClass(ClassRequestDto requestDto){
        Class classes = new Class();
        classes.setId(requestDto.getId());
        classes.setName(requestDto.getName());
        return classes;
    }
}
