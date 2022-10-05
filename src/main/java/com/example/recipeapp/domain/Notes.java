package com.example.recipeapp.domain;


import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    private Recipe recipe;
    @Lob
    private String recipNotes;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipNotes() {
        return recipNotes;
    }

    public void setRecipNotes(String recipNotes) {
        this.recipNotes = recipNotes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
