package com.deepak.school.repository;

import com.deepak.school.entity.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission,Integer> {
}
