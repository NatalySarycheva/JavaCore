package JavaCore;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> dictionary = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        ArrayList<String> phonesForLastName = dictionary.getOrDefault(lastName, new ArrayList<>());
        phonesForLastName.add(phoneNumber);
        dictionary.put(lastName, phonesForLastName);
    }

    public ArrayList<String> get(String lastName) throws PhoneBookException {
        ArrayList<String> numbers = dictionary.get(lastName);
        if (numbers == null) {
            throw new LastNameNotFoundException(lastName);
        }
        return numbers;
    }

    public class PhoneBookException extends Exception {
       public PhoneBookException (String msg) {
            super(msg);
        }
    }

    public class LastNameNotFoundException extends PhoneBookException {
        public LastNameNotFoundException (String lastName) {
            super("Нет записи для такой фамилии - " + lastName);
        }
    }
}
