package com.RecipeFind.models;

import com.RecipeFind.models.enums.RecipeCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import java.sql.Types;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "recipes")
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "prep_time")
    private int prepTime; // Durata de preparare în minute

    @Column(name = "servings")
    private int servings; // Numărul de porții

    @Column(name = "cook_time")
    private int cookTime; // Timpul de gătire în minute

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;

    @ElementCollection(targetClass = RecipeCategory.class)
    @CollectionTable
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private List<RecipeCategory> category;

    @JdbcTypeCode(Types.VARBINARY)
    @Column(name = "image")
    private byte[] image; // Imaginea rețetei sub formă de array de bytes

}
