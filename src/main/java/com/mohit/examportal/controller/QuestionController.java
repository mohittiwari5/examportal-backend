package com.mohit.examportal.controller;

import com.mohit.examportal.entity.exam.Question;
import com.mohit.examportal.entity.exam.Quiz;
import com.mohit.examportal.service.QuestionService;
import com.mohit.examportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get all question of any quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {

        Quiz quiz = this.quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);

        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);

//        Quiz quiz = new Quiz();
//        quiz.setQId(quizId);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);
    }

    //get single question
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }

    //delete question
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);

    }


}












