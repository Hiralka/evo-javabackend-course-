package classes3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Classes3 {

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
            return (name + ", возраст " + age + " лет");
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, List<User>> usersMap;
        int searchAge;
        try (Scanner scanner = new Scanner(System.in)) {
            usersMap = new HashMap<>();
            for (int i = 1; i <= 5; i++) {
                System.out.println("Введите имя пользователя "+i+":");
                String name = scanner.nextLine();
                
                System.out.println("Введите возраст пользователя "+i+":");
                int age = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                
                User user = new User(name, age);
                // Добавление в мапу
                usersMap.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
            }
            System.out.println("Введите требуемый возраст: ");
            searchAge = scanner.nextInt();
        }

        List<User> users = usersMap.getOrDefault(searchAge, Collections.emptyList());
        if (!users.isEmpty()) {
            Collections.sort(users, Comparator.comparing(User::getName));
            System.out.println("\nНайденные пользователи с возрастом " + searchAge + ":");
            users.forEach(System.out::println);
        } 
        else {
            System.out.println("\nПользователи с возрастом " + searchAge + " не найдены.");
        }
    }
}
