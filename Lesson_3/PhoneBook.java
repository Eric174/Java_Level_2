package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>[]> map = new HashMap<>();

    public void add(Person person) {
        ArrayList<String>[] list_arr = map.get(person.getFamily());
        if (list_arr == null) {
            list_arr = new ArrayList[]{new ArrayList<String>(), new ArrayList<String>()};
        }
        if (list_arr[0].indexOf(person.getPhone()) == -1) {
            list_arr[0].add(person.getPhone());
        }
        if (list_arr[1].indexOf(person.getEmail()) == - 1) {
            list_arr[1].add(person.getEmail());
        }
        map.put(person.getFamily(), list_arr);
    }

    public ArrayList<String> getPhones(String family) {
        return map.get(family)[0];
    }

    public ArrayList<String> getEmails(String family) {
        return map.get(family)[1];
    }
}
