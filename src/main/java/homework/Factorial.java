package homework;

/*
Exercise N.1
Read one number and print its factorial using only multiplication.
1. Make that task with cycle
+ you can try make that task with recursion
 */


import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter number to find factorial");
        int number = scan.nextInt();

        System.out.println("Find factorial with cycle:" + findFactorialWithCycle(number));
        System.out.println("Find factorial with recursion:" + findFactorialByRecursion(number));
    }

    private static int findFactorialByRecursion(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * findFactorialByRecursion(number - 1);
    }

    private static int findFactorialWithCycle(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
