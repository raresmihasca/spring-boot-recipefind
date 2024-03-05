package com.RecipeFind.repositories;

import com.RecipeFind.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Salvează o rețetă în baza de date
    Recipe save(Recipe recipe);

    // Găsește o rețetă după id-ul său
    Recipe findRecipeById(Long id);

    // Returnează toate rețetele din baza de date
    List<Recipe> findAll();

    // Șterge o rețetă din baza de date după id-ul său
    void deleteRecipeById(Long id);

}
