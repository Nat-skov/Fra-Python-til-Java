import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Opgave4Klient {
    public static void main(String[] args) {
        try{
        Socket sock = new Socket("localhost",1068);

        Scanner netin = new Scanner(sock.getInputStream());
        PrintWriter netout = new PrintWriter(sock.getOutputStream());
        Scanner pIn = new Scanner(System.in);
    
        String message = pIn.nextLine();
        netout.print(message+"\r\n");
        netout.flush();
        String firstmesage = netin.nextLine();
        System.out.print(firstmesage);
        /* 
        String textline = netin.nextLine(); 
        System.out.print(textline+"\r\n");
        String Board = netin.nextLine();
        PrintBoard(Board.substring(9, 18));
        System.out.println(netin.nextLine()+"\r\n");
*/
        netin.close();
        pIn.close();
        sock.close();

        }
        catch (Exception e)
        {
            System.out.println("Noget er gået galt");
           
        }
    }
}
