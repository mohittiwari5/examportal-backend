package com.mohit.examportal.service.implementation;

import com.mohit.examportal.entity.exam.Category;
import com.mohit.examportal.entity.exam.Quiz;
import com.mohit.examportal.repository.CategoryRepository;
import com.mohit.examportal.repository.QuizRepository;
import com.mohit.examportal.service.CategoryService;
import com.mohit.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = new Quiz();
        quiz.setQId(quizId);
        this.quizRepository.delete(quiz);
    }
}
