package com.example.recipeapp.bootstrap;

import com.example.recipeapp.domain.*;
import com.example.recipeapp.repository.CategoryRepository;
import com.example.recipeapp.repository.RecipeRepository;
import com.example.recipeapp.repository.UnitOfMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class RecipeBootstraps implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMesureRepository unitOfMeasureRepository;

    public RecipeBootstraps(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMesureRepository unitOfMesureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMesureRepository;
    }



    public List<Recipe> getRecipes()
    {
        List<Recipe> recipeList = new ArrayList<>();

        Optional<UnitOfMesure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Hell Yeah");

        if (!unitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Hell Yeah amount not found");
        }

        UnitOfMesure HellYeah = unitOfMeasureOptional.get();

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Chinczyk");

        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Chinczyk category is not found");
        }


        Recipe TestRecipe = new Recipe();

        TestRecipe.setDescription("Example test Recipe");
        TestRecipe.setPreparationTime(10);
        TestRecipe.setCookTime(5);
        TestRecipe.setUrl("http://......");
        TestRecipe.setDifficulty(Difficulty.MID);
       // TestRecipe.getIngredientSet().add(new Ingredient());

        recipeList.add(TestRecipe);

        Notes note = new Notes();
        note.setRecipNotes(
                "One of my favorite Dish"
        );

        TestRecipe.setNotes(note);

        TestRecipe.getIngredientSet().add(new Ingredient("Eggs", new BigDecimal(10), HellYeah,TestRecipe));

        Recipe golonka = new Recipe();
        golonka.setDescription("Golonka w sosie wlasnym");

        recipeList.add(golonka);

        return recipeList;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }
}
