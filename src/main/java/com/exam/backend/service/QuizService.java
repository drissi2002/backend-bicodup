package com.exam.backend.service;

import com.exam.backend.model.exam.Category;
import com.exam.backend.model.exam.Quiz;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//@Service
public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Optional<Quiz> getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);

    public List<Quiz> getQuizzesOfCategory(Category cid);
}
