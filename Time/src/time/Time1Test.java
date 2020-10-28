package time;



public class Time1Test {

    
    
    public static void main(String[] args) {
        
        //Create and initialize time1 object
        Time1 time = new Time1();  //Invokes Time1 constructor
        
        //Output string representation of the time
        System.out.print("The initial universal-time is: ");
        System.out.println(time.toUniversalString());
        System.out.print("The initial standard time is: ");
        System.out.println(time.toString());
        System.out.println(); //Output a blank line
        
        //Change time and output update time
        time.setTime(13,27,6);
        System.out.print("The initial universal-time is: ");
        System.out.println(time.toUniversalString());
        System.out.print("The initial standard time is: ");
        System.out.println(time.toString());
        System.out.println(); //Output a blank line
        
        //Attempt to set time with invalid values
        try{
            time.setTime(99,99,99);  //All values out of range
        }
        catch(IllegalArgumentException k){
             System.out.printf("Exception: %s\n\n", k.getMessage());
        }
        
        //Display time after attempt to display invalid values
        System.out.println("After attempting invalid settings");
        System.out.print("universal time: ");
        System.out.println(time.toUniversalString());
        System.out.print("standard time: ");
        System.out.println(time.toString());
        
    }
    
}
