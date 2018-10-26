package homework;

import java.util.Scanner;

public class Exercise2WithWhile {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter five 5 positive  values");

        int readCount = 0;
        int maxValue = 0;
        while (readCount < 5) {
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
