package forloopdescendingreverse;


public class ForLoopDescendingReverse {

    
    public static void main(String[] args) {
        
        for (int x=1; x<=5; x++){
            
            for (int y=5; y>=x; y--){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
    
}
