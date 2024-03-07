package com.RecipeFind.models.dto.request;

import com.RecipeFind.models.dto.RecipeDTO;
import com.RecipeFind.models.dto.RecipeIngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeRequest {

    private RecipeDTO recipe;
    private List<RecipeIngredientDTO> ingredients;

}
