package forloopascendingreverse;


public class ForLoopAscendingReverse {

    
    public static void main(String[] args) {
        
        for(int x=5; x>=1; x--){
            
            for(int y=5; y>=x; y--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
