package com.exam.backend.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qId;
    private String title;
    @Column(length = 5000)
    private String description;
    private String maxMarks;
    private String numberOfQuestions;
    private boolean active=false;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();


    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Long getqId() {
        return qId;
    }
    public void setqId(Long qId) {
        this.qId = qId;
    }
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
    public String getMaxMarks() {
        return maxMarks;
    }
    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }
    public String getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public void setNumberOfQuestions(String numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Quiz(Long qId, String title, String description, String maxMarks, String numberOfQuestions, boolean active) {
        super();
        this.qId = qId;
        this.title = title;
        this.description = description;
        this.maxMarks = maxMarks;
        this.numberOfQuestions = numberOfQuestions;
        this.active = active;
    }


    public Quiz() {

        // TODO Auto-generated constructor stub
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions(){
        return questions ;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
