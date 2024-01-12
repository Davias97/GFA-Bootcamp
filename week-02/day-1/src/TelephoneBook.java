import java.util.HashMap;

public class TelephoneBook {
    public static void main(String[] args) {

        HashMap<String, String> telephoneBook = new HashMap<>();
        telephoneBook.put("William A. Lathan", "405-709-1865");
        telephoneBook.put("John K. Miller", "402-247-8568");
        telephoneBook.put("Hortensia E. Foster", "606-481-6467");
        telephoneBook.put("Amanda D. Newland", "319-243-5613");
        telephoneBook.put("Brooke P. Askew", "307-687-2982");

        System.out.println(telephoneBook.get("John K. Miller"));
        System.out.println(output(telephoneBook, "307-687-2982"));
        System.out.println(output2(telephoneBook, "Chris E. Myers"));


    }


    public static String output(HashMap<String, String> telephoneBook, String name) {

        for (String key : telephoneBook.keySet()) {
            String value = telephoneBook.get(key);
            if (value.equals(name)) {

                return key;
            }

        }
        return "number not found";
    }

    public static String output2(HashMap<String, String> telephoneBook, String number) {

        for (String key : telephoneBook.keySet()) {
            if (number.equals(key)) {

                return "yes";
            }
        }
        return "no";
    }
}






