import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesStatistics {
    public static void main(String[] args) {
        String fileName = "sales";
        System.out.println(calculateSalesStats(fileName));
    }

    public static Map<String, Integer> calculateSalesStats(String fileName) {

        Map<String, Integer> salesStatsMap = new HashMap<>();
        Path file = Paths.get(fileName);
        List<String> fileToText;

        // Error handling

        try {
            fileToText = Files.readAllLines(file);

        } catch (IOException e) {
            throw new RuntimeException("File not found: " + fileName);
        }
        if (fileName.isEmpty()) {
            return null;
        }

        // Array of words

       String[] wordByWord = fileToText.toString().split(",");


        // totalRevenue

        int totalRevenue = 0;
        for (int i = 2; i < wordByWord.length; i+=3) {
            String result = wordByWord[i];
            if (result.charAt(result.length() - 1) == ']') {
               result = result.replace(']', ' ');
               result = result.trim();
            }
            totalRevenue += Integer.parseInt(result);
        }

        //totalUnits

        int totalUnits = 0;
        for (int i = 1; i < wordByWord.length; i+=3) {
            String result = wordByWord[i];
            totalUnits += Integer.parseInt(result);
        }

        // Stats to map
        salesStatsMap.put("totalRevenue", totalRevenue);
        salesStatsMap.put("totalUnits", totalUnits);


    return salesStatsMap;
    }

}

