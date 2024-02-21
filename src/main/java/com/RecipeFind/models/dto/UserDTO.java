package com.RecipeFind.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer id;

}
