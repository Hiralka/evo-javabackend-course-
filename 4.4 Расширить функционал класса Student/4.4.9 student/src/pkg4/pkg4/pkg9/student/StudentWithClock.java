/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg4.pkg4.pkg9.student;

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
