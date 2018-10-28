import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {213, 3414, 12, 4, 124, 124, 12, 4, 124};

        for (int i = 0; i < array.length - 1; i++){


            for (int j = 0; j < array.length - (i + 1); j++) {

                if (array[j] < array[j + 1]) {
                    int tempVar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempVar;

                }

            }
        }

        System.out.println("Sorted array" + Arrays.toString(array));
    }
}
