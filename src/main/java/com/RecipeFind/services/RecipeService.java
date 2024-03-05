package com.RecipeFind.services;

import com.RecipeFind.models.Recipe;
import com.RecipeFind.models.dto.IngredientDTO;
import com.RecipeFind.models.dto.RecipeDTO;
import com.RecipeFind.models.dto.RecipeIngredientDTO;

import java.util.List;

public interface RecipeService {

    public Recipe createRecipe(RecipeDTO recipeDto);
    Recipe getRecipeById(Long id);
    List<Recipe> getAllRecipes();
    void deleteRecipeById(Long id);

}
