package com.example.recipeapp.RecipeService;

import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipies() {
        Set<Recipe> recipes = new HashSet<>();
/*
        Iterator<Recipe> iterator = recipeRepository.findAll().iterator();

        while(iterator.hasNext()){
            repcipies.add(iterator.next());
     */

        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);


        return recipes;
    }
}
