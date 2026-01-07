import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Opgave3
 {
    public static void PrintBoard(String s){
        
        String[] boardArray = s.split("");
        System.out.print("+---+---+---+\r\n");
        System.out.print("| "+boardArray[0]+" | "+boardArray[1]+" | "+boardArray[2]+" |\r\n");
        System.out.print("+---+---+---+\r\n");
        System.out.print("| "+boardArray[3]+" | "+boardArray[4]+" | "+boardArray[5]+" |\r\n");
        System.out.print("+---+---+---+\r\n");
        System.out.print("| "+boardArray[6]+" | "+boardArray[7]+" | "+boardArray[8]+" |\r\n");
        System.out.print("+---+---+---+\r\n");
        return;
    }
    public static void main(String[] args) {
        try{
        Socket sock = new Socket("34302.cyberteknologi.dk",1060);

        Scanner netin = new Scanner(sock.getInputStream());
        PrintWriter netout = new PrintWriter(sock.getOutputStream());
        Scanner pIn = new Scanner(System.in);
    
        String textline = netin.nextLine(); 
        System.out.print(textline+"\r\n");
        String Board = netin.nextLine();
        PrintBoard(Board.substring(9, 18));
        System.out.println(netin.nextLine()+"\r\n");

        boolean gameActive = true;
        while (gameActive) {
            String pInput = pIn.nextLine();
            netout.print(pInput+"\r\n");
            netout.flush();
            String firstMessage = netin.nextLine(); 
            String board = firstMessage.substring(9, 18);

            String secondMessage = netin.nextLine();
            if (secondMessage.endsWith("WINS")) {
                PrintBoard(board);
                System.out.print(secondMessage+"\r\n");
                gameActive = false;
                System.out.println("Spillet er færdigt.\r\n");
                break; 
            } else if (firstMessage.startsWith("ILLEGAL")) {
                System.out.print("Det må man ikke.\r\n");
                System.out.print(secondMessage+"\r\n"); 
                continue;
            } else if (firstMessage.startsWith("BOARD IS")){
                PrintBoard(board);
                System.out.print(secondMessage+"\r\n"); 
            } else {
                System.out.print("????");
                gameActive = false;
            }    
        }
        netin.close();
        pIn.close();
        sock.close();

        }
        catch (Exception e)
        {
            System.out.println("Spillet er ovre");
           
        }
    }
}
