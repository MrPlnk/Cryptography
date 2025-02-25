package com.brigada2.cryptography.code;

import static com.brigada2.cryptography.code.Utils.*;

import java.math.BigInteger;

public class p1PalladsFactorization {

    // Метод факторизации Полларда (p-1)
    public static int factorization(int n, int B) {
        if (!trialDivision(n)){
            return -1;
        }

        BigInteger a = BigInteger.valueOf(2); // Базовое число
        BigInteger N = BigInteger.valueOf(n); // Число для факторизации

        // Вычисляем a^M(B) mod n
        for (int i = 2; i <= B; i++) {
            int exp = (int) Math.pow(i, Math.floor(Math.log(B) / Math.log(i))); // Выбираем максимальную степень i, не превышающую B
            a = a.modPow(BigInteger.valueOf(exp), N);
        }

        // Ищем НОД(a - 1, n)
        int d = gcd(a.intValue() - 1, n);

        // Если нашли нетривиальный делитель, возвращаем его
        if (d > 1 && d < n) {
            return d;
        }

        // Если не нашли, увеличиваем B и пробуем снова
        return -1; // Факторизация не удалась
    }
}