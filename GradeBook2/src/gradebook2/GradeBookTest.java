package gradebook2;

import java.util.Scanner;

public class GradeBookTest {

    
    public static void main(String[] args) {
        //Create Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);
        
        //Create a GradeBook object and assign it to myGradeBook
        GradeBook myGradeBook = new GradeBook();
        
        //Prompt for and input course name
        System.out.print("Please input course name: ");
        String nameOfCourse = input.nextLine();  //Reads a line of text
        System.out.println();  //Outputs a blank line
        
        //Calls myGradeBook's displayMessage method and pass nameOfCouse as an argument
        myGradeBook.displayMessage(nameOfCourse);
    }
    
}
