package com.RecipeFind.services;

import com.RecipeFind.models.RecipeIngredient;
import com.RecipeFind.models.dto.RecipeIngredientDTO;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredient createRecipeIngredient(RecipeIngredientDTO recipeIngredientDTO);
    List<RecipeIngredient> getIngredientsForRecipe(Long recipeId);
    List<RecipeIngredient> getRecipesForIngredient(Long ingredientId);

}
