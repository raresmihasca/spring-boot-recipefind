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

}
