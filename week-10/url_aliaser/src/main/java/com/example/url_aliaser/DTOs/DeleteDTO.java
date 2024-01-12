package com.example.url_aliaser.DTOs;

import com.example.url_aliaser.models.Alias;

public record DeleteDTO(String secretCode) {
    public DeleteDTO(Alias alias) {
            this(alias.getSecretCode());
    }
}
