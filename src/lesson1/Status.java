package lesson1;

public class Status<T> {
    private T[] arr;

    public Status(T[] arr) {
        this.arr = arr;
    }

    public void changeElement() {
        T x = arr[0];
        arr[0] = arr[1];
        arr[1] = x;
    }

    public void info() {
        System.out.println(arr[0] + " " + arr[1]);
    }
}
