package com.exam.backend.controller;


import com.exam.backend.model.exam.Category;
import com.exam.backend.model.exam.Quiz;
import com.exam.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")

public class QuizController {

    @Autowired
    private QuizService quizService;


    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //get quizzes
    @GetMapping("/")
    public ResponseEntity<?> quizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());

    }

    //get quizz by id
    @GetMapping("/{qid}")
    public Optional<Quiz> quiz(@PathVariable("qid") Long qid){
        return this.quizService.getQuiz(qid);

    }

    //update

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }


    //delete
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid ) {
        this.quizService.deleteQuiz(qid);
    }

    // get category quiz
    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }


}
