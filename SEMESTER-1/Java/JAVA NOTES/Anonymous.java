/**
 * Anonymous Classes:- class without name called Anonymous Class.
 */

class Fruit{
    public void taste(){
        System.out.println("Sweet");  
    }    
}

interface M{
    //
}

public class Anonymous {


    public static void main(String [] args){
        Fruit f;
        f = new Fruit();

        String tastes[] = {"sweet", "sweet", "sour", "sweet"}; 

        for(String taste : tastes){
            if(taste == "sweet"){
                f.taste();                
            }
            else{
                new M(){
                    public void taste(){
                        System.out.println("sour");
                    }
                }.taste();
            }
        }
    }

}
