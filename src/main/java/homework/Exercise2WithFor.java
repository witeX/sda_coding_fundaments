package homework;

import java.util.Scanner;

public class Exercise2WithFor {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter five 5 positive  values");


        int maxValue = 0;
        for (int readCount = 0; readCount < 5; ) {
            int number = scan.nextInt();
            if (number <= 0) {
                System.out.println("Incorrect input value. Must be positive value");
                continue;
            }

            if (number > maxValue) {
                maxValue = number;
            }
            readCount++;
        }
        System.out.println("Max value is: " + maxValue);

    }
}
