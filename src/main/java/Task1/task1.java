package Task1;

import java.util.Scanner;

class Rectangle {

    // Method for int values
    public int calculateArea(int length, int width) {
        return length * width;
    }

    // Overloaded method for double values
    public double calculateArea(double length, double width) {
        return length * width;
    }
}

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle rect = new Rectangle();

        System.out.println("Testing with int:");
        int areaInt = rect.calculateArea(5, 4);
        System.out.println("Area: " + areaInt); // 20

        System.out.println("\nTesting with double:");
        double areaDouble = rect.calculateArea(5.5, 4.2);
        System.out.println("Area: " + areaDouble); // 23.1

        sc.close();
    }
}