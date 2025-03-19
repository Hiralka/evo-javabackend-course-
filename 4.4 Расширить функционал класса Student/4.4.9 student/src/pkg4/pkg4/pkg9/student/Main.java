package pkg4.pkg4.pkg9.student;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Learner student = new StudentWithClock(new Student());
        student.learn();
    }
    
}
