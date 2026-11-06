package Task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class DateCalculator {

    public long calculateDaysBetween(int year_from, int month_from, int day_from,
                                     int year_to, int month_to, int day_to) {
        LocalDate dateFrom = LocalDate.of(year_from, month_from, day_from);
        LocalDate dateTo = LocalDate.of(year_to, month_to, day_to);

        // absolute difference in days
        return Math.abs(ChronoUnit.DAYS.between(dateFrom, dateTo));
    }
}

public class task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateCalculator calc = new DateCalculator();

        System.out.println("Enter first date year month day:");
        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();

        System.out.println("Enter second date year month day:");
        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        long days = calc.calculateDaysBetween(y1, m1, d1, y2, m2, d2);
        System.out.println("Number of days between: " + days);

        sc.close();
    }
}