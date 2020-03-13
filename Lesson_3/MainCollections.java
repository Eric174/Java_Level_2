package Lesson_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MainCollections {

    public static HashSet<String> getList(String[] str_arr) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, str_arr);
        return set;
    }

    public static HashMap<String, Integer> wordsCounter(String[] str_arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : str_arr) {
            Integer counter = map.get(str);
            if (counter == null) {
                counter = 0;
            }
            map.put(str, ++counter);
        }
        return map;
    }

    public static void main(String[] args) {
        //1
        String str = "elefant cat dog mouse horse fox pig monkey cat cow snake racoon hamster fox parrot dog goat chicken sheep rabbit fox mole";
        String[] str_arr = str.split(" ");
        System.out.println(getList(str_arr));

        HashMap<String, Integer> map = wordsCounter(str_arr);
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println();

        //2
        PhoneBook book = new PhoneBook();
        book.add(new Person("Booker", "2222-2222", "booker@gmail.com"));
        book.add(new Person("Booker", "2222-2243", "booker_ma@mail.com"));
        book.add(new Person("Booker", "2222-2256", "booker_ya@eandex.com"));
        book.add(new Person("Smith", "", ""));
        book.add(new Person("Smith", "0000-0001", ""));
        book.add(new Person("Smith", "0000-0001", "smith@mail.com"));
        book.add(new Person("Smith", "", "smith@mail.com"));
        System.out.println(book.getPhones("Booker"));
        System.out.println(book.getEmails("Booker"));
        System.out.println();
        System.out.println(book.getPhones("Smith"));
        System.out.println(book.getEmails("Smith"));
    }
}
