package lessondisplay;

import java.util.Scanner;


public class LessonDisplay {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        int sum = num1 + num2;
        
        System.out.println("The sum of the two numbers is: " + sum);
        //System.out.println("The Value of Sum is: " + num2);
        
    }
    
}
