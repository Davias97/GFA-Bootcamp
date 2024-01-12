package com.example.federationweb.dtos;

public record CitizenDTO(String name, String role, int score){
    @Override
    public String name() {
        return name;
    }

    @Override
    public String role() {
        return role;
    }

    @Override
    public int score() {
        return score;
    }
}
