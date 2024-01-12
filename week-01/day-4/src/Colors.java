import java.util.Arrays;

public class Colors {
    public static void main(String[] args) {
        // - Create a two-dimensional array (of Strings)
        //   which can contain the different shades of specified colors
        // - In `colors[0]` store the shades of green:
        //   `"lime", "forest green", "olive", "pale green", "spring green"`
        // - In `colors[1]` store the shades of red:
        //   `"orange red", "red", "tomato"`
        // - In `colors[2]` store the shades of pink:
        //   `"orchid", "violet", "pink", "hot pink"`
        // - Print the array in the following format:
        //
        //   lime, forest green, oline, pale green, spring green
        //   orange red, red, tomato
        //   orchid, violet, pink, hot pink
        //
        String[][] colors = new String[][]{
                {"lime", "forest green", "olive", "pale green", "spring green"},
                {"orange red", "red", "tomato"},
                {"orchid", "violet", "pink", "hot pink"}
        };

        for (int y = 0; y < colors.length; y++) {

            for (int x = 0; x < colors[y].length; x++) {
                System.out.print(colors[y][x]);
                if (x < colors[y].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}