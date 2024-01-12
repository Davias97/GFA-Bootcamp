public class CompareLength {
    public static void main(String[] args) {
        // - Create an array variable named `firstArrayOfNumbers`
        //   with the following content: `[1, 2, 3]`
        // - Create an array variable named `secondArrayOfNumbers`
        //   with the following content: `[4, 5]`
        // - Print "secondArrayOfNumbers is longer" if `secondArrayOfNumbers`
        // has more elements than `firstArrayOfNumbers`
        // - Otherwise print: "firstArrayOfNumbers is the longer one"
        String[] firstArrayOfNumbers = new String [3];
        int[] numbers1 = {1, 2, 3};

        String[] secondArrayOfNumbers = new String [2];
        int[] numbers2 = {4, 5};

        if (secondArrayOfNumbers.length>firstArrayOfNumbers.length) {
            System.out.println("secondArrayOfNumbers is longer");
        }   else {
            System.out.println("firstArrayOfNumbers is the longer one");
        }




    }
}