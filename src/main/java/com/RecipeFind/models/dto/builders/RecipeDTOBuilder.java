package com.RecipeFind.models.dto.builders;

import com.RecipeFind.models.Recipe;
import com.RecipeFind.models.dto.RecipeDTO;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTOBuilder {

    private RecipeDTOBuilder() {
    }

    public static RecipeDTO toRecipeDTO(Recipe recipe) {
        return RecipeDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .prepTime(recipe.getPrepTime())
                .servings(recipe.getServings())
                .cookTime(recipe.getCookTime())
                .instructions(recipe.getInstructions())
                .category(recipe.getCategory())
                .image(recipe.getImage())
                // Alte câmpuri
                .build();
    }

    public static Recipe fromRecipeDTO(RecipeDTO recipeDTO) {
        return Recipe.builder()
                .name(recipeDTO.getName())
                .prepTime(recipeDTO.getPrepTime())
                .servings(recipeDTO.getServings())
                .cookTime(recipeDTO.getCookTime())
                .instructions(recipeDTO.getInstructions())
                .category(recipeDTO.getCategory())
                .image(recipeDTO.getImage())
                // Alte câmpuri
                .build();
    }

    public static Iterable<RecipeDTO> toRecipeDTOList(Iterable<Recipe> recipes) {
        List<RecipeDTO> recipeDTOS = new ArrayList<>();

        for (Recipe recipe : recipes) {
            recipeDTOS.add(toRecipeDTO(recipe));
        }

        return recipeDTOS;
    }

}
