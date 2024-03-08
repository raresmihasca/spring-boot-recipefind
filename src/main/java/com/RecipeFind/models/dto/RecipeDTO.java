package com.RecipeFind.models.dto;

import com.RecipeFind.models.enums.RecipeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDTO {

    private Long id;
    private String name;
    private int prepTime;
    private int servings;
    private int cookTime;
    private String instructions;
    private List<RecipeCategory> category;

}
