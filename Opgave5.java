import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//public class Opgave5 {
    public class Opgave5 extends JFrame implements ActionListener {
        public JButton buttonCel;
        public JButton buttonFar;
        public JTextField textCel;
        public JTextField textFar;
        public Opgave5() { // Klassens constructor
            buttonCel = new JButton("Celsius");
            buttonFar = new JButton("Farenhite");
            buttonCel.addActionListener(this);
            buttonFar.addActionListener(this);
            textCel = new JTextField(null);
            textFar = new JTextField(null);

            //Kode der initialiserer de grafiske elementer i vinduet.
            // Set layout på hovedvindue - (0,2) betyder to kolonner og så mange rækker som nødvendigt
        getContentPane().setLayout(new GridLayout(0,2));
        // Lav et panel (komponent af type JPanel) til at holde et antal buttons der er initialiseret tidligere
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0,1));
        toolbar.add(buttonCel);   
        toolbar.add(buttonFar);
        JPanel text = new JPanel();
        text.setLayout(new GridLayout(0,1));
        text.add(textCel);
        text.add(textFar);
        // Endelig tilføj panel til hovedvindue
        getContentPane().add(toolbar);
        getContentPane().add(text);
        }
        public void actionPerformed(ActionEvent e) {
            //System.out.print("askhhb");
            //Kode der håndterer events
            try {
                double celc = 0;
                double fare = 0;

                if (e.getSource() == buttonCel){
                    celc = Double.parseDouble(textCel.getText());
                    textFar.setText(String.valueOf((celc*1.8)+32));
                }
                else{
                    fare = Double.parseDouble(textFar.getText());
                    textCel.setText(String.valueOf((fare-32)/1.8));
                }
            //System.out.println(fare + celc);
            } catch (Exception g) {
                System.out.print("Husk kun at skrive tal.");
                JOptionPane.showMessageDialog(null, "Husk kun at skrive tal.");
            }

        }
        public static void main(String[] args) {
            Opgave5 window = new Opgave5();
            window.setTitle("Celcius til Farenhite og tilbage.");
            window.setSize(160, 160);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
        }
    }
//}
