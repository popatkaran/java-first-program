package com.h2;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static final Map<Integer,Float> bestRates;

    static {
        bestRates = new HashMap<>();
        bestRates.put(1, 5.50f);
        bestRates.put(2, 3.45f);
        bestRates.put(3, 2.67f);
    }

    public static void main(String[] args) {
        /* initialise scanner */
        var scanner = new Scanner(System.in);

        /* Greet user */
        System.out.printf("Hello %s%n", getUserName(scanner));

        /* find loan interest rate */
        int loanTermInYears = getLoanTermInYears(scanner);
        float loanInterestRate = getRates(loanTermInYears);

        /* provide appropriate message */
        if(Math.abs(loanInterestRate) > 0.0f) {
            System.out.printf("Best Available Rate: %f", loanInterestRate);
        } else {
            System.out.printf("No available rates for term: %d years", loanTermInYears);
        }

        scanner.close();
    }

    public static float getRates(int loanTermInYears) {
        return bestRates.getOrDefault(loanTermInYears, 0.0f);
    }

    private static String getUserName(@NotNull Scanner scanner) {
        System.out.println("Enter your name");
        return scanner.nextLine();
    }

    private static int getLoanTermInYears(@NotNull Scanner scanner) {
        System.out.println("Enter the loan term (in years)");
        return scanner.nextInt();
    }
}
