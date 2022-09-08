package lesson6;

import java.util.Arrays;

public class MethosLastFourArrays {
    private int[] arr;
    private int[] newArr;

    public MethosLastFourArrays() {

    }
    public int[] newArr (int[] arr) {
        this.arr = arr;
        onFourInArray(arr);
        int temp = 0;
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (arr[i] == 4) {
                temp = arr.length - i - 1;
                break;
            }
            
        }
        this.newArr = new int[temp];
        int temp1 = 0;
        for (int i = arr.length - temp1; i < arr.length; i++) {
            newArr[temp1] = arr[i];
            temp1++;
        }
        return newArr;
    }
    private void onFourInArray(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4) {
                count++;
            }
        }
        if (count == 0) {
            throw new RuntimeException("В массиве нет числа 4");
        }
    }
    





}
