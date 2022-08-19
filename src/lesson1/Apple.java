package lesson1;

public class Apple extends Fruit  {

    private final double weight = 1.0;

    public Apple() {
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return String.format("Apple{ weight=%",weight);
    }


}
