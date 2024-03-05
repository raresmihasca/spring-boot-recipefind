package com.RecipeFind.services.implement;

import com.RecipeFind.models.Ingredient;
import com.RecipeFind.models.dto.IngredientDTO;
import com.RecipeFind.models.dto.builders.IngredientDTOBuilder;
import com.RecipeFind.repositories.IngredientRepository;
import com.RecipeFind.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient createIngredient(IngredientDTO ingredientDto) {
        Ingredient ingredient = IngredientDTOBuilder.fromIngredientDTO(ingredientDto);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findIngredientById(id);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteIngredientById(id);
    }
}
