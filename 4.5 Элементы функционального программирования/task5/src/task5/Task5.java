/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task5;
import java.util.stream.IntStream;

public class Task5 {
    public static long getArithmeticProgressionSum(int a, int b) {
        return IntStream.range(a, b).asLongStream().sum();
    }

    public static void main(String[] args) {
        int a = 10000000;
        int b = 1000000000;

        long sum = getArithmeticProgressionSum(a, b);
        System.out.println("Сумма чисел между " + a + " и " + b + " равна: " + sum);
    }
}