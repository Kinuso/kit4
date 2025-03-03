package com.example.kit4.dto;


public final class UserDto {
    public final String id;
    public final String email;

    public UserDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
