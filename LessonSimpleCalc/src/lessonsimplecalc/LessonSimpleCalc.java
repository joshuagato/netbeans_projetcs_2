package lessonsimplecalc;

import java.util.Scanner;

public class LessonSimpleCalc {   
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //LessonDisplay display = new LessonDisplay();
        
        System.out.print("Enter first interger: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second integer: ");
        int num2 = sc.nextInt();
      
         //answer;
        
        int answer = num1 + num2;
        System.out.println("The sum is: " + answer);
    }
    
}
