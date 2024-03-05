package com.RecipeFind.controllers;

import com.RecipeFind.models.RecipeIngredient;
import com.RecipeFind.models.dto.RecipeIngredientDTO;
import com.RecipeFind.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class RecipeIngredientController {

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @PostMapping
    public ResponseEntity<RecipeIngredient> createRecipeIngredient(@RequestBody RecipeIngredientDTO recipeIngredientDTO) {
        RecipeIngredient recipeIngredient = recipeIngredientService.createRecipeIngredient(recipeIngredientDTO);
        return new ResponseEntity<>(recipeIngredient, HttpStatus.CREATED);
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<RecipeIngredient>> getIngredientsForRecipe(@PathVariable Long recipeId) {
        List<RecipeIngredient> ingredients = recipeIngredientService.getIngredientsForRecipe(recipeId);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @GetMapping("/ingredient/{ingredientId}")
    public ResponseEntity<List<RecipeIngredient>> getRecipesForIngredient(@PathVariable Long ingredientId) {
        List<RecipeIngredient> recipes = recipeIngredientService.getRecipesForIngredient(ingredientId);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

}
