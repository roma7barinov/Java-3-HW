import lesson6.MethosLastFourArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





public class TestMethosLastFourArrays {
    @Test
    void testArray() {
        MethosLastFourArrays methosLastFourArrays = new MethosLastFourArrays();
        int[] arr1 = {1, 1, 3, 4, 1, 2, 3};
        int[] arrayTest1 = methosLastFourArrays.newArr(arr1);
        int[] arrayTestRes1 = {1, 2, 3};
        Assertions.assertArrayEquals(arrayTest1, arrayTestRes1, "Невозможно переобразовать массив");

        int[] arr2 = {4, 1, 3, 1, 1, 2, 3};
        int[] arrayTest2 = methosLastFourArrays.newArr(arr1);
        int[] arrayTestRes2 = {1, 3, 1, 1, 2, 3};
        Assertions.assertArrayEquals(arrayTest1, arrayTestRes2, "Невозможно переобразовать массив");

        int[] arr3 = {1, 1, 3, 1, 1, 4, 3};
        int[] arrayTest3 = methosLastFourArrays.newArr(arr1);
        int[] arrayTestRes3 = {3};
        Assertions.assertArrayEquals(arrayTest1, arrayTestRes3, "Невозможно переобразовать массив");

    }

}
