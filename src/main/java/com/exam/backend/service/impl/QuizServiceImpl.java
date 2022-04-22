package com.exam.backend.service.impl;

import com.exam.backend.model.exam.Category;
import com.exam.backend.model.exam.Quiz;
import com.exam.backend.repo.QuizRepository;
import com.exam.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
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
    public Optional<Quiz> getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId);
    }

    @Override
    public void deleteQuiz(Long quizId) {
       Quiz quiz = new Quiz();
       quiz.setqId(quizId);
       this.quizRepository.delete(quiz);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }
}
