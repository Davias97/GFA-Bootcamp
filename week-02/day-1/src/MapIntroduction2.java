import java.util.HashMap;

public class MapIntroduction2 {
    public static void main(String... args) {

        HashMap<String, String> bookList = new HashMap<>();
        bookList.put("978-1-60309-452-8", "A Letter to Jo");
        bookList.put("978-1-60309-459-7", "Lupus");
        bookList.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        bookList.put("978-1-60309-461-0", "The Lab");

        for(String key : bookList.keySet()) {
            print(bookList, key);
        }

        bookList.remove("978-1-60309-444-3");

        bookList.remove("978-1-60309-461-0");

        bookList.put("978-1-60309-450-4", "They Called Us Enemy");
        bookList.put("978-1-60309-453-5", "Why Did We Trust Him?");

        System.out.println(bookList.containsValue("478-0-61159-424-8"));

        System.out.println(bookList.get("978-1-60309-453-5"));


    }

    public static void print(HashMap<String, String> bookList, String key) {
        System.out.println(bookList.get(key) + " (ISBN: " + key + ")");
    }

}