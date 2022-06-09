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

    //get only given number of question of any quiz
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


    //get all questions available of quiz
    @GetMapping("/quiz/all/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("quizId") Long quizId) {

        Quiz quiz = this.quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);

        Collections.shuffle(list);
        return ResponseEntity.ok(list);
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


    //evaluate quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
        System.out.println(questions);
        Double marksGot = 0.0;
        Integer correctAnswers = 0;
        Integer attempted = 0;
        for(Question q: questions) {
            Question question = this.questionService.getQuestion(q.getQuesId());

            if(q.getGivenAnswer() != null || question.getGivenAnswer()!=null){
                if(question.getAnswer().trim().equals(q.getGivenAnswer().trim())){
                    //correct
                    correctAnswers++;
                    double marksSingle =Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
                    marksGot += marksSingle;
                }

                if(q.getGivenAnswer()  != null || !(q.getGivenAnswer().equals(""))){
                    attempted++;
                }
            }
        };

        Map<Object, Object> map = new HashMap<>();
        map.put("marksGot",marksGot);
        map.put("correctAnswers",correctAnswers);
        map.put("attempted",attempted);

        return ResponseEntity.ok(map);
    }


}












