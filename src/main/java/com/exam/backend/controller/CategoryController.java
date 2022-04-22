package com.exam.backend.controller;

import com.exam.backend.model.exam.Category;
import com.exam.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryservice;

    //add category
    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        return ResponseEntity.ok(this.categoryservice.addCategory(category));
    }

    //get category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) {
        return this.categoryservice.getCategory(categoryId);

    }

    //get categories

    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryservice.getCategories());
    }

    //update

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryservice.updateCategory(category);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId ) {
        this.categoryservice.deleteCategory(categoryId);
    }

}
