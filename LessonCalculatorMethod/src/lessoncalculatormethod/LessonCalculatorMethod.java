package lessoncalculatormethod;

import java.util.Scanner;
import java.util.InputMismatchException;

public class LessonCalculatorMethod {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean continueLoop = true;
        
        do{
            
            try{
                System.out.print("Enter first Integer: ");
                int num1 = sc.nextInt();

                System.out.print("Enter second Integer: ");
                int num2 = sc.nextInt();

                int result = multiply(num1, num2);
                
                System.out.printf("\nResult: %d X %d = %d\n", num1, num2, result);
                System.out.println(num1 + " X " + num2 + " = " + result);
                
                continueLoop = false;
            }
            
            catch(InputMismatchException inputMismatchException){
                System.err.printf("\nException: %s\n", inputMismatchException);
                sc.nextLine();  //discard input so user can try again
                System.out.println("You must enter integers. Please try again.\n");
            }
            
            //Remember that this exception is not applicable in this program since you can multiply a number by zero
            /*catch(ArithmeticException arithmeticException){
                System.err.printf("\nException: %s\n", arithmeticException);
                sc.nextLine();
                System.out.println("Zero is an invalid denominator. Please try again.\n");                
            }*/
            
         }while(continueLoop);
        
        
        
    }
    
        private static int multiply (int x, int y) throws ArithmeticException{
            int product = x * y;
            return product;
        }
    
}
