package com.brigada2.cryptography.code.lab1;

import static com.brigada2.cryptography.code.Utils.*;

import java.math.BigInteger;

public class p1PalladsFactorization {

    // Метод факторизации Полларда (p-1)
    public static int factorization(int n, int K, int C) {
        if (trialDivision(n)){
            return -2;
        }

        if (gcd(n, C) != 1){
            return -4;
        }

        //---------------------------

        BigInteger c = BigInteger.valueOf(C);
        BigInteger M = BigInteger.ONE;
        BigInteger N = BigInteger.valueOf(n);

        for (int p = 2; p <= K; p++) {
            if (trialDivision(p)) {
                int e = 1;
                while (Math.pow(p, e) <= K) {
                    e++;
                }
                M = M.multiply(BigInteger.valueOf(p).pow(e - 1));
            }
        }

        BigInteger x = c.modPow(M, N);
        BigInteger d = x.subtract(BigInteger.ONE).gcd(N);

        if (d.equals(BigInteger.ONE) || d.equals(N)) {
            return -1;
        }
        return d.intValue();
    }
}