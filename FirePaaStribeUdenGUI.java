import java.awt.Choice;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
//HUsk at træke 1 fra spiller move
public class FirePaaStribeUdenGUI {
    public static boolean StartOfGame(Scanner netin, PrintWriter netout){ 
    
        //boolean white = true;
        while (true) {

            System.out.print("AUFHHAF");
            netout.print("WELCOME TO FOUR-IN-A-ROW \r\nSELECT BLACK OR WHITE\r\n");
            String choice = netin.nextLine();

        if (choice == "WHITE") {
            boolean white = true;
            break;
        } else if (choice == "BLACK"){
            boolean white = false;
            break;
        } else {
            netout.print("ILLEGAL COLOR\r\n");
            netout.print("CHOSE BLACK OR WHITE\r\n");
            continue;
        }
        }
        return(white);

        ////////Send start beskeder og resolve forkerte valg

        /* 
        char[] mess = message.toCharArray();
        for(int i = 0; i < mess.length / 2; i++)
        {
            char temp = mess[i];
            mess[i] = mess[mess.length - i - 1];
            mess[mess.length - i - 1] = temp;
        }
        String newMessage = String.copyValueOf(mess);
        return(newMessage);
        */
    }

    public static ArrayList ServerMove(ArrayList[] board){

        if (board[0].size() < 6){
            board[0].add("s");
        }
        else if (board[1].size() < 6){
            board[1].add("s");
        }
        else if (board[2].size() < 6){
            board[2].add("s");
        }
        else if (board[3].size() < 6){
            board[3].add("s");
        }
        else if (board[4].size() < 6){
            board[4].add("s");
        }
        else if (board[5].size() < 6){
            board[5].add("s");
        }
        else if (board[6].size() < 6){
            board[6].add("s");
        }
        
        System.out.print(board);
        return(board);
    }

    public static void SendtBoard(ArrayList bor, PrintWriter netout, boolean ply){
        System.out.print("SendtBoard");
        ArrayList tempBoard;
        for (int i = 0; i < 6; i++) {
            for (ArrayList obj : bor) {
                try {
                    if (bor.get(obj).get(i) == "s"){
                        tempBoard.add("B");
                    }else if (bor.get(obj).get(i) == "s"){
                        tempBoard.add("W");
                    }    
                } catch (Exception e) {
                    tempBoard.add(".");
                }
            }
        }
        if(ply == false){
            for (int i = 0; i < tempBoard.length; i++) {
                if(tempBoard.get(i) == "B"){
                    tempBoard.set(i, "W");
                } else if(tempBoard.get(i) == "W"){
                  tempBoard.set(i, "B");
                } 
            }   
        }
        String listString = String.join(", ", tempBoard);
        netout.print("BOARD IS "+listString+"\r\n");
    }

    public static void WinnerCheck(ArrayList curBoard, PrintWriter netout) {
        //Cheker board udfra string 
        System.out.print("WinnerCheck");
        ArrayList tempBoard;
        for (int i = 0; i < 3; i++) {
            for (ArrayList obj : curBoard) { 
                    if (obj.get(i)==obj.get(i+1)==obj.get(i+2)==obj.get(i+3)){
                        if (obj.get(i) == "s"){
                            netout.print("SERVER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);
                        }
                        else { 
                            netout.print("PLAYER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);
                        }
                    }   
                    
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j< 4; j++) { 
                    if (curBoard.get(j).get(i)==curBoard.get(j+1).get(i)==curBoard.get(j+2).get(i)==curBoard.get(j+3).get(i)){
                        if (obj.get(i) == "s"){
                            netout.print("SERVER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);

                        }
                        else { 
                            netout.print("PLAYER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);

                        }
                    }   
                    
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 4; j++) { 
                    if (curBoard.get(j).get(i)==curBoard.get(j+1).get(i+1)==curBoard.get(j+2).get(i+2)==curBoard.get(j+3).get(i+3)){
                        if (obj.get(i) == "s"){
                            netout.print("SERVER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);

                        }
                        else { 
                            netout.print("PLAYER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);

                        }
                    }   
                    
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) { 
                    if (curBoard.get(j).get(i)==curBoard.get(j+1).get(i-1)==curBoard.get(j+2).get(i-2)==curBoard.get(j+3).get(i-3)){
                        if (obj.get(i) == "s"){
                            netout.print("SERVER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);

                        }
                        else { 
                            netout.print("PLAYER WINS\r\n");
                            netin.close();
                            sock.close();
                            System.exit(0);

                        }
                    }   
                    
            }
        }
    }

    public static void GameLoop(boolean ply, Scanner netin, PrintWriter netout){
        int i = 42; // teller ned til at boardet er fyldt, Husk at fjerne 1 for sort
        ArrayList board[];
        for (int j = 0; j < 7; j++) {
            ArrayList colon[];
            board[j] = colon;
        }
        //board = ServerMove(board);
        if (ply = false){
            board = ServerMove(board);
            i--;
            SendtBoard(board, netout, ply);
        }
        while ( i>0) {
            netout.print("YOUR TURN\r\n");
            int pMove = 0;
            try {
                pMove = Integer.valueOf(nullnetin.nextLine())-1;
            }
            catch (Exception noNumber){
                netout.print("ILLEGAL MOVE: SEND SINGEL DIGIT (1-7) FOR MOVE\r\n");
                continue;
            }
            if (pMove < 1 || pMove > 7){
                netout.print("ILLEGAL MOVE: COLUMN DOES NOT EXIST\r\n");
                continue;
            }
            if (size(board[pMove]) < 6){
                board[pMove].add("p");
                i--;
            }
            else {
                netout.print("ILLEGAL MOVE: COLUMN IS FULL\r\n");
                continue;
            }
            SendtBoard(board, netout, ply); 
            WinnerCheck(board, netout); //send string
            /// hvis 
        i--; 
        }
        netout.print("NOBODY WINS\r\n");
        netin.close();
        sock.close();
        System.exit(0);
        ////spil loop
        /// 
        /// tælller ned til at 
        /// 
        /// 
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
                boolean player = StartOfGame(netin,netout);
                GameLoop(player,netin,netout);

        /* 
                String textline = netin.nextLine(); 
                System.out.print(textline+"\r\n");
                System.out.println(Converter(textline));
                netout.print(Converter(textline));
                netout.flush();
            */
                netin.close();
                sock.close();

                
            }
            serversock.close();
        } catch (Exception e) {
            System.out.println("åhåh");
            System.exit(0);
        }
        
    }

    public static void main(String args[]){
        FirePaaStribeUdenGUI c = new FirePaaStribeUdenGUI();
        c.Conenct();
        
        //System.out.print(Converter("hej"));
    }
}
