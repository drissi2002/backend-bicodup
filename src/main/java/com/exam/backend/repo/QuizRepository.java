package com.exam.backend.repo;

import com.exam.backend.model.exam.Category;
import com.exam.backend.model.exam.Quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	public List<Quiz> findByCategory(Category category);
	public List<Quiz> findByActive(boolean v);
	public List<Quiz> findByCategoryAndActive(Category category,boolean b);

    public List<Quiz> findBycategory(Category category);
}