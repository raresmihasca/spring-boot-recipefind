package com.RecipeFind.services.implement;

import com.RecipeFind.models.RecipeIngredient;
import com.RecipeFind.models.dto.RecipeIngredientDTO;
import com.RecipeFind.models.dto.builders.RecipeIngredientDTOBuilder;
import com.RecipeFind.repositories.RecipeIngredientRepository;
import com.RecipeFind.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Override
    public RecipeIngredient createRecipeIngredient(RecipeIngredientDTO recipeIngredientDto) {
        RecipeIngredient recipeIngredient = RecipeIngredientDTOBuilder.fromRecipeIngredientDTO(recipeIngredientDto);
        return recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public List<RecipeIngredient> getIngredientsForRecipe(Long recipeId) {
        return recipeIngredientRepository.findByRecipeId(recipeId);
    }

    @Override
    public List<RecipeIngredient> getRecipesForIngredient(Long ingredientId) {
        return recipeIngredientRepository.findByIngredientId(ingredientId);
    }
}
