package com.deepak.school.repository;

import com.deepak.school.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Integer> {
}
