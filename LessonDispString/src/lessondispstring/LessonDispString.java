package lessondispstring;

import java.util.Scanner;

public class LessonDispString {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter firstname: ");
        String firstname = sc.nextLine();
        
        System.out.print("Enter surname: ");
        String surname = sc.nextLine();
      
         
        System.out.println("Welcome, " + firstname + " " + surname);
        
    }
    
}
