package classes2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Classes2 {
    
    public static class User {
        private String name;
        private Integer age;
        
        User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        public void setName(String a) {
            name = a;
        }
        public void setAge(Integer a) {
            age = a;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        @Override
        public String toString() {
            return(name + ", возраст " + age + " лет");
        }  
    }
    
    static String oprosName(int i) {
        System.out.println("Введите имя пользователя "+i+":");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        return name;
    }
    static int oprosAge(int i) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите возраст пользователя "+i+":");
        int age = in.nextInt();
        return age;
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        //User chelik1 = new User(oprosName(), oprosAge());
        ArrayList<User> ms = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            ms.add(new User(oprosName(i), oprosAge(i)));
        }
        System.out.println("До сортировки:");
        System.out.println(ms);
        Collections.sort(ms, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u1.getAge(), u2.getAge());
            }
        });
        System.out.println("После сортировки:");
        System.out.println(ms);
        
        
    }
    
}
