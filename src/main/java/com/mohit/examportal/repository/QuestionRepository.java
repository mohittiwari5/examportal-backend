package com.mohit.examportal.repository;

import com.mohit.examportal.entity.exam.Category;
import com.mohit.examportal.entity.exam.Question;
import com.mohit.examportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    public Set<Question> findByQuiz(Quiz quiz);
}
