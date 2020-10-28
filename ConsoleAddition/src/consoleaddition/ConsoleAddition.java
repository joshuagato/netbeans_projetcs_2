
package consoleaddition;

import java.util.Scanner;

public class ConsoleAddition {

    
    
    public static void main(String[] args) {
        int val = 1;

        while(val != 0){

                //Scanner sc;
                Scanner sc = new Scanner(System.in);

                System.out.println("");
                System.out.println("----------------------------------------------------------------");
                System.out.println("");

                System.out.print("Enter first number: ");
                int firstNumber = sc.nextInt();

                System.out.print("Enter second number: ");
                double secondNumber = sc.nextInt();

                double sum = firstNumber + secondNumber;
                System.out.println("The sum of " + firstNumber + " and " + secondNumber + " is " + sum);

                System.out.println("");
                System.out.println("----------------------------------------------------------------");
                System.out.println("");

                System.out.print("Do you wanna perform another addition? 'Yes=1' or 'No=0': ");
                val = sc.nextInt();

                if (val == 0){
                        System.out.println("");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("END OF PROGRAM!");
                }

        }
 
    }//end of method main
    
}// end of class ConsoleAddition
