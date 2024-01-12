package com.example.p2pchat.DTOs;

import com.example.p2pchat.models.Client;

public record MessageDTO (Long id, String text, String username, Long timestamp, Client client) {
}
