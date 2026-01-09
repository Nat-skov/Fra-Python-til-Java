import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Opgave6 extends JFrame implements ActionListener {


        public JButton btn[]; // Erklærer btn som et array af JButton instanser
        public String nummber;
        public Socket sock;
        public Scanner netin;
        public PrintWriter netout;
        public void Connect(){
            try {
            Socket sock = Socket("34302.cyberteknologi.dk",1060);
            Scanner netin =  Scanner(sock.getInputStream());
            PrintWriter netout = PrintWriter(sock.getOutputStream());
            }
            catch(Exception h){
                System.out.println("sdjfj");
            }
        }
        public Opgave6 () {
        //Socket sock = main.sock;;
        Connect();
        //Scanner pIn = new Scanner(System.in);
        btn = new JButton[9]; // Opretter arrayet men ikke JButton instanserne endnu
        for (int i = 0; i < 9; i++) {
        btn[i] = new JButton(String.valueOf(i)); // Opretter instanserne af JButton men uden tekst
        btn[i].addActionListener(this);
        getContentPane().add(btn[i]);
        }
            
        getContentPane().setLayout(new GridLayout(0,1));
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0,3));
        for (int i = 0; i<9;i++){
            toolbar.add(btn[i]);
        }
        getContentPane().add(toolbar);
        }

        public void actionPerformed(ActionEvent e) {
            //System.out.print("askhhb");
            //Kode der håndterer events
            try{
            nummber = e.getActionCommand();
            //System.out.println(nummber);
            netout.print(nummber+"\r\n");
            netout.flush();
            
            }
            catch(Exception d){
                System.out.print("aaaaa");
            }

        }
        


        public void Updater(String s){
            String[] boardArray = s.split("");

            for (int i = 0; i<9;i++){
            btn[i].setText(boardArray[i]);

        }}
        public static void main(String[] args) {
            try {
                

                Opgave6 window = new Opgave6();
                window.setTitle("Celcius til Farenhite og tilbage.");
                window.setSize(160, 160);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
                window.Connect();
                String textline = window.netin.nextLine(); 
                System.out.print(textline+"\r\n");
                String Board = window.netin.nextLine();
                window.Updater(Board.substring(9, 18));
                System.out.println(window.netin.nextLine()+"\r\n");
                window.netout.print(window.nummber+"\r\n");
                
                boolean gameActive = true;
                while (gameActive) {
                    String pInput = window.nummber;
                    window.netout.print(pInput+"\r\n");
                    window.netout.flush();
                    String firstMessage = window.netin.nextLine(); 
                    String board = firstMessage.substring(9, 18);

                    String secondMessage = window.netin.nextLine();
                    if (secondMessage.endsWith("WINS")) {
                        window.Updater(board);
                        System.out.print(secondMessage+"\r\n");
                        gameActive = false;
                        System.out.println("Spillet er færdigt.\r\n");
                        break; 
                    } else if (firstMessage.startsWith("ILLEGAL")) {
                        System.out.print("Det må man ikke.\r\n");
                        System.out.print(secondMessage+"\r\n"); 
                        continue;
                    } else if (firstMessage.startsWith("BOARD IS")){
                        window.Updater(board);
                        System.out.print(secondMessage+"\r\n"); 
                    } else {
                        System.out.print("????");
                        gameActive = false;
                    } 
                }
                window.netin.close();
                window.netout.close();
                window.sock.close();    
                
              
            }
            
            catch (Exception e) {
            System.out.println("ahsfwysaf");
            
            }
        
            
            
        }
    
}
