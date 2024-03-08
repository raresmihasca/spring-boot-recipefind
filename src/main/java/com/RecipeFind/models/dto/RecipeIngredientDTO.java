package com.RecipeFind.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeIngredientDTO {

    private Long id;
    private RecipeDTO recipe;
    private IngredientDTO ingredient;
    private double quantity;
    private String unitOfMeasure;

    // Getter pentru a obține numele ingredientului
    public String getIngredientName() {
        return ingredient.getName();
    }

    public double getProteins() {
        return ingredient.getProteins();
    }

    public double getFats() {
        return ingredient.getFats();
    }

    public double getCarbohydrates() {
        return ingredient.getCarbohydrates();
    }

    public double getKcal() {
        return ingredient.getKcal();
    }

}
