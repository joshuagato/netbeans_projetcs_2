package usingexceptions;

//try...catch...finally exception handling mechanism 

public class UsingExceptions {

    
    public static void main(String[] args) {
        
        try{
            throwException();
        }
        catch(Exception exception){
            System.err.println("Exception handled in main");
        }
        doesNotThrowException();
    }
    
    public static void throwException() throws Exception{
        try{
            System.out.println("Method throwException");
            throw new Exception();  //generate exception
        }
        catch(Exception exception){
            System.err.println("Exception handled in method throwException");
            throw exception; //rethrow for further processing
            
            //code here would not be reached; would cause compilation errors
        }
        finally{  //excecutes regardless of what occurs in try...catch
            System.err.println("Finally executed in throwException");
        } //end finally
    }
    
    public static void doesNotThrowException(){
        try{
            System.out.println("Method doesNotThrowExceptions");
        }
        catch(Exception exception){
            System.err.println(exception);
        }
        finally{
            System.err.println("Finally executed in doesNotThrowException");
        }
        System.out.println("End of method doesNotThrowException");
    }
}
