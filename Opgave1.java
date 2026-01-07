import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Opgave1 {
    static void Pytagoras(String inTal){
        try {
            String[] myArray = inTal.split(" ");
            double[] katete = new double[myArray.length];
                try{
                    katete = Arrays.stream(myArray)
                            .mapToDouble(Double::parseDouble)
                            .toArray();
                    }
                catch(Exception e){
                        System.out.print("\n\r Prøv at skrive 2 tal istedet \n\r");

                }
            if ((katete[0]>=0 && katete[1]>=0)){   

                double hypotenus = Math.sqrt(Math.pow(katete[0], 2) + Math.pow(katete[1], 2));
                double areal = 0.5*katete[0]*katete[1];
                
                System.out.print("Hypotenuse:"+hypotenus);
                System.out.print("\n\r");
                System.out.print("Areal:"+areal);
                System.out.print("\n\r");

            }
            else
            {
                System.out.print("\n\r Input skal være positive tal.\n\r");
            }
            }
            catch(Exception e)
                {
                    System.out.print("\n\r Noget er gået galt\n\r Har du husket at skrive 2 tal?\n\r" );
                };
            
            
    }
    public static void main(String[] args) {
        //Pytagoras("12 80");
        System.out.print("Skriv længden på dine kateter med '.' som seperator mellem decimal og heltal. \n\r Seperer de 2 længder med et mellemrum\n\r");
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        Pytagoras(s1);
        s.close();
    }
    
    
}

