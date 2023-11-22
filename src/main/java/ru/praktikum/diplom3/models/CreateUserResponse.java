package ru.praktikum.diplom3.models;

import lombok.Data;

@Data
public class CreateUserResponse {
    private Boolean success;
    private User user;
    private String accessToken;
    private String refreshToken;
}