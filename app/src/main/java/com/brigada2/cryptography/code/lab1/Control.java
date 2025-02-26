package com.brigada2.cryptography.code.lab1;

import com.brigada2.cryptography.MainActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Control {
    static long timeDelta = 0;

    public static double getTimeDelta(){
        return timeDelta / 10e+6;
    }
    public static String calculate(String inputNum, String parametrK, String parametrC){
        String result = "";
        int devider = 0;
        ArrayList<Integer> list = new ArrayList<>();

        try {
            int paramK = Integer.valueOf(parametrK);
            int num = Integer.valueOf(inputNum);
            int paramC = Integer.valueOf(parametrC);
            long startTime = System.nanoTime();
            do{
                devider = p1PalladsFactorization.factorization(num, paramK, paramC);
                if (list.size() >= 1 && devider == -2){
                    list.add(num);
                    devider = 0;
                    break;
                }
                list.add(devider);
                num = num / devider;
            }while (devider > 0);
            timeDelta = System.nanoTime() - startTime;

        }catch (NumberFormatException e){
            devider = -3;
        }
        if (devider == -1){
            result = "Факторизация не удалась";
        }
        else if (devider == -2 && list.size() <= 1){
            result = "Число уже простое";
        }
        else if (devider == -3){
            result = "Введите корректные данные";
        }
        else if (devider == -4){
            result = "НОД(n, c) != 1";
        }
        else{
            result = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
        }

        return result;
    }
}
