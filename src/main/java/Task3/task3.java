package Task3;

import java.util.Scanner;

class NumberProcessor {

    // Recursive function to calculate sum of digits
    public int sumOfDigits(int x) {
        // Base case
        if (x == 0) {
            return 0;
        }
        // Recursive case: last digit + sum of remaining digits
        return (x % 10) + sumOfDigits(x / 10);
    }
}

public class task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberProcessor processor = new NumberProcessor();

        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        int result = processor.sumOfDigits(number);
        System.out.println("Sum of digits: " + result);

        sc.close();
    }
}