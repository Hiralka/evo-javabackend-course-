
package nums.funcs;

import java.util.Scanner;

public class NumsFuncs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Введите 3 целых числа:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if ((b == 0) || (c == 0)) {
            System.out.println("Один из делителей равен нулю! Остановка программы...");
            return;
        } 
        //проверки кратности
        if (a % 5 == 0) {
            System.out.println("a="+a);
        }
        if (b % 5 == 0) {
            System.out.println("b="+b);
        }
        if (c % 5 == 0) {
            System.out.println("c="+c);
        }
        if ((a % 5 != 0) && (b % 5 != 0) && (c % 5 != 0)) {
            System.out.println("Нет значений, кратных 5!");
        }
        //целочисленное деление
        int delc = a / b; 
        System.out.println("Результат целочисленного деления a на b:"+delc);
        //деление с получением результата с плавающей запятой
        double deld = (double)a / (double)b;
        System.out.println("Результат деления a на b (с плавающей запятой):"+deld);
        //деление с округлением в большую сторону
        double okb = (double)a / (double)b;
        System.out.println("Результат деления a на b с округлением в большую сторону:"+(Math.ceil(okb)));
        //деление с округлением в меньшую сторону
        double okm = (double)a / (double)b;
        System.out.println("Результат деления a на b с округлением в меньшую сторону:"+(Math.floor(okm)));
        //нормальное округление
        double okn = (double)a / (double)b;
        System.out.println("Результат деления а на b с математическим округлением:"+(Math.round(okn)));
        //остаток от деления
        int ost = b % c;
        System.out.println("Остаток от деления b на c:"+ost);
        //наименьшее значение из a и b
        if (a < b) {
            System.out.println("Наименьшее значение из a и b:"+a);
        }
        else {
            System.out.println("Наименьшее значение из a и b:"+b);
        }
        //наибольшее значение из b и c
        if (b > c) {
            System.out.println("Наибольшее значение из b и c:"+b);
        }
        else {
            System.out.println("Наибольшее значение из b и c:"+c);
        }
    }
    
}
