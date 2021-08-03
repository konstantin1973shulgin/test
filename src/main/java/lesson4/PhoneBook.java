package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private final HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        ArrayList<String> phonesForLastName = phoneBook.getOrDefault(lastName, new ArrayList<>());
        phonesForLastName.add(phoneNumber);
        phoneBook.put(lastName, phonesForLastName);
    }

    public ArrayList<String> get(String lastName) {
        return phoneBook.get(lastName);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "89556385699");
        phoneBook.add("Ivanov", "89556385667");
        phoneBook.add("Petrov", "89556385688");
        phoneBook.add("Sedov","89556385698");

        phoneBook.get("Ivanov");
        phoneBook.get("Petrov");
        phoneBook.get("Sedov");
        phoneBook.get("Vasiliev");

        System.out.println(phoneBook.get("Ivanov"));
        System.out.println(phoneBook.get("Vasiliev"));
    }
}
