package JavaCore;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> result = uniq(createCollection());
        System.out.println(result.toString());

        HashMap<String, Integer> result2 = wordCount(createCollection());
        System.out.println(result2.toString());

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "987879");
        phoneBook.add("Петров", "867567");
        phoneBook.add("Иванов", "845463");
        try {
            System.out.println(phoneBook.get("Петров"));
            System.out.println(phoneBook.get("Иванов"));
            System.out.println(phoneBook.get("Сидоров"));
        } catch (PhoneBook.PhoneBookException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<String> uniq(ArrayList<String> array) {
        array.sort(Comparator.naturalOrder());
        Iterator<String> iter = array.iterator();
        String previous = iter.next();
        while (iter.hasNext()) {
            String current = iter.next();
            if (current.equals(previous)) {
                iter.remove();
            }
            previous = current;
        }
        return array;
    }
    private static HashMap<String, Integer> wordCount(ArrayList<String> array) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String str:array) {
            Integer count = result.getOrDefault(str, 0);
            result.put(str, count + 1);
        }
        return result;
    }


    private static ArrayList<String> createCollection() {
        ArrayList<String> array = new ArrayList<>();
        array.add("About");
        array.add("Blog");
        array.add("Business");
        array.add("Career");
        array.add("Happiness");
        array.add("Creativity");
        array.add("Legal");
        array.add("Medical");
        array.add("Food");
        array.add("Happiness");
        array.add("Home");
        array.add("Language");
        array.add("Legal");
        array.add("Math");
        array.add("Medical");
        return array;
    }

}
