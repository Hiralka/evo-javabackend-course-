package com.mycompany.inversioncontrol;
import java.util.Scanner;


public class Inversioncontrol {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число a: ");
        double a = scanner.nextDouble();
        System.out.print("Введите число b: ");
        double b = scanner.nextDouble();
        System.out.println("Результат умножения a и b: " + Multiplier.multiply(a, b));
        
        try {
            System.out.println("Результат деления a и b: " + Divider.divide(a, b));
        } 
        catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
