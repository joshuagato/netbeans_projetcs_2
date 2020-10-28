package nestedforloop3;


public class NestedForLoop3 {

    
    public static void main(String[] args) {
        
        for (int x=5; x>=1; x--){
            for(int y=x; y<=5; y++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
