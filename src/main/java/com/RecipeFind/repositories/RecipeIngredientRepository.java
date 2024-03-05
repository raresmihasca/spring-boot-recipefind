package com.RecipeFind.repositories;

import com.RecipeFind.models.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    // Salvează o asociere între rețetă și ingredient în baza de date
    RecipeIngredient save(RecipeIngredient recipeIngredient);

    // Găsește toate asociările de ingrediente pentru o anumită rețetă, utilizând id-ul rețetei
    List<RecipeIngredient> findByRecipeId(Long recipeId);

    // Găsește toate asociările de ingrediente care conțin un anumit ingredient, utilizând id-ul ingredientului
    List<RecipeIngredient> findByIngredientId(Long ingredientId);

}
