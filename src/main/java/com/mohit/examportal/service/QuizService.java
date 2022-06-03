package com.mohit.examportal.service;

import com.mohit.examportal.entity.exam.Category;
import com.mohit.examportal.entity.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);

    public List<Quiz> getQuizzesOfCategory(Category category);
}
