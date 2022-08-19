package lesson1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Task 1
        //Замудрил немного с классами
        System.out.println("____________Task1_______________");
        Status<Integer> status1 = new Status<>(new Integer[]{1, 2});
        Status<String> status2 = new Status<>(new String[]{"3", "4"});
        Status<Double> status3 = new Status<>(new Double[]{5.4, 6.6});

        printInfo(status1);
        System.out.println("_______");
        printInfo(status2);
        System.out.println("_______");
        printInfo(status3);

        //Task 2
        System.out.println("____________Task2________________");
        String[] arr1 = {"1", "2", "3"};
        Integer[] arr2 = {4,5,6};
        arrList(arr1);
        arrList(arr2);

        //Task 3
        System.out.println("____________Task3________________");
        Box<Apple> bApples = new Box<>(new ArrayList<>());
        Box<Orange> bOranges = new Box<>(new ArrayList<>());

        getApple(bApples ,6);
        getOrange(bOranges,10);

        System.out.println(bApples.getWeight());
        System.out.println(bOranges.getWeight());
        System.out.println(bApples.compare(bOranges));
        getApple(bApples,5);
        System.out.println(bApples.getWeight());
        System.out.println(bApples.compare(bOranges));



    }

    private static void getApple(Box<Apple> bApples , int lot) {
        for (int i = 0; i < lot; i++) {
            bApples.addFruit(new Apple());
        }
    }
    private static void getOrange(Box<Orange> bOranges , int lot) {
        for (int i = 0; i < lot; i++) {
            bOranges.addFruit(new Orange());
        }
    }

    public static <T> void arrList(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
    }


    public static void printInfo(Status<?> status) {
        status.info();
        status.changeElement();
        status.info();
    }

}

