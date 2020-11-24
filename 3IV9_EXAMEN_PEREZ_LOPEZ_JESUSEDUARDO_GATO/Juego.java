import java.awt.event.*;
import javax.swing.*;

public class Juego extends javax.swing.JFrame implements ActionListener{

    Casilla [][]TABLERO;
    int conta;

    public Juego(){
        
        conta = 0;
        TABLERO = new Casilla[3][3];

        for (int i=0; i<3; i++){

            for (int j=0; j<3; j++){

                TABLERO[i][j] = new Casilla();
                TABLERO[i][j].A.setBounds((i*100)+10, (j*100)+10, 100, 100);
                TABLERO[i][j].A.addActionListener(this);
                this.add(TABLERO[i][j].A);
            }
        }
    }

    public void actionPerformed(ActionEvent ae){
        
    }

}