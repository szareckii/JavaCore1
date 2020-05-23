package lesson3;

import java.util.*;

public class MainCountUniqueString {

    public static void main(String[] args) {

        String[] stringArray = new String[] {"Первое", "Второе", "Третье", "Четвертое", "Пятое",
                "Шестое", "Седьмое", "Восьмое", "Девятое", "Десятое", "Третье", "Шестое", "Первое", "Третье"};

        List<String> list = new ArrayList<>(Arrays.asList(stringArray));

        Map<String, Integer> mapString = new LinkedHashMap();

        for (String string : list) {
            if(mapString.containsKey(string)) {
                mapString.put(string, mapString.get(string) + 1);
            } else {
                mapString.put(string, 1);
            }
        }

        System.out.println(mapString);

    }
}

