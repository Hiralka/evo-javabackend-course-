package arithmeticprogressionsum;

import java.util.stream.IntStream;

public class ArithmeticProgressionSum {

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
