package com.RecipeFind.services;

import com.RecipeFind.models.Ingredient;
import com.RecipeFind.models.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {

    Ingredient createIngredient(IngredientDTO ingredientDto);
    Ingredient getIngredientById(Long id);
    List<Ingredient> getAllIngredients();
    void deleteIngredientById(Long id);

}
