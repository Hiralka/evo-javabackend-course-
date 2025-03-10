package classes1;
import java.util.Scanner;

public class Classes1 {
    
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
    static String oprosName() {
        System.out.println("Введите имя:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        return name;
    }
    static int oprosAge() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите возраст:");
        int age = in.nextInt();
        return age;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //User chelik0 = new User("Victor", 20);
        //System.out.println(chelik);
        User chelik1 = new User(oprosName(), oprosAge());
        User chelik2 = new User(oprosName(), oprosAge());
        if (chelik1.age < chelik2.age) {
            System.out.println(chelik1);
        }
        else {
            System.out.println(chelik2);
        }

    }
    
}
