package com.gfa.exam.mostcommoncharacters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonCharacters {
    public static Map<Character, Integer> getTwoMostCommonCharacters(String filename) throws Exception {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            throw new Exception("File does not exist!");
        }

        List<String> lines = Files.readAllLines(path);
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        // input obsahuje text souboru
        String input = sb.toString();

        Map<Character, Integer> heatmap = new HashMap<>();
        for (String oneLetterString : input.split("")) {
            char character = oneLetterString.charAt(0);

            if (heatmap.containsKey(character)) {
                heatmap.replace(character, heatmap.get(character) + 1);
            } else {
                heatmap.put(character, 1);
            }

        }

//        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(heatmap.entrySet());
//        list.sort(Map.Entry.comparingByValue());
//        Map.Entry<Character, Integer> mostCommon = list.get(list.size() - 1);
//        Map.Entry<Character, Integer> secondMostCommon = list.get(list.size() - 2);
//        Map<Character, Integer> result = new HashMap<>();
//        result.put(mostCommon.getKey(), mostCommon.getValue());
//        result.put(secondMostCommon.getKey(), secondMostCommon.getValue());





//        for (Character key : heatmap.keySet()) {
//            if (heatmap.get(key) > secondMostValue) {
//                secondMostChar = key;
//                secondMostValue = heatmap.get(key);
//                continue;
//            }
//            if (heatmap.get(key) > mostValue) {
//                mostChar = key;
//                mostValue = heatmap.get(key);
//            }
//        }
        //
        Character mostChar = null;
        Integer mostValue = 0;
        Character secondMostChar = null;
        Integer secondMostValue = 0;

        for (Character key : heatmap.keySet()) {
            if (heatmap.get(key) > mostValue) {
                mostChar = key;
                mostValue = heatmap.get(key);
            }
        }
        heatmap.remove(mostChar);

        for (Character key : heatmap.keySet()) {
            if (heatmap.get(key) > secondMostValue) {
                secondMostChar = key;
                secondMostValue = heatmap.get(key);
            }
        }

        Map<Character, Integer> result = new HashMap<>();
        result.put(mostChar, mostValue);
        result.put(secondMostChar, secondMostValue);

        return result;
    }
}
