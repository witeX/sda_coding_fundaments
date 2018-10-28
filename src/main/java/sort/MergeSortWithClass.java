package sort;

import java.util.Arrays;

public class MergeSortWithClass {

    public static void main(String[] args) {
        int[] array = {12, 4, 21, 34, 124,/* split point*/ 3, 44, 23, 64};
        //int[] array = {12};

        mergeSort(array, 0, array.length - 1);


        System.out.println(Arrays.toString(array));

    }

    private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];


        System.arraycopy(array, leftIndex, leftArray, 0, leftArraySize);
        System.arraycopy(array, middleIndex + 1, rightArray, 0, rightArraySize);


        int leftCurrentPosition = 0;
        int rightCurrentPosition = 0;
        int mainArrayCurrentPosition = leftIndex;

        while (leftCurrentPosition < leftArraySize && rightCurrentPosition < rightArraySize) {
            if (leftArray[leftCurrentPosition] <= rightArray[rightCurrentPosition]) {
                array[mainArrayCurrentPosition] = leftArray[leftCurrentPosition];
                leftCurrentPosition++;
            } else {
                array[mainArrayCurrentPosition] = rightArray[rightCurrentPosition];
                rightCurrentPosition++;
            }
            mainArrayCurrentPosition++;
        }

        while (leftCurrentPosition < leftArraySize) {
            array[mainArrayCurrentPosition] = leftArray[leftCurrentPosition];
            leftCurrentPosition++;
            mainArrayCurrentPosition++;
        }
        while (rightCurrentPosition < rightArraySize) {
            array[mainArrayCurrentPosition] = rightArray[rightCurrentPosition];
            rightCurrentPosition++;
            mainArrayCurrentPosition++;
        }

    }


}
