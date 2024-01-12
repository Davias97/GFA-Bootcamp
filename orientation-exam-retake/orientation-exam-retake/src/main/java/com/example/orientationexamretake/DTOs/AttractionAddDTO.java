package com.example.orientationexamretake.DTOs;

import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.models.Category;

public record AttractionAddDTO(String name, String city, int price, double longitude, double latitude, String category, int duration, int recommendedAge) {

}
