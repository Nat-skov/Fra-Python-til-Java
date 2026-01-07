import java.io.File;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String args[]){
        
            System.out.print("Skriv navnet på tekstfilen, du vil have talt.\r\n");
            Scanner s = new Scanner(System.in);
            String file = s.nextLine();
            File myFile = new File(file);
            System.out.println(myFile.exists());
       
        System.out.println();
        try{
        if (myFile.exists()){
            System.out.print("Filen er fundet, went venligst\n\r");
            Scanner fil_in = new Scanner(myFile);
            int words = 0;
            while (fil_in.hasNextLine()) {
                String txtline = fil_in.nextLine();
                String trim = txtline.trim();
                int wordsLine = 0;
                if (trim.isEmpty()){
                    wordsLine = 0;
                }
                else{
                    wordsLine = trim.split(" ").length; 
                }
                words = words + wordsLine;
                }
            System.out.println("Antal ord:"+words+"\r\n");
            if (words == 0){
                System.out.print("Er du sikker på at det var en .txt fil?\n\r");
            }
            fil_in.close();
            
        }
        else{
            System.out.print("Filen kunne ikke findes, prøv at skrive mere af fil vejen.\n\r");
        }
        }
        catch(Exception e){
            System.out.print("aaaaaasfahfugea\n\r");
        }
        s.close();
    }
}