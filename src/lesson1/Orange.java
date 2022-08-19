package lesson1;

public class Orange extends Fruit  {

    private final double weight = 1.0;

    public Orange() {
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return String.format("Orange { weight=%",weight);
    }


}
