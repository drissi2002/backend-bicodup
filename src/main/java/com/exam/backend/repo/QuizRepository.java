package com.exam.backend.repo;

import com.exam.backend.model.exam.Category;
import com.exam.backend.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    public List<Quiz> findBycategory(Category category);
}