package com.mohit.examportal.service.implementation;

import com.mohit.examportal.entity.exam.Category;
import com.mohit.examportal.entity.exam.Question;
import com.mohit.examportal.entity.exam.Quiz;
import com.mohit.examportal.repository.CategoryRepository;
import com.mohit.examportal.repository.QuestionRepository;
import com.mohit.examportal.service.CategoryService;
import com.mohit.examportal.service.QuestionService;
import com.mohit.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = new Question();
        question.setQuesId(questionId);
        this.questionRepository.delete(question);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }
}
