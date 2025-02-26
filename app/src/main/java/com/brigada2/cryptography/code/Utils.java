package com.brigada2.cryptography.code;

public class Utils {
    public static boolean trialDivision(int num) {
        if (num < 2) return false;  // 0 и 1 — не простые
        if (num == 2) return true;  // 2 — единственное чётное простое число
        if (num % 2 == 0) return false;  // Чётные числа >2 не являются простыми

        int sqrtNum = (int) Math.sqrt(num);  // Вычисляем sqrt(num) один раз
        for (int i = 3; i <= sqrtNum; i += 2) {  // Перебираем только нечётные делители
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
