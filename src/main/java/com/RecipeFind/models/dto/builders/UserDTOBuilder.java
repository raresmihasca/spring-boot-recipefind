package com.RecipeFind.models.dto.builders;

import com.RecipeFind.models.User;
import com.RecipeFind.models.dto.UserDTO;

import java.util.ArrayList;

public class UserDTOBuilder {

    private UserDTOBuilder() {
    }

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .id(user.getId())
                .build();
    }

    public static User fromUserDTO(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phone(userDTO.getPhone())
                .email(userDTO.getEmail())
                .id(userDTO.getId())
                .build();
    }

    public static Iterable<UserDTO> toUserDTOList(Iterable<User> users) {
        ArrayList<UserDTO> userDTOS = new ArrayList<>();

        for (User user : users) {
            userDTOS.add(toUserDTO(user));
        }

        return userDTOS;
    }

}
