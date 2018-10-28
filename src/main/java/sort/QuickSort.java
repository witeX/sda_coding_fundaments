package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new Random().ints(10, 5, 100).toArray();

        System.out.println("Initial array: " + Arrays.toString(array));

        quickSort(array);


        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int partitionIndex = partition(array, low, high);
        quickSort(array, low, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivotValue = array[high];
        int currentLow = low;

        for (int checkIndex = low; checkIndex < high; checkIndex++) {
            if (array[checkIndex] <= pivotValue) {

                int swapTemp = array[currentLow];
                array[currentLow] = array[checkIndex];
                array[checkIndex] = swapTemp;
                currentLow++;
            }
        }

        int swapTemp = array[currentLow];
        array[currentLow] = array[high];
        array[high] = swapTemp;

        return currentLow;
    }
}
