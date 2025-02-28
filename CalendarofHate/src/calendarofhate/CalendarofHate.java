package calendarofhate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;


public class CalendarofHate {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date firstDate = readDate(scanner, "Введите дату в формате dd.MM.yyyy");
        
        Calendar cal = toCalendar(firstDate);
        cal.add(Calendar.DAY_OF_MONTH, 45);
        System.out.println("Дата после увеличения на 45 дней:" + sdf.format(cal.getTime()));

        cal = toCalendar(firstDate);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        System.out.println("Дата после сдвига на начало года:" + sdf.format(cal.getTime()));

        Date dateWithWorkDays = addWorkDays(firstDate, 10);
        System.out.println(" Дата после увеличения на 10 рабочих дней:" + sdf.format(dateWithWorkDays));

        Date secondDate = readDate(scanner, "Введите вторую дату в формате dd.MM.yyyy:");

        int workingDays = countWorkingDays(firstDate, secondDate);
        System.out.println("Количество рабочих дней между введенными датами:" + workingDays);
    }

    private static Date readDate(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sdf.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Ошибка! Введите дату в формате дд.мм.гггг");
            }
        }
    }

    private static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    private static Date addWorkDays(Date startDate, int days) {
        Calendar cal = toCalendar(startDate);
        int added = 0;
        while (added < days) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (isWorkDay(cal)) {
                added++;
            }
        }
        return cal.getTime();
    }

    private static int countWorkingDays(Date start, Date end) {
        Calendar cal1 = toCalendar(start);
        Calendar cal2 = toCalendar(end);
        
        if (cal1.after(cal2)) {
            Calendar temp = cal1;
            cal1 = cal2;
            cal2 = temp;
        }

        int count = 0;
        while (!cal1.after(cal2)) {
            if (isWorkDay(cal1)) count++;
            cal1.add(Calendar.DAY_OF_MONTH, 1);
        }
        return count;
    }

    private static boolean isWorkDay(Calendar cal) {
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
    }
}
