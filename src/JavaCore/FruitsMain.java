package JavaCore;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FruitsMain {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(appleBox.getWeight());

        // oranges
        Box<Orange> orangeBox = new Box<>();

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(orangeBox.getWeight());

        // compare apple box to orange box
        System.out.println(appleBox.compare(orangeBox));

        // put apples from apple box to empty apple box
        Box<Apple> emptyAppleBox = new Box<>();

        System.out.println(appleBox.getWeight());
        System.out.println(emptyAppleBox.getWeight());

        appleBox.putInto(emptyAppleBox);

        System.out.println(appleBox.getWeight());
        System.out.println(emptyAppleBox.getWeight());
    }
}
