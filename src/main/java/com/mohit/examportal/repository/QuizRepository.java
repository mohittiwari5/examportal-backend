package com.mohit.examportal.repository;

import com.mohit.examportal.entity.exam.Category;
import com.mohit.examportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory(Category category);
}
