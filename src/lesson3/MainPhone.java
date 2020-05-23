package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPhone {

    HashMap<String, ArrayList<String>> phoneBookMap = new HashMap<>();

    public void add(String name, String phone) {

        ArrayList<String> phones = phoneBookMap.get(name);
        if (phones == null) {
            phones = new ArrayList<>();
            phoneBookMap.put(name, phones);
        }

        phones.add(phone);
    }

    public void get(String name) {
        ArrayList<String> phones = phoneBookMap.get(name);
        System.out.print(name + ": ");
        if (phones != null) {
            for (String value : phones) {
                System.out.print(value + "; ");
            }
        }
        else {
            System.out.println("Нет записей");
        }
        System.out.println();
    }

    public static void main(String[] argv) {
        MainPhone phonebook = new MainPhone();

        phonebook.add("Иванов", "+79211111111");
        phonebook.add("Петров", "+79212222222");
        phonebook.add("Сидоров", "+79213333333");
        phonebook.add("Кузнецов", "+79214444444");
        phonebook.add("Петров", "+79215555555");

        phonebook.get("Петров");
        phonebook.get("Сидоров");
        phonebook.get("Гендальф");

    }
}
