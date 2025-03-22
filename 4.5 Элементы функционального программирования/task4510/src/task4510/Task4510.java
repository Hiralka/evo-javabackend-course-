package task4510;

import java.util.stream.IntStream;


public class Task4510 {

 public static long getArithmeticProgressionSum(int a, int b) {
        return IntStream.range(a, b).asLongStream().sum();
    }

    public static void main(String[] args) {
        int a = 10_000_000;
        int b = 1_000_000_000;

        long sum = getArithmeticProgressionSum(a, b);

        System.out.println("Сумма чисел между " + a + " и " + b + " равна: " + sum);
    }
}
