package simplemd5example;


public class SimpleMD5Example {

    
    public static void main(String[] args) {
        String passwordToHash = "password";
        String generatedPassword = null;
        
        try{
            //Create messageDiagest instance for MD5
            MessageDigest md = MessageDiagest.getInstance();
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException){
            noSuchAlgorithmException.printStackTrace();
        }
        System.out.println(generatedPassword);
    }
    
}
