package com.RecipeFind.controllers;

import com.RecipeFind.models.Recipe;
import com.RecipeFind.models.RecipeIngredient;
import com.RecipeFind.models.dto.RecipeDTO;
import com.RecipeFind.models.dto.RecipeIngredientDTO;
import com.RecipeFind.models.dto.builders.RecipeIngredientDTOBuilder;
import com.RecipeFind.models.dto.request.RecipeRequest;
import com.RecipeFind.services.RecipeIngredientService;
import com.RecipeFind.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<String> createRecipe(@RequestPart("image") MultipartFile imageFile,
                                               @RequestPart("recipeRequest") RecipeRequest recipeRequest) {
        try {
            // Extrage rețeta și ingredientele din RecipeRequest
            RecipeDTO recipeDTO = recipeRequest.getRecipe();
            List<RecipeIngredientDTO> ingredients = recipeRequest.getIngredients();

            // Convertește fișierul de imagine într-un array de bytes
            byte[] imageBytes = imageFile.getBytes();

            // Adaugă rețeta și ingredientele în baza de date folosind serviciul adecvat
            recipeService.createRecipe(recipeDTO, ingredients, imageBytes);

            return new ResponseEntity<>("Rețetă creată cu succes!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Eroare la crearea rețetei: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

}
