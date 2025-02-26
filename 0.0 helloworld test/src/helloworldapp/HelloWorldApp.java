/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package helloworldapp;
//import java.util.stream.IntStream;
import java.util.Arrays;

/**
 *
 * @author hiraru*/

public class HelloWorldApp {
    
    public void pupsAge() {
        int age = 0;
        age = age + 9;
        System.out.println("Возраст пупса:" + age);
    }

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        
        HelloWorldApp test = new HelloWorldApp();
        test.pupsAge();
        int[] array = {1, 5, 6, -234, 25, 10, 0};
        System.out.println(Arrays.toString(array));
        // TODO code application logic here
    }
    
}
