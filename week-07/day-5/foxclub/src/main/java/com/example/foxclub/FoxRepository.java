package com.example.foxclub;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FoxRepository {
    private Map<String, Fox> foxMap = new HashMap<>();

    public Fox getFox(String name) {
        return foxMap.get(name);
    }

    public void addFox(Fox fox) {
        foxMap.put(fox.getName(), fox);
    }

    public boolean foxCheck(String name) {
        return foxMap.containsKey(name);
    }
}