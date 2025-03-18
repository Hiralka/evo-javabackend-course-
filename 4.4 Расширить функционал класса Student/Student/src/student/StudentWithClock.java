package student;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class StudentWithClock implements Learner {
    private final Learner learner;
    
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