package com.deepak.school.repository;

import com.deepak.school.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark,Integer> {
    List<Mark> findBySubjectId(Integer subject_id);

    List<Mark> findByExamId(Integer exam_id);
}
