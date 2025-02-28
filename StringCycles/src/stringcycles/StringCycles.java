
package stringcycles;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class StringCycles {
    
    public static boolean ifEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    public static int countMatches(String name, String pname) {
        if (ifEmpty(name) || ifEmpty(pname)) {
            return 0;
        }
        int index = 0, count = 0;
        while(true)
        {
            index = name.indexOf(pname, index);
            if (index != -1)
            {
                count++;
                index += pname.length();
            }
            else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //4.1
        System.out.println("---4.1---");
        System.out.println("Введите строку:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        name = name.toLowerCase();
        System.out.println("Введите подстроку:");
        String pname = in.nextLine();
        pname = pname.toLowerCase();
        int cnt = countMatches(name,pname);
        System.out.println("Подстрока '"+pname+"' встречается "+cnt+" раза");
        //4.2
        System.out.println("---4.2---");
        System.out.println("Введите строку:");
        name = in.nextLine();
        name = name.toLowerCase();
        name = name.replace("кака", "вырезано цензурой");
        name = name.replace("бяка", "вырезано цензурой");
        System.out.println(name);
        //4.3
        System.out.println("---4.3---");
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        name = in.nextLine();
        StringTokenizer st = new StringTokenizer(name, ".");
        String st0[] = new String[3];
        while (st.hasMoreTokens()) {
            for(int i = 0; i < st0.length; i++) {
                st0[i] = st.nextToken();
            }             
        }
        System.out.println(st0[2]+"-"+st0[1]+"-"+st0[0]);
        //4.4
        System.out.println("---4.4---");
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        name = in.nextLine();

        SimpleDateFormat inputFormatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = inputFormatter.parse(name);
            String formattedDate = outputFormatter.format(date);
            System.out.println(formattedDate);
        } 
        catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты!");
        }
    }
}
