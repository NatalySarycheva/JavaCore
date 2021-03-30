package JavaCore;

public abstract class Fruit implements Weightable {
    private float weight;

    protected Fruit(float weight) {
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
