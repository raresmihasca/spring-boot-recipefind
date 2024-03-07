package com.RecipeFind.services.implement;

import com.RecipeFind.models.Ingredient;
import com.RecipeFind.models.Recipe;
import com.RecipeFind.models.RecipeIngredient;
import com.RecipeFind.models.dto.IngredientDTO;
import com.RecipeFind.models.dto.RecipeDTO;
import com.RecipeFind.models.dto.RecipeIngredientDTO;
import com.RecipeFind.models.dto.builders.RecipeDTOBuilder;
import com.RecipeFind.models.dto.builders.RecipeIngredientDTOBuilder;
import com.RecipeFind.repositories.IngredientRepository;
import com.RecipeFind.repositories.RecipeIngredientRepository;
import com.RecipeFind.repositories.RecipeRepository;
import com.RecipeFind.services.IngredientService;
import com.RecipeFind.services.RecipeIngredientService;
import com.RecipeFind.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void createRecipe(RecipeDTO recipeDTO, List<RecipeIngredientDTO> ingredients) {
        // Creează și salvează rețeta în baza de date
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        // Adaugă alte detalii despre rețetă (dacă sunt disponibile) folosind setter-ii

        recipe = recipeRepository.save(recipe);

        // Iterează prin lista de ingrediente și adaugă fiecare ingredient în baza de date
        for (RecipeIngredientDTO ingredientDTO : ingredients) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDTO.getIngredientName());
            // Adaugă alte detalii despre ingredient (dacă sunt disponibile) folosind setter-ii
            ingredient = ingredientRepository.save(ingredient);

            // Creează o legătură între rețetă și ingredient și salvează-o în baza de date
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipe(recipe);
            recipeIngredient.setIngredient(ingredient);
            recipeIngredient.setQuantity(ingredientDTO.getQuantity());
            recipeIngredient.setUnitOfMeasure(ingredientDTO.getUnitOfMeasure());

            recipeIngredientRepository.save(recipeIngredient);
        }
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findRecipeById(id);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteRecipeById(id);
    }
}
