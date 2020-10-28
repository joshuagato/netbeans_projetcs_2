package lessonloopedcalculator;

import java.util.Scanner;

public class LessonLoopedCalculator {
    
    private static int addition(int x, int y){
        int sum = x + y;
        return sum;
    }

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        String stnl = "y";
        
        while(!stnl.equals("n")){
            
            if(stnl.equals("y")){
                
                System.out.print("Enter first integer: ");
                int num1 = sc.nextInt();

                System.out.print("Enter second integer: ");
                int num2 = sc.nextInt();

                int result = addition(num1, num2);

                System.out.println("Result: " + num1 + " + " + num2 + " = " + result);

                System.out.println();
                System.out.println();

                System.out.print("Would you like to perform another addition? Yes='y' No='n': " );
                stnl = sc2.nextLine();

                if(stnl.equals("n")){

                    System.out.println("------------------------END OF PROGRAM------------------------");
                }
                else if(!stnl.equals("y")){
                    System.out.println("You should press either 'y' or 'n'");
                    System.out.println("------------------------END OF PROGRAM------------------------");
                    System.exit(0);
                }
                else{
                    System.out.println();
                    System.out.println();
                }
                
            }
            
        }
        
        
    }
    
}
