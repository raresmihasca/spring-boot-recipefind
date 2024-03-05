package com.RecipeFind.repositories;

import com.RecipeFind.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // Salvează un ingredient în baza de date
    Ingredient save(Ingredient ingredient);

    // Găsește un ingredient după id-ul său
    Ingredient findIngredientById(Long id);

    // Returnează toate ingredientele din baza de date
    List<Ingredient> findAll();

    // Șterge un ingredient din baza de date după id-ul său
    void deleteIngredientById(Long id);

}
