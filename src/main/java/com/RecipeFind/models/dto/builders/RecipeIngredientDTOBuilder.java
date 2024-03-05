package com.RecipeFind.models.dto.builders;

import com.RecipeFind.models.RecipeIngredient;
import com.RecipeFind.models.dto.RecipeIngredientDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientDTOBuilder {

    private RecipeIngredientDTOBuilder() {
    }

    public static RecipeIngredientDTO toRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        return RecipeIngredientDTO.builder()
                .id(recipeIngredient.getId())
                .recipe(RecipeDTOBuilder.toRecipeDTO(recipeIngredient.getRecipe()))
                .ingredient(IngredientDTOBuilder.toIngredientDTO(recipeIngredient.getIngredient()))
                .quantity(recipeIngredient.getQuantity())
                .unitOfMeasure(recipeIngredient.getUnitOfMeasure())
                // Alte câmpuri
                .build();
    }

    public static RecipeIngredient fromRecipeIngredientDTO(RecipeIngredientDTO recipeIngredientDTO) {
        return RecipeIngredient.builder()
                .recipe(RecipeDTOBuilder.fromRecipeDTO(recipeIngredientDTO.getRecipe()))
                .ingredient(IngredientDTOBuilder.fromIngredientDTO(recipeIngredientDTO.getIngredient()))
                .quantity(recipeIngredientDTO.getQuantity())
                .unitOfMeasure(recipeIngredientDTO.getUnitOfMeasure())
                // Alte câmpuri
                .build();
    }

    public static Iterable<RecipeIngredientDTO> toRecipeIngredientDTOList(Iterable<RecipeIngredient> recipeIngredients) {
        List<RecipeIngredientDTO> recipeIngredientDTOS = new ArrayList<>();

        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            recipeIngredientDTOS.add(toRecipeIngredientDTO(recipeIngredient));
        }

        return recipeIngredientDTOS;
    }

}
