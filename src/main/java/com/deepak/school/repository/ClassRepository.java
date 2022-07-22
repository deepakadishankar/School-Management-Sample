package com.deepak.school.repository;

import com.deepak.school.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClassRepository extends JpaRepository<Class,Integer> {
}
