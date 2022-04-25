package com.exam.backend.service;

import com.exam.backend.model.exam.Question;
import com.exam.backend.model.exam.Quiz;

import java.util.Optional;
import java.util.Set;

//@Service
public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Optional<Question> getQuestion(Long questionId);
    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long questionId);
    public Question get(Long questionsId);

    //Quiz getQuiz(Long qid);
}
