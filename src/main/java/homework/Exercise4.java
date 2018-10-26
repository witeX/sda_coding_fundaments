package homework;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter five 5 positive  values");

        int readCount = 0;
        int sum = 0;
        while (readCount < 5) {
            int number = scan.nextInt();
            if (number < 1) {
                System.out.println("Incorrect input value. Must be positive value");
                continue;
            }
            sum += number;
            readCount++;
        }

        System.out.println("Please enter five 5 negative values");

        readCount = 0;
        while (readCount < 5) {
            int number = scan.nextInt();
            if (number >= 0) {
                System.out.println("Incorrect input value. Must be negative value");
                continue;
            }
            sum += number;
            readCount++;
        }
        System.out.println("Sum is: " + sum);
    }
}
