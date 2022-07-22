package com.deepak.school.controller;

import com.deepak.school.dto.MarkRequestDto;
import com.deepak.school.entity.Mark;
import com.deepak.school.mapper.MarkMapper;
import com.deepak.school.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarkController {
    @Autowired
    MarkMapper mapper;
    @Autowired
    MarkService service;

    @PostMapping("/marks")
    public Mark createMark(@RequestBody MarkRequestDto requestDto){
        Mark mark = mapper.mapMarkRequestDtoToMark(requestDto);
        return service.createMark(mark);
    }
    @GetMapping("/marks")
    public List<Mark> getAllMarks(@RequestParam(required = false) Integer subject_id,@RequestParam(required = false) Integer exam_id){
        if (subject_id == null & exam_id == null){
            return service.getAllMarks();
        }else if (subject_id == null & exam_id != null){
                return service.getAllMarksByExamId(exam_id);
        }else {
            return service.getAllMarksBySubjectId(subject_id);
        }
    }
}
