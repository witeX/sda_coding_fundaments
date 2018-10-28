package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new Random().ints(8, 5, 100).toArray();

        System.out.println("Initial array: " + Arrays.toString(array));

        mergeSort(array);


        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left +right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }

    }

    private static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftPartArray = new int[leftSize];
        int[] rightPartArray = new int[rightSize];
        System.arraycopy(array, left, leftPartArray, 0, leftSize); //copy left part of array to temp left part array
        System.arraycopy(array, middle + 1, rightPartArray, 0, rightSize); //copy right part of array to temp right part array

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergeArrayIndex = left;
        while (leftArrayIndex < leftSize && rightArrayIndex < rightSize) {
             if (leftPartArray[leftArrayIndex] <= rightPartArray[rightArrayIndex]) {
                array[mergeArrayIndex] = leftPartArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[mergeArrayIndex] = rightPartArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergeArrayIndex++;
        }

        while (leftArrayIndex < leftSize) {
            array[mergeArrayIndex] = leftPartArray[leftArrayIndex];
            leftArrayIndex++;
            mergeArrayIndex++;
        }

        while (rightArrayIndex < rightSize) {
            array[mergeArrayIndex] = rightPartArray[rightArrayIndex];
            rightArrayIndex++;
            mergeArrayIndex++;
        }
    }
}
