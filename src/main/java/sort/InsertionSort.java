package sort;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = new Random().ints(10,5,100).toArray();

        System.out.println("Initial array: " + Arrays.toString(array));

        for (int startIndexToCheck = 1; startIndexToCheck < array.length; startIndexToCheck++) {
            int valueForCheck = array[startIndexToCheck];
            int previousIndex = startIndexToCheck - 1;

            while (previousIndex >= 0 && array[previousIndex] > valueForCheck) {
                array[previousIndex + 1] = array[previousIndex];
                previousIndex--;
            }

            if (previousIndex + 1 < startIndexToCheck) {
                array[previousIndex + 1] = valueForCheck;
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(array));

    }
}
