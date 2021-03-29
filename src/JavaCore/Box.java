package JavaCore;

import java.util.ArrayList;

public class Box<T extends Weightable> implements Weightable {
    private ArrayList<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

    public void free() {
        elements.clear();
    }

    @Override
    public float getWeight() {
        float totalWeight = 0;
        for (Weightable element:elements) {
            totalWeight += element.getWeight();
        }
        return totalWeight;
    }

    public <U extends Weightable> boolean compare(Box<U> other) {
        return this.getWeight() == other.getWeight();
    }

    public void putInto(Box<T> other) {
        for (T element:elements) {
            other.add(element);
        }
        this.free();
    }
}
