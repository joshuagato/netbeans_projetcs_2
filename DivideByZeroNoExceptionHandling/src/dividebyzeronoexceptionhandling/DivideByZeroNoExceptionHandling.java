package dividebyzeronoexceptionhandling;

import java.util.Scanner;

public class DivideByZeroNoExceptionHandling {
    
    private static int quotient(int numerator, int denominator){
        
        return numerator / denominator;  //possible division by zero
     
    }

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);  //scanner for input
        
        System.out.print("Enter numerator: ");
        int numerator = scanner.nextInt();
        
        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();
        
        int result = quotient(numerator, denominator);
        System.out.printf("\nResult: %d / %d = %d\n", numerator, denominator, result);
        
    }
    
}
