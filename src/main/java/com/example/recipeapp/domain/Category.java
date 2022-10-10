package com.example.recipeapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipieSet;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
