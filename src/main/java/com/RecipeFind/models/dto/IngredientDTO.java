package com.RecipeFind.models.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientDTO {

    private Long id;
    private String name;
    private double proteins;
    private double carbohydrates;
    private double fats;
    private double kcal;

}
