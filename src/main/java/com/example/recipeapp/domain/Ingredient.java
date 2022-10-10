package com.example.recipeapp.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMesure unitOfMesure;

    @ManyToOne
    private Recipe recipe;

    public Ingredient(String description, BigDecimal amount, UnitOfMesure unitOfMesure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMesure = unitOfMesure;
    }
    public Ingredient(String description, BigDecimal amount, UnitOfMesure unitOfMesure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOfMesure = unitOfMesure;
        this.recipe = recipe;
    }

    public Ingredient() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnitOfMesure getUnitOfMesure() {
        return unitOfMesure;
    }

    public void setUnitOfMesure(UnitOfMesure unitOfMesure) {
        this.unitOfMesure = unitOfMesure;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
