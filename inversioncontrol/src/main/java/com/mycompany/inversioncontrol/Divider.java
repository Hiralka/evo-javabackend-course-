package com.mycompany.inversioncontrol;

public class Divider {
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return a / b;
    }
}
