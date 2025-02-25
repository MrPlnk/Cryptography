package com.brigada2.cryptography.code.lab1;

import java.util.ArrayList;

public class Control {
    public static String calculate(String inputNum, String parametrK, String parametrC){
        String result = "";
        int devider = 0;
        try {
            int paramK = Integer.valueOf(parametrK);
            int num = Integer.valueOf(inputNum);
            int paramC = Integer.valueOf(parametrC);
            devider = p1PalladsFactorization.factorization(num, paramK, paramC);
        }catch (NumberFormatException e){
            devider = -3;
        }
        if (devider == -1){
            result = "Факторизация не удалась";
        }
        else if (devider == -2){
            result = "Число уже простое";
        }
        else if (devider == -3){
            result = "Введите корректные данные";
        }
        else if (devider == -4){
            result = "НОД(n, c) != 1";
        }
        else{
            result = String.valueOf(devider);
        }

        return result;
    }
}
