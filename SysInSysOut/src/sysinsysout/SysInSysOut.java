/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sysinsysout;

/**
 *
 * @author hiraru
 */
import java.util.Scanner;
public class SysInSysOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Как тебя зовут?");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.printf("Привет, %s \n", name);
        in.close();
        // TODO code application logic here
    }
    
}
