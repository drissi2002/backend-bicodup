package com.exam.backend.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private Long cid;
    private String title;
    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quizzes= new LinkedHashSet<>();

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Category(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
    public Category() {

        // TODO Auto-generated constructor stub
    }

}
