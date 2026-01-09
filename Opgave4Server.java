import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Opgave4Server {
    public static String Converter(String message){ //Virker
      
        char[] mess = message.toCharArray();
        for(int i = 0; i < mess.length / 2; i++)
        {
            char temp = mess[i];
            mess[i] = mess[mess.length - i - 1];
            mess[mess.length - i - 1] = temp;
        }
        String newMessage = String.copyValueOf(mess);
        return(newMessage);
        
    }

    public void Conenct() {
        //Converter("ehwfhfahrg");

        try {
            
            ServerSocket serversock = null; // Erklæring af en serversocket
            serversock = new ServerSocket(1068); // Server lytter på port 1068
            
            boolean serverAktiv = true; //så længe server skal acceptere forbindelser fra klienter
            while (serverAktiv == true) {
                Socket sock = serversock.accept(); // Blocking!
    
                Scanner netin = new Scanner(sock.getInputStream());
                PrintWriter netout = new PrintWriter(sock.getOutputStream());
                //Scanner pIn = new Scanner(System.in);
                
                String textline = netin.nextLine(); 
                System.out.print(textline+"\r\n");
                System.out.println(Converter(textline));
                netout.print(Converter(textline));
                netout.flush();
            
                //sock.close(); // Luk socket til klient efter brug
                netin.close();
                //pIn.close();
                sock.close();
                //serversocket.close(); // husk at fjerne

                
            }
            serversock.close();
        } catch (Exception e) {
            System.out.println("åhåh");
            System.exit(0);
        }
        
    }

    public static void main(String args[]){
        Opgave4Server c = new Opgave4Server();
        c.Conenct();
        
        //System.out.print(Converter("hej"));
    }
}
