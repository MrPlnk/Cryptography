package com.brigada2.cryptography.code;

public class Utils {
    public static boolean trialDivision(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // НОД (алгоритм Евклида)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
