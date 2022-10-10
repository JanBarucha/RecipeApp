package com.example.recipeapp.RecipeService;

import com.example.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipies();
}
