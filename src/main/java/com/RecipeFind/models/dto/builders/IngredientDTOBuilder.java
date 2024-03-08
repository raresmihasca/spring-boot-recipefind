package com.RecipeFind.models.dto.builders;

import com.RecipeFind.models.Ingredient;
import com.RecipeFind.models.dto.IngredientDTO;

import java.util.ArrayList;
import java.util.List;

public class IngredientDTOBuilder {

    private IngredientDTOBuilder() {
    }

    public static IngredientDTO toIngredientDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .proteins(ingredient.getProteins())
                .fats(ingredient.getFats())
                .carbohydrates(ingredient.getCarbohydrates())
                .kcal(ingredient.getKcal())
                // Alte câmpuri
                .build();
    }

    public static Ingredient fromIngredientDTO(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .name(ingredientDTO.getName())
                .proteins(ingredientDTO.getProteins())
                .fats(ingredientDTO.getFats())
                .carbohydrates(ingredientDTO.getCarbohydrates())
                .kcal(ingredientDTO.getKcal())
                // Alte câmpuri
                .build();
    }

    public static Iterable<IngredientDTO> toIngredientDTOList(Iterable<Ingredient> ingredients) {
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            ingredientDTOS.add(toIngredientDTO(ingredient));
        }

        return ingredientDTOS;
    }

}
