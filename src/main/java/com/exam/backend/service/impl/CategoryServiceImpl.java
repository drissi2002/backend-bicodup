package com.exam.backend.service.impl;

import com.exam.backend.model.exam.Category;
import com.exam.backend.repo.CategoryRepository;
import com.exam.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryrepository;

    @Override
    public Category addCategory(Category category) {
        // TODO Auto-generated method stub
        return this.categoryrepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        // TODO Auto-generated method stub
        return this.categoryrepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        // TODO Auto-generated method stub
        return new LinkedHashSet<Category>(this.categoryrepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        // TODO Auto-generated method stub
        return this.categoryrepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        // TODO Auto-generated method stub
        this.categoryrepository.delete(this.categoryrepository.findById(categoryId).get());
    }

}
