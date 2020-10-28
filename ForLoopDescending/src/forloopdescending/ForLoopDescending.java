package forloopdescending;


public class ForLoopDescending {

    
    public static void main(String[] args) {
        
        for (int x=5; x>=1; x--){
            
            for (int y=1; y<=x; y++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
    
}
