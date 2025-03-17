package student;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

interface Learner {
    void learn();
}

class Student implements Learner {
    @Override
    public void learn() {
        System.out.println("Я учусь. .zZ");
        IntStream.range(0, 1000000).forEach(i -> Math.log(i));
        System.out.println("Я закончил учиться");
    }
}

class StudentWithClock implements Learner {
    private Learner learner;
    
    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }
    
    @Override
    public void learn() {
        learner.learn();
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Текущее время: " + time.format(formatter));
    }
}

public class Student9 {
   public static void main(String[] args) {
        Learner student = new StudentWithClock(new Student());
        student.learn();
    }
    
}
