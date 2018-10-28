package sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = new Random().ints(10,5,100).toArray();

        System.out.println("Initial array: " + Arrays.toString(array));

        int arraySize = array.length;
        for (int startIndexToCheck = 0; startIndexToCheck < arraySize - 1; startIndexToCheck++)
        {
            // Find the minimum element in unsorted array
            int currentMinValueIndex = startIndexToCheck;
            for (int checkIndex = startIndexToCheck+1; checkIndex < arraySize; checkIndex++)
                if (array[checkIndex] < array[currentMinValueIndex])
                    currentMinValueIndex = checkIndex;

            // Swap the found minimum element with the first
            // element
            int temp = array[currentMinValueIndex];
            array[currentMinValueIndex] = array[startIndexToCheck];
            array[startIndexToCheck] = temp;
        }

        System.out.println("Sorted array: " + Arrays.toString(array));

    }
}
