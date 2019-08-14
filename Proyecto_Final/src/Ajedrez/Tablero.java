
package Ajedrez;
import java.awt.Color;
import EntradaySalida.Archivo;
import static EntradaySalida.Archivo.Escribir;
import static EntradaySalida.Archivo.Leer;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame {


    public Tablero() {
        initComponents();
        setTitle("Ajedrez");
     
        setLocationRelativeTo(null);
        TableroAjedrez();
    }
    static Boton[][] JTBotones = new Boton[8][8];
    int x;
    int y;
    String nombre = "";
    public static Color Blanco = new Color(51, 51, 0);
    public static Color Negro = new Color(51, 0, 0);
    public ImageIcon TorreN = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\torre negra.png");
    public ImageIcon TorreB = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\torre blanca.png");
    public ImageIcon AlfilN = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\alfil negro.png");
    public ImageIcon AlfilB = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\alfil blanco.png");
    public ImageIcon CaballoN = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\caballo negro.png");
    public ImageIcon CaballoB = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\caballo blanco.png");
    public ImageIcon ReyN = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\rey negro.png");
    public ImageIcon ReyB = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\rey blanco.png");
    public ImageIcon ReinaN = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\reina negra.png");
    public ImageIcon ReinaB = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\reina blanca.png");
    public ImageIcon PeonN = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\peon negro.png");
    public ImageIcon PeonB = new ImageIcon("D:\\Proyecto_Final\\src\\Imagenes\\peon blanco.png");
   
    private void TableroAjedrez() {

        Tablero.setLayout(new GridLayout(8, 8));
        int count = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JTBotones[i][j] = new Boton();
                JTBotones[i][j].setSize(80, 80);
                if (count % 2 == 0) {
                    JTBotones[i][j].ColorBase(Negro);
                } else {
                    JTBotones[i][j].ColorBase(Blanco);
                }
                count++;
                ControlBotones control = new ControlBotones();
                JTBotones[i][j].addActionListener(control);
                Tablero.add(JTBotones[i][j]);
            }
            count++;
        }
        JTBotones[0][0].setIcon(TorreN);
        JTBotones[0][1].setIcon(CaballoN);
        JTBotones[0][2].setIcon(AlfilN);
        JTBotones[0][4].setIcon(ReyN);
        JTBotones[0][3].setIcon(ReinaN);
        JTBotones[0][5].setIcon(AlfilN);
        JTBotones[0][6].setIcon(CaballoN);
        JTBotones[0][7].setIcon(TorreN);
        JTBotones[7][0].setIcon(TorreB);
        JTBotones[7][1].setIcon(CaballoB);
        JTBotones[7][2].setIcon(AlfilB);
        JTBotones[7][4].setIcon(ReyB);
        JTBotones[7][3].setIcon(ReinaB);
        JTBotones[7][5].setIcon(AlfilB);
        JTBotones[7][6].setIcon(CaballoB);
        JTBotones[7][7].setIcon(TorreB);
        int inicio = 1;
        for (int j = 0; j < 8; j++) {
            JTBotones[inicio][j].setIcon(PeonN);
        }
        int fin = 6;
        for (int j = 0; j < 8; j++) {
            JTBotones[fin][j].setIcon(PeonB);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JTBotones[i][j].setEnabled(true);
            }
        }
        jReanudar.setEnabled(false);
        jGuardar.setEnabled(false);
        
    }
    public static ArrayList<String> Guardar = new ArrayList<String>();
    public class ControlBotones implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) {
             boolean encontrado = false;
            boolean encontrado2 = false;
            boolean encontrado4 = false;
            boolean encontrado5 = false;
            boolean listo1 = false;
            boolean turnoN = false;
            boolean turnoB = true;
            int pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;

            if (Turno.getBackground().equals(new Color(204, 153, 0))) {
                turnoN = false;
                turnoB = true;
            } else {
                turnoN = true;
                turnoB = false;
            }
            try {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (JTBotones[i][j].getBackground().equals(Color.RED) && JTBotones[i][j].isSelected()) {
                            pos3 = i;
                            pos4 = j;
                            int z = 0, v = 0;
                            int one = 0, three = 0;
                            String two = "", four = "";
                            if (i == 0) {
                                one = 8;
                            } else if (i == 1) {
                                one = 7;
                            } else if (i == 2) {
                                one = 6;
                            } else if (i == 3) {
                                one = 5;
                            } else if (i == 4) {
                                one = 4;
                            } else if (i == 5) {
                                one = 3;
                            } else if (i == 6) {
                                one = 2;
                            } else if (i == 7) {
                                one = 1;
                            }
                            if (j == 0) {
                                two = "A";
                            } else if (j == 1) {
                                two = "B";
                            } else if (j == 2) {
                                two = "C";
                            } else if (j == 3) {
                                two = "D";
                            } else if (j == 4) {
                                two = "E";
                            } else if (j == 5) {
                                two = "F";
                            } else if (j == 6) {
                                two = "G";
                            } else if (j == 7) {
                                two = "H";
                            }
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    if (JTBotones[k][l].isSelected()) {
                                        if (JTBotones[k][l].getIcon() != null) {
                                            if (k != i || l != j) {
                                                z = k;
                                                v = l;
                                                pos1 = k;
                                                pos2 = l;
                                                if (k == 0) {
                                                    three = 8;
                                                } else if (k == 1) {
                                                    three = 7;
                                                } else if (k == 2) {
                                                    three = 6;
                                                } else if (k == 3) {
                                                    three = 5;
                                                } else if (k == 4) {
                                                    three = 4;
                                                } else if (k == 5) {
                                                    three = 3;
                                                } else if (k == 6) {
                                                    three = 2;
                                                } else if (k == 7) {
                                                    three = 1;
                                                }
                                                if (l == 0) {
                                                    four = "A";
                                                } else if (l == 1) {
                                                    four = "B";
                                                } else if (l == 2) {
                                                    four = "C";
                                                } else if (l == 3) {
                                                    four = "D";
                                                } else if (l == 4) {
                                                    four = "E";
                                                } else if (l == 5) {
                                                    four = "F";
                                                } else if (l == 6) {
                                                    four = "G";
                                                } else if (l == 7) {
                                                    four = "H";
                                                }
                                                listo1 = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (listo1) {
                                    listo1 = false;
                                    break;
                                }
                            }
                            if (Turno.getBackground().equals(new Color(204, 153, 0))) {
                                Turno.setBackground(Color.black);
                            } else {
                                Turno.setBackground(new Color(204, 153, 0));
                            }
                            if (JTBotones[z][v].getIcon().equals(PeonN)) {
                                if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Negro comió a Peon Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Negro comió a Torre Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Negro comió a Alfil Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Negro comió a Caballo Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Negro comió a Reina Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(PeonB)) {
                                if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Blanco comió a Peon Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Blanco comió a Torre Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Blanco comió a Alfil Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Blanco comió a Caballo Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                    Movimientos.setText(Movimientos.getText() + "Peon Blanco comió a Reina Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(CaballoN)) {
                                if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Negro comió a Peon Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Negro comió a Torre Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Negro comió a Alfil Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Negro comió a Caballo Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Negro comió a Reina Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(CaballoB)) {
                                if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Blanco comió a Peon Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Blanco comió a Torre Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Blanco comió a Alfil Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Blanco comió a Caballo Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                    Movimientos.setText(Movimientos.getText() + "Caballo Blanco comió a Reina Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(AlfilN)) {
                                if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Negro comió a Peon Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Negro comió a Torre Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Negro comió a Alfil Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Negro comió a Caballo Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Negro comió a Reina Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(AlfilB)) {
                                if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Blanco comió a Peon Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Blanco comió a Torre Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Blanco comió a Alfil Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Blanco comió a Caballo Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                    Movimientos.setText(Movimientos.getText() + "Alfil Blanco comió a Reina Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(ReinaN)) {
                                if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Negra comió a Peon Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Negra comió a Torre Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Negra comió a Alfil Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Negra comió a Caballo Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Negra comió a Reina Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(ReinaB)) {
                                if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Blanca comió a Peon Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Blanca comió a Torre Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Blanca comió a Alfil Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Blanca comió a Caballo Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                    Movimientos.setText(Movimientos.getText() + "Reina Blanca comió a Reina Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(TorreN)) {
                                if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Negra comió a Peon Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Negra comió a Torre Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Negra comió a Alfil Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Negra comió a Caballo Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Negra comió a Reina Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(TorreB)) {
                                if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Blanca comió a Peon Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Blanca comió a Torre Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Blanca comió a Alfil Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Blanca comió a Caballo Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                    Movimientos.setText(Movimientos.getText() + "Torre Blanca comió a Reina Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(ReyN)) {
                                if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Negro comió a Peon Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Negro comió a Torre Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Negro comió a Alfil Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Negro comió a Caballo Blanco de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Negro comió a Reina Blanca de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            } else if (JTBotones[z][v].getIcon().equals(ReyB)) {
                                if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Blanco comió a Peon Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Blanco comió a Torre Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Blanco comió a Alfil Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Blanco comió a Caballo Negro de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                    Movimientos.setText(Movimientos.getText() + "Rey Blanco comió a Reina Negra de (" + three + ", " + four + ")" + " hasta " + "(" + one + ", " + two + ")\n");
                                }
                            }
                            JTBotones[i][j].setIcon(JTBotones[z][v].getIcon());
                            JTBotones[z][v].setIcon(null);
                            if (i == 0 && JTBotones[i][j].getIcon().equals(PeonB)) {
                                JTBotones[i][j].setIcon(ReinaB);
                            }
                            if (i == 7 && JTBotones[i][j].getIcon().equals(PeonN)) {
                                JTBotones[i][j].setIcon(ReinaN);
                            }
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 8; l++) {
                                    JTBotones[k][l].Selection(false);
                                    JTBotones[k][l].setSelected(false);
                                }
                            }
                            encontrado5 = true;
                            break;
                        }
                    }
                    if (encontrado5) {
                        encontrado5 = false;
                        break;
                    }
                }
            } catch (Exception ae) {
            }

            try {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (JTBotones[i][j].getIcon() != null) {
                            if (JTBotones[i][j].isSelected()) {
                                if (JTBotones[i][j].getIcon().equals(PeonN) && turnoN == true) {
                                    if (JTBotones[i + 1][j].getIcon() == null) {
                                        JTBotones[i + 1][j].Selection(true);
                                    }
                                    if (i == 1 && JTBotones[i + 1][j].getIcon() == null && JTBotones[i + 2][j].getIcon() == null) {
                                        JTBotones[i + 2][j].Selection(true);
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(ReyB)) {
                                                JTBotones[i + 2][j].Selection(false);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(ReyB)) {
                                                JTBotones[i + 2][j].Selection(false);
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    try {
                                        if (JTBotones[i + 1][j - 1].getIcon().equals(PeonB) || JTBotones[i + 1][j - 1].getIcon().equals(TorreB)
                                                || JTBotones[i + 1][j - 1].getIcon().equals(AlfilB) || JTBotones[i + 1][j - 1].getIcon().equals(ReinaB)
                                                || JTBotones[i + 1][j - 1].getIcon().equals(CaballoB)) {
                                            JTBotones[i + 1][j - 1].Ataque(true);
                                        }
                                    } catch (Exception ae) {
                                    }
                                    try {
                                        if (JTBotones[i + 1][j + 1].getIcon().equals(PeonB) || JTBotones[i + 1][j + 1].getIcon().equals(TorreB)
                                                || JTBotones[i + 1][j + 1].getIcon().equals(AlfilB) || JTBotones[i + 1][j + 1].getIcon().equals(ReinaB)
                                                || JTBotones[i + 1][j + 1].getIcon().equals(CaballoB)) {
                                            JTBotones[i + 1][j + 1].Ataque(true);
                                        }
                                    } catch (Exception ae) {
                                    }
                                    try {
                                        if (JTBotones[i + 1][j - 1].getIcon().equals(ReyB) || JTBotones[i + 1][j + 1].getIcon().equals(ReyB)) {
                                            JTBotones[i + 1][j - 1].Selection(false);
                                            JTBotones[i + 1][j + 1].Selection(false);
                                            JTBotones[i + 1][j].Selection(false);
                                        }
                                    } catch (Exception ae) {
                                    }
                                    encontrado = true;
                                } else if (JTBotones[i][j].getIcon().equals(PeonB) && turnoB == true) {
                                    if (JTBotones[i - 1][j].getIcon() == null) {
                                        JTBotones[i - 1][j].Selection(true);
                                    }
                                    if (i == 6 && JTBotones[i - 1][j].getIcon() == null && JTBotones[i - 2][j].getIcon() == null) {
                                        JTBotones[i - 2][j].Selection(true);
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(ReyN)) {
                                                JTBotones[i - 2][j].Selection(false);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(ReyN)) {
                                                JTBotones[i - 2][j].Selection(false);
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    try {
                                        if (JTBotones[i - 1][j - 1].getIcon().equals(PeonN) || JTBotones[i - 1][j - 1].getIcon().equals(TorreN)
                                                || JTBotones[i - 1][j - 1].getIcon().equals(AlfilN) || JTBotones[i - 1][j - 1].getIcon().equals(ReinaN)
                                                || JTBotones[i - 1][j - 1].getIcon().equals(CaballoN)) {
                                            JTBotones[i - 1][j - 1].Ataque(true);
                                        }
                                    } catch (Exception ae) {
                                    }
                                    try {
                                        if (JTBotones[i - 1][j + 1].getIcon().equals(PeonN) || JTBotones[i - 1][j + 1].getIcon().equals(TorreN)
                                                || JTBotones[i - 1][j + 1].getIcon().equals(AlfilN) || JTBotones[i - 1][j + 1].getIcon().equals(ReinaN)
                                                || JTBotones[i - 1][j + 1].getIcon().equals(CaballoN)) {
                                            JTBotones[i - 1][j + 1].Ataque(true);
                                        }
                                    } catch (Exception ae) {
                                    }
                                    try {
                                        if (JTBotones[i - 1][j - 1].getIcon().equals(ReyN) || JTBotones[i - 1][j + 1].getIcon().equals(ReyN)) {
                                            JTBotones[i - 1][j - 1].Selection(false);
                                            JTBotones[i - 1][j + 1].Selection(false);
                                            JTBotones[i - 1][j].Selection(false);
                                        }
                                    } catch (Exception ae) {
                                    }
                                    encontrado = true;
                                } else if (JTBotones[i][j].getIcon().equals(TorreN) && turnoN == true) {
                                    try {
                                        for (int k = i - 1; k >= 0; k--) {
                                            if (JTBotones[k][j].getIcon() == null) {
                                                JTBotones[k][j].Selection(true);
                                            } else {
                                                if (JTBotones[k][j].getIcon().equals(PeonB) || JTBotones[k][j].getIcon().equals(TorreB)
                                                        || JTBotones[k][j].getIcon().equals(AlfilB) || JTBotones[k][j].getIcon().equals(ReinaB)
                                                        || JTBotones[k][j].getIcon().equals(CaballoB)) {
                                                    JTBotones[k][j].Ataque(true);
                                                }
                                                if (JTBotones[k][j].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                                break;
                                            }
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = i + 1; k <= 7; k++) {
                                                if (JTBotones[k][j].getIcon() == null) {
                                                    JTBotones[k][j].Selection(true);
                                                } else {
                                                    if (JTBotones[k][j].getIcon().equals(PeonB) || JTBotones[k][j].getIcon().equals(TorreB)
                                                            || JTBotones[k][j].getIcon().equals(AlfilB) || JTBotones[k][j].getIcon().equals(ReinaB)
                                                            || JTBotones[k][j].getIcon().equals(CaballoB)) {
                                                        JTBotones[k][j].Ataque(true);
                                                    }
                                                    if (JTBotones[k][j].getIcon().equals(ReyB)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j - 1; k >= 0; k--) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonB) || JTBotones[i][k].getIcon().equals(TorreB)
                                                            || JTBotones[i][k].getIcon().equals(AlfilB) || JTBotones[i][k].getIcon().equals(ReinaB)
                                                            || JTBotones[i][k].getIcon().equals(CaballoB)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyB)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j + 1; k <= 7; k++) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonB) || JTBotones[i][k].getIcon().equals(TorreB)
                                                            || JTBotones[i][k].getIcon().equals(AlfilB) || JTBotones[i][k].getIcon().equals(ReinaB)
                                                            || JTBotones[i][k].getIcon().equals(CaballoB)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyB)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(TorreB) && turnoB == true) {
                                    try {
                                        for (int k = i - 1; k >= 0; k--) {
                                            if (JTBotones[k][j].getIcon() == null) {
                                                JTBotones[k][j].Selection(true);
                                            } else {
                                                if (JTBotones[k][j].getIcon().equals(PeonN) || JTBotones[k][j].getIcon().equals(TorreN)
                                                        || JTBotones[k][j].getIcon().equals(AlfilN) || JTBotones[k][j].getIcon().equals(ReinaN)
                                                        || JTBotones[k][j].getIcon().equals(CaballoN)) {
                                                    JTBotones[k][j].Ataque(true);
                                                }
                                                if (JTBotones[k][j].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                                break;
                                            }
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = i + 1; k <= 7; k++) {
                                                if (JTBotones[k][j].getIcon() == null) {
                                                    JTBotones[k][j].Selection(true);
                                                } else {
                                                    if (JTBotones[k][j].getIcon().equals(PeonN) || JTBotones[k][j].getIcon().equals(TorreN)
                                                            || JTBotones[k][j].getIcon().equals(AlfilN) || JTBotones[k][j].getIcon().equals(ReinaN)
                                                            || JTBotones[k][j].getIcon().equals(CaballoN)) {
                                                        JTBotones[k][j].Ataque(true);
                                                    }
                                                    if (JTBotones[k][j].getIcon().equals(ReyN)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j - 1; k >= 0; k--) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonN) || JTBotones[i][k].getIcon().equals(TorreN)
                                                            || JTBotones[i][k].getIcon().equals(AlfilN) || JTBotones[i][k].getIcon().equals(ReinaN)
                                                            || JTBotones[i][k].getIcon().equals(CaballoN)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyN)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j + 1; k <= 7; k++) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonN) || JTBotones[i][k].getIcon().equals(TorreN)
                                                            || JTBotones[i][k].getIcon().equals(AlfilN) || JTBotones[i][k].getIcon().equals(ReinaN)
                                                            || JTBotones[i][k].getIcon().equals(CaballoN)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyN)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(CaballoN) && turnoN == true) {
                                    try {
                                        if (JTBotones[i - 2][j - 1].getIcon() == null) {
                                            JTBotones[i - 2][j - 1].Selection(true);
                                        } else {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(PeonB) || JTBotones[i - 2][j - 1].getIcon().equals(TorreB)
                                                    || JTBotones[i - 2][j - 1].getIcon().equals(AlfilB) || JTBotones[i - 2][j - 1].getIcon().equals(ReinaB)
                                                    || JTBotones[i - 2][j - 1].getIcon().equals(CaballoB)) {
                                                JTBotones[i - 2][j - 1].Ataque(true);
                                            }
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int m = 0; m < 8; m++) {
                                                        JTBotones[l][m].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon() == null) {
                                                JTBotones[i - 2][j + 1].Selection(true);
                                            } else {
                                                if (JTBotones[i - 2][j + 1].getIcon().equals(PeonB) || JTBotones[i - 2][j + 1].getIcon().equals(TorreB)
                                                        || JTBotones[i - 2][j + 1].getIcon().equals(AlfilB) || JTBotones[i - 2][j + 1].getIcon().equals(ReinaB)
                                                        || JTBotones[i - 2][j + 1].getIcon().equals(CaballoB)) {
                                                    JTBotones[i - 2][j + 1].Ataque(true);
                                                }
                                                if (JTBotones[i - 2][j + 1].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon() == null) {
                                                JTBotones[i - 1][j - 2].Selection(true);
                                            } else {
                                                if (JTBotones[i - 1][j - 2].getIcon().equals(PeonB) || JTBotones[i - 1][j - 2].getIcon().equals(TorreB)
                                                        || JTBotones[i - 1][j - 2].getIcon().equals(AlfilB) || JTBotones[i - 1][j - 2].getIcon().equals(ReinaB)
                                                        || JTBotones[i - 1][j - 2].getIcon().equals(CaballoB)) {
                                                    JTBotones[i - 1][j - 2].Ataque(true);
                                                }
                                                if (JTBotones[i - 1][j - 2].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon() == null) {
                                                JTBotones[i - 1][j + 2].Selection(true);
                                            } else {
                                                if (JTBotones[i - 1][j + 2].getIcon().equals(PeonB) || JTBotones[i - 1][j + 2].getIcon().equals(TorreB)
                                                        || JTBotones[i - 1][j + 2].getIcon().equals(AlfilB) || JTBotones[i - 1][j + 2].getIcon().equals(ReinaB)
                                                        || JTBotones[i - 1][j + 2].getIcon().equals(CaballoB)) {
                                                    JTBotones[i - 1][j + 2].Ataque(true);
                                                }
                                                if (JTBotones[i - 1][j + 2].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon() == null) {
                                                JTBotones[i + 1][j - 2].Selection(true);
                                            } else {
                                                if (JTBotones[i + 1][j - 2].getIcon().equals(PeonB) || JTBotones[i + 1][j - 2].getIcon().equals(TorreB)
                                                        || JTBotones[i + 1][j - 2].getIcon().equals(AlfilB) || JTBotones[i + 1][j - 2].getIcon().equals(ReinaB)
                                                        || JTBotones[i + 1][j - 2].getIcon().equals(CaballoB)) {
                                                    JTBotones[i + 1][j - 2].Ataque(true);
                                                }
                                                if (JTBotones[i + 1][j - 2].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon() == null) {
                                                JTBotones[i + 1][j + 2].Selection(true);
                                            } else {
                                                if (JTBotones[i + 1][j + 2].getIcon().equals(PeonB) || JTBotones[i + 1][j + 2].getIcon().equals(TorreB)
                                                        || JTBotones[i + 1][j + 2].getIcon().equals(AlfilB) || JTBotones[i + 1][j + 2].getIcon().equals(ReinaB)
                                                        || JTBotones[i + 1][j + 2].getIcon().equals(CaballoB)) {
                                                    JTBotones[i + 1][j + 2].Ataque(true);
                                                }
                                                if (JTBotones[i + 1][j + 2].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon() == null) {
                                                JTBotones[i + 2][j - 1].Selection(true);
                                            } else {
                                                if (JTBotones[i + 2][j - 1].getIcon().equals(PeonB) || JTBotones[i + 2][j - 1].getIcon().equals(TorreB)
                                                        || JTBotones[i + 2][j - 1].getIcon().equals(AlfilB) || JTBotones[i + 2][j - 1].getIcon().equals(ReinaB)
                                                        || JTBotones[i + 2][j - 1].getIcon().equals(CaballoB)) {
                                                    JTBotones[i + 2][j - 1].Ataque(true);
                                                }
                                                if (JTBotones[i + 2][j - 1].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon() == null) {
                                                JTBotones[i + 2][j + 1].Selection(true);
                                            } else {
                                                if (JTBotones[i + 2][j + 1].getIcon().equals(PeonB) || JTBotones[i + 2][j + 1].getIcon().equals(TorreB)
                                                        || JTBotones[i + 2][j + 1].getIcon().equals(AlfilB) || JTBotones[i + 2][j + 1].getIcon().equals(ReinaB)
                                                        || JTBotones[i + 2][j + 1].getIcon().equals(CaballoB)) {
                                                    JTBotones[i + 2][j + 1].Ataque(true);
                                                }
                                                if (JTBotones[i + 2][j + 1].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(CaballoB) && turnoB == true) {
                                    try {
                                        if (JTBotones[i - 2][j - 1].getIcon() == null) {
                                            JTBotones[i - 2][j - 1].Selection(true);
                                        } else {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(PeonN) || JTBotones[i - 2][j - 1].getIcon().equals(TorreN)
                                                    || JTBotones[i - 2][j - 1].getIcon().equals(AlfilN) || JTBotones[i - 2][j - 1].getIcon().equals(ReinaN)
                                                    || JTBotones[i - 2][j - 1].getIcon().equals(CaballoN)) {
                                                JTBotones[i - 2][j - 1].Ataque(true);
                                            }
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int m = 0; m < 8; m++) {
                                                        JTBotones[l][m].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon() == null) {
                                                JTBotones[i - 2][j + 1].Selection(true);
                                            } else {
                                                if (JTBotones[i - 2][j + 1].getIcon().equals(PeonN) || JTBotones[i - 2][j + 1].getIcon().equals(TorreN)
                                                        || JTBotones[i - 2][j + 1].getIcon().equals(AlfilN) || JTBotones[i - 2][j + 1].getIcon().equals(ReinaN)
                                                        || JTBotones[i - 2][j + 1].getIcon().equals(CaballoN)) {
                                                    JTBotones[i - 2][j + 1].Ataque(true);
                                                }
                                                if (JTBotones[i - 2][j + 1].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon() == null) {
                                                JTBotones[i - 1][j - 2].Selection(true);
                                            } else {
                                                if (JTBotones[i - 1][j - 2].getIcon().equals(PeonN) || JTBotones[i - 1][j - 2].getIcon().equals(TorreN)
                                                        || JTBotones[i - 1][j - 2].getIcon().equals(AlfilN) || JTBotones[i - 1][j - 2].getIcon().equals(ReinaN)
                                                        || JTBotones[i - 1][j - 2].getIcon().equals(CaballoN)) {
                                                    JTBotones[i - 1][j - 2].Ataque(true);
                                                }
                                                if (JTBotones[i - 1][j - 2].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon() == null) {
                                                JTBotones[i - 1][j + 2].Selection(true);
                                            } else {
                                                if (JTBotones[i - 1][j + 2].getIcon().equals(PeonN) || JTBotones[i - 1][j + 2].getIcon().equals(TorreN)
                                                        || JTBotones[i - 1][j + 2].getIcon().equals(AlfilN) || JTBotones[i - 1][j + 2].getIcon().equals(ReinaN)
                                                        || JTBotones[i - 1][j + 2].getIcon().equals(CaballoN)) {
                                                    JTBotones[i - 1][j + 2].Ataque(true);
                                                }
                                                if (JTBotones[i - 1][j + 2].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon() == null) {
                                                JTBotones[i + 1][j - 2].Selection(true);
                                            } else {
                                                if (JTBotones[i + 1][j - 2].getIcon().equals(PeonN) || JTBotones[i + 1][j - 2].getIcon().equals(TorreN)
                                                        || JTBotones[i + 1][j - 2].getIcon().equals(AlfilN) || JTBotones[i + 1][j - 2].getIcon().equals(ReinaN)
                                                        || JTBotones[i + 1][j - 2].getIcon().equals(CaballoN)) {
                                                    JTBotones[i + 1][j - 2].Ataque(true);
                                                }
                                                if (JTBotones[i + 1][j - 2].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon() == null) {
                                                JTBotones[i + 1][j + 2].Selection(true);
                                            } else {
                                                if (JTBotones[i + 1][j + 2].getIcon().equals(PeonN) || JTBotones[i + 1][j + 2].getIcon().equals(TorreN)
                                                        || JTBotones[i + 1][j + 2].getIcon().equals(AlfilN) || JTBotones[i + 1][j + 2].getIcon().equals(ReinaN)
                                                        || JTBotones[i + 1][j + 2].getIcon().equals(CaballoN)) {
                                                    JTBotones[i + 1][j + 2].Ataque(true);
                                                }
                                                if (JTBotones[i + 1][j + 2].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon() == null) {
                                                JTBotones[i + 2][j - 1].Selection(true);
                                            } else {
                                                if (JTBotones[i + 2][j - 1].getIcon().equals(PeonN) || JTBotones[i + 2][j - 1].getIcon().equals(TorreN)
                                                        || JTBotones[i + 2][j - 1].getIcon().equals(AlfilN) || JTBotones[i + 2][j - 1].getIcon().equals(ReinaN)
                                                        || JTBotones[i + 2][j - 1].getIcon().equals(CaballoN)) {
                                                    JTBotones[i + 2][j - 1].Ataque(true);
                                                }
                                                if (JTBotones[i + 2][j - 1].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon() == null) {
                                                JTBotones[i + 2][j + 1].Selection(true);
                                            } else {
                                                if (JTBotones[i + 2][j + 1].getIcon().equals(PeonN) || JTBotones[i + 2][j + 1].getIcon().equals(TorreN)
                                                        || JTBotones[i + 2][j + 1].getIcon().equals(AlfilN) || JTBotones[i + 2][j + 1].getIcon().equals(ReinaN)
                                                        || JTBotones[i + 2][j + 1].getIcon().equals(CaballoN)) {
                                                    JTBotones[i + 2][j + 1].Ataque(true);
                                                }
                                                if (JTBotones[i + 2][j + 1].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(AlfilN) && turnoN == true) {
                                    try {
                                        int m = 1;
                                        while (JTBotones[i - m][j - m].getIcon() == null) {
                                            JTBotones[i - m][j - m].Selection(true);
                                            m++;
                                        }
                                        if (JTBotones[i - m][j - m].getIcon().equals(PeonB) || JTBotones[i - m][j - m].getIcon().equals(TorreB)
                                                || JTBotones[i - m][j - m].getIcon().equals(AlfilB) || JTBotones[i - m][j - m].getIcon().equals(ReinaB)
                                                || JTBotones[i - m][j - m].getIcon().equals(CaballoB)) {
                                            JTBotones[i - m][j - m].Ataque(true);
                                        }
                                        if (JTBotones[i - m][j - m].getIcon().equals(ReyB)) {
                                            for (int l = 0; l < 8; l++) {
                                                for (int n = 0; n < 8; n++) {
                                                    JTBotones[l][n].Selection(false);
                                                }
                                            }
                                            encontrado2 = true;
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i - m][j + m].getIcon() == null) {
                                                JTBotones[i - m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(PeonB) || JTBotones[i - m][j + m].getIcon().equals(TorreB)
                                                    || JTBotones[i - m][j + m].getIcon().equals(AlfilB) || JTBotones[i - m][j + m].getIcon().equals(ReinaB)
                                                    || JTBotones[i - m][j + m].getIcon().equals(CaballoB)) {
                                                JTBotones[i - m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j - m].getIcon() == null) {
                                                JTBotones[i + m][j - m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(PeonB) || JTBotones[i + m][j - m].getIcon().equals(TorreB)
                                                    || JTBotones[i + m][j - m].getIcon().equals(AlfilB) || JTBotones[i + m][j - m].getIcon().equals(ReinaB)
                                                    || JTBotones[i + m][j - m].getIcon().equals(CaballoB)) {
                                                JTBotones[i + m][j - m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j + m].getIcon() == null) {
                                                JTBotones[i + m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(PeonB) || JTBotones[i + m][j + m].getIcon().equals(TorreB)
                                                    || JTBotones[i + m][j + m].getIcon().equals(AlfilB) || JTBotones[i + m][j + m].getIcon().equals(ReinaB)
                                                    || JTBotones[i + m][j + m].getIcon().equals(CaballoB)) {
                                                JTBotones[i + m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(AlfilB) && turnoB == true) {
                                    try {
                                        int m = 1;
                                        while (JTBotones[i - m][j - m].getIcon() == null) {
                                            JTBotones[i - m][j - m].Selection(true);
                                            m++;
                                        }
                                        if (JTBotones[i - m][j - m].getIcon().equals(PeonN) || JTBotones[i - m][j - m].getIcon().equals(TorreN)
                                                || JTBotones[i - m][j - m].getIcon().equals(AlfilN) || JTBotones[i - m][j - m].getIcon().equals(ReinaN)
                                                || JTBotones[i - m][j - m].getIcon().equals(CaballoN)) {
                                            JTBotones[i - m][j - m].Ataque(true);
                                        }
                                        if (JTBotones[i - m][j - m].getIcon().equals(ReyN)) {
                                            for (int l = 0; l < 8; l++) {
                                                for (int n = 0; n < 8; n++) {
                                                    JTBotones[l][n].Selection(false);
                                                }
                                            }
                                            encontrado2 = true;
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i - m][j + m].getIcon() == null) {
                                                JTBotones[i - m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(PeonN) || JTBotones[i - m][j + m].getIcon().equals(TorreN)
                                                    || JTBotones[i - m][j + m].getIcon().equals(AlfilN) || JTBotones[i - m][j + m].getIcon().equals(ReinaN)
                                                    || JTBotones[i - m][j + m].getIcon().equals(CaballoN)) {
                                                JTBotones[i - m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j - m].getIcon() == null) {
                                                JTBotones[i + m][j - m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(PeonN) || JTBotones[i + m][j - m].getIcon().equals(TorreN)
                                                    || JTBotones[i + m][j - m].getIcon().equals(AlfilN) || JTBotones[i + m][j - m].getIcon().equals(ReinaN)
                                                    || JTBotones[i + m][j - m].getIcon().equals(CaballoN)) {
                                                JTBotones[i + m][j - m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j + m].getIcon() == null) {
                                                JTBotones[i + m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(PeonN) || JTBotones[i + m][j + m].getIcon().equals(TorreN)
                                                    || JTBotones[i + m][j + m].getIcon().equals(AlfilN) || JTBotones[i + m][j + m].getIcon().equals(ReinaN)
                                                    || JTBotones[i + m][j + m].getIcon().equals(CaballoN)) {
                                                JTBotones[i + m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(ReinaN) && turnoN == true) {
                                    try {
                                        for (int k = i - 1; k >= 0; k--) {
                                            if (JTBotones[k][j].getIcon() == null) {
                                                JTBotones[k][j].Selection(true);
                                            } else {
                                                if (JTBotones[k][j].getIcon().equals(PeonB) || JTBotones[k][j].getIcon().equals(TorreB)
                                                        || JTBotones[k][j].getIcon().equals(AlfilB) || JTBotones[k][j].getIcon().equals(ReinaB)
                                                        || JTBotones[k][j].getIcon().equals(CaballoB)) {
                                                    JTBotones[k][j].Ataque(true);
                                                }
                                                if (JTBotones[k][j].getIcon().equals(ReyB)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                                break;
                                            }
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = i + 1; k <= 7; k++) {
                                                if (JTBotones[k][j].getIcon() == null) {
                                                    JTBotones[k][j].Selection(true);
                                                } else {
                                                    if (JTBotones[k][j].getIcon().equals(PeonB) || JTBotones[k][j].getIcon().equals(TorreB)
                                                            || JTBotones[k][j].getIcon().equals(AlfilB) || JTBotones[k][j].getIcon().equals(ReinaB)
                                                            || JTBotones[k][j].getIcon().equals(CaballoB)) {
                                                        JTBotones[k][j].Ataque(true);
                                                    }
                                                    if (JTBotones[k][j].getIcon().equals(ReyB)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j - 1; k >= 0; k--) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonB) || JTBotones[i][k].getIcon().equals(TorreB)
                                                            || JTBotones[i][k].getIcon().equals(AlfilB) || JTBotones[i][k].getIcon().equals(ReinaB)
                                                            || JTBotones[i][k].getIcon().equals(CaballoB)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyB)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j + 1; k <= 7; k++) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonB) || JTBotones[i][k].getIcon().equals(TorreB)
                                                            || JTBotones[i][k].getIcon().equals(AlfilB) || JTBotones[i][k].getIcon().equals(ReinaB)
                                                            || JTBotones[i][k].getIcon().equals(CaballoB)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyB)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i - m][j - m].getIcon() == null) {
                                                JTBotones[i - m][j - m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i - m][j - m].getIcon().equals(PeonB) || JTBotones[i - m][j - m].getIcon().equals(TorreB)
                                                    || JTBotones[i - m][j - m].getIcon().equals(AlfilB) || JTBotones[i - m][j - m].getIcon().equals(ReinaB)
                                                    || JTBotones[i - m][j - m].getIcon().equals(CaballoB)) {
                                                JTBotones[i - m][j - m].Ataque(true);
                                            }
                                            if (JTBotones[i - m][j - m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i - m][j + m].getIcon() == null) {
                                                JTBotones[i - m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(PeonB) || JTBotones[i - m][j + m].getIcon().equals(TorreB)
                                                    || JTBotones[i - m][j + m].getIcon().equals(AlfilB) || JTBotones[i - m][j + m].getIcon().equals(ReinaB)
                                                    || JTBotones[i - m][j + m].getIcon().equals(CaballoB)) {
                                                JTBotones[i - m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j - m].getIcon() == null) {
                                                JTBotones[i + m][j - m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(PeonB) || JTBotones[i + m][j - m].getIcon().equals(TorreB)
                                                    || JTBotones[i + m][j - m].getIcon().equals(AlfilB) || JTBotones[i + m][j - m].getIcon().equals(ReinaB)
                                                    || JTBotones[i + m][j - m].getIcon().equals(CaballoB)) {
                                                JTBotones[i + m][j - m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j + m].getIcon() == null) {
                                                JTBotones[i + m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(PeonB) || JTBotones[i + m][j + m].getIcon().equals(TorreB)
                                                    || JTBotones[i + m][j + m].getIcon().equals(AlfilB) || JTBotones[i + m][j + m].getIcon().equals(ReinaB)
                                                    || JTBotones[i + m][j + m].getIcon().equals(CaballoB)) {
                                                JTBotones[i + m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(ReyB)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(ReinaB) && turnoB == true) {
                                    try {
                                        for (int k = i - 1; k >= 0; k--) {
                                            if (JTBotones[k][j].getIcon() == null) {
                                                JTBotones[k][j].Selection(true);
                                            } else {
                                                if (JTBotones[k][j].getIcon().equals(PeonN) || JTBotones[k][j].getIcon().equals(TorreN)
                                                        || JTBotones[k][j].getIcon().equals(AlfilN) || JTBotones[k][j].getIcon().equals(ReinaN)
                                                        || JTBotones[k][j].getIcon().equals(CaballoN)) {
                                                    JTBotones[k][j].Ataque(true);
                                                }
                                                if (JTBotones[k][j].getIcon().equals(ReyN)) {
                                                    for (int l = 0; l < 8; l++) {
                                                        for (int m = 0; m < 8; m++) {
                                                            JTBotones[l][m].Selection(false);
                                                        }
                                                    }
                                                    encontrado2 = true;
                                                }
                                                break;
                                            }
                                        }
                                    } catch (Exception ae) {
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = i + 1; k <= 7; k++) {
                                                if (JTBotones[k][j].getIcon() == null) {
                                                    JTBotones[k][j].Selection(true);
                                                } else {
                                                    if (JTBotones[k][j].getIcon().equals(PeonN) || JTBotones[k][j].getIcon().equals(TorreN)
                                                            || JTBotones[k][j].getIcon().equals(AlfilN) || JTBotones[k][j].getIcon().equals(ReinaN)
                                                            || JTBotones[k][j].getIcon().equals(CaballoN)) {
                                                        JTBotones[k][j].Ataque(true);
                                                    }
                                                    if (JTBotones[k][j].getIcon().equals(ReyN)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j - 1; k >= 0; k--) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonN) || JTBotones[i][k].getIcon().equals(TorreN)
                                                            || JTBotones[i][k].getIcon().equals(AlfilN) || JTBotones[i][k].getIcon().equals(ReinaN)
                                                            || JTBotones[i][k].getIcon().equals(CaballoN)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyN)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            for (int k = j + 1; k <= 7; k++) {
                                                if (JTBotones[i][k].getIcon() == null) {
                                                    JTBotones[i][k].Selection(true);
                                                } else {
                                                    if (JTBotones[i][k].getIcon().equals(PeonN) || JTBotones[i][k].getIcon().equals(TorreN)
                                                            || JTBotones[i][k].getIcon().equals(AlfilN) || JTBotones[i][k].getIcon().equals(ReinaN)
                                                            || JTBotones[i][k].getIcon().equals(CaballoN)) {
                                                        JTBotones[i][k].Ataque(true);
                                                    }
                                                    if (JTBotones[i][k].getIcon().equals(ReyN)) {
                                                        for (int l = 0; l < 8; l++) {
                                                            for (int m = 0; m < 8; m++) {
                                                                JTBotones[l][m].Selection(false);
                                                            }
                                                        }
                                                        encontrado2 = true;
                                                    }
                                                    break;
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i - m][j - m].getIcon() == null) {
                                                JTBotones[i - m][j - m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i - m][j - m].getIcon().equals(PeonN) || JTBotones[i - m][j - m].getIcon().equals(TorreN)
                                                    || JTBotones[i - m][j - m].getIcon().equals(AlfilN) || JTBotones[i - m][j - m].getIcon().equals(ReinaN)
                                                    || JTBotones[i - m][j - m].getIcon().equals(CaballoN)) {
                                                JTBotones[i - m][j - m].Ataque(true);
                                            }
                                            if (JTBotones[i - m][j - m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i - m][j + m].getIcon() == null) {
                                                JTBotones[i - m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(PeonN) || JTBotones[i - m][j + m].getIcon().equals(TorreN)
                                                    || JTBotones[i - m][j + m].getIcon().equals(AlfilN) || JTBotones[i - m][j + m].getIcon().equals(ReinaN)
                                                    || JTBotones[i - m][j + m].getIcon().equals(CaballoN)) {
                                                JTBotones[i - m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i - m][j + m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j - m].getIcon() == null) {
                                                JTBotones[i + m][j - m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(PeonN) || JTBotones[i + m][j - m].getIcon().equals(TorreN)
                                                    || JTBotones[i + m][j - m].getIcon().equals(AlfilN) || JTBotones[i + m][j - m].getIcon().equals(ReinaN)
                                                    || JTBotones[i + m][j - m].getIcon().equals(CaballoN)) {
                                                JTBotones[i + m][j - m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j - m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    if (encontrado2 == false) {
                                        try {
                                            int m = 1;
                                            while (JTBotones[i + m][j + m].getIcon() == null) {
                                                JTBotones[i + m][j + m].Selection(true);
                                                m++;
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(PeonN) || JTBotones[i + m][j + m].getIcon().equals(TorreN)
                                                    || JTBotones[i + m][j + m].getIcon().equals(AlfilN) || JTBotones[i + m][j + m].getIcon().equals(ReinaN)
                                                    || JTBotones[i + m][j + m].getIcon().equals(CaballoN)) {
                                                JTBotones[i + m][j + m].Ataque(true);
                                            }
                                            if (JTBotones[i + m][j + m].getIcon().equals(ReyN)) {
                                                for (int l = 0; l < 8; l++) {
                                                    for (int n = 0; n < 8; n++) {
                                                        JTBotones[l][n].Selection(false);
                                                    }
                                                }
                                            }
                                        } catch (Exception ae) {
                                        }
                                    }
                                    encontrado = true;
                                    encontrado2 = false;
                                } else if (JTBotones[i][j].getIcon().equals(ReyN) && turnoN == true) {
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(ReinaB) || JTBotones[i - 1][j - 1].getIcon().equals(AlfilB)
                                                    || JTBotones[i - 1][j - 1].getIcon().equals(TorreB) || JTBotones[i - 1][j - 1].getIcon().equals(CaballoB)
                                                    || JTBotones[i - 1][j - 1].getIcon().equals(PeonB)) {
                                                JTBotones[i - 1][j - 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon() == null) {
                                                JTBotones[i - 1][j - 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i - m][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m].getIcon().equals(AlfilB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - 1].getIcon().equals(TorreB) || JTBotones[i - m][j - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j + m - 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m - 2].getIcon().equals(AlfilB) || JTBotones[i - m][j + m - 2].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + m].getIcon().equals(TorreB) || JTBotones[i - 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - 1].getIcon().equals(TorreB) || JTBotones[i + m][j - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m - 2][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m - 2][j - m].getIcon().equals(AlfilB) || JTBotones[i + m - 2][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(ReyB) || JTBotones[i][j - 2].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - m].getIcon().equals(TorreB) || JTBotones[i - 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i - 1][j - 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    // *******************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(ReinaB) || JTBotones[i - 1][j].getIcon().equals(AlfilB)
                                                    || JTBotones[i - 1][j].getIcon().equals(TorreB) || JTBotones[i - 1][j].getIcon().equals(CaballoB)
                                                    || JTBotones[i - 1][j].getIcon().equals(PeonB)) {
                                                JTBotones[i - 1][j].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon() == null) {
                                                JTBotones[i - 1][j].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i - m][j].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j].getIcon().equals(TorreB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j + m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m - 1].getIcon().equals(AlfilB) || JTBotones[i - m][j + m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + m].getIcon().equals(TorreB) || JTBotones[i - 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m + 1].getIcon().equals(AlfilB) || JTBotones[i + m][j + m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m - 1].getIcon().equals(AlfilB) || JTBotones[i + m][j - m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - m].getIcon().equals(TorreB) || JTBotones[i - 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j - m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m + 1].getIcon().equals(AlfilB) || JTBotones[i - m][j - m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(PeonB) || JTBotones[i][j + 1].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i - 1][j].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //*****************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(ReinaB) || JTBotones[i - 1][j + 1].getIcon().equals(AlfilB)
                                                    || JTBotones[i - 1][j + 1].getIcon().equals(TorreB) || JTBotones[i - 1][j + 1].getIcon().equals(CaballoB)
                                                    || JTBotones[i - 1][j + 1].getIcon().equals(PeonB)) {
                                                JTBotones[i - 1][j + 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon() == null) {
                                                JTBotones[i - 1][j + 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i - m][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m].getIcon().equals(AlfilB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + m].getIcon().equals(TorreB) || JTBotones[i - 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j + m + 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m + 2].getIcon().equals(AlfilB) || JTBotones[i + m][j + m + 2].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(ReyB) || JTBotones[i][j + 2].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + 1].getIcon().equals(TorreB) || JTBotones[i + m][j + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - m].getIcon().equals(TorreB) || JTBotones[i - 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j - m + 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m + 2].getIcon().equals(AlfilB) || JTBotones[i - m][j - m + 2].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + 1].getIcon().equals(TorreB) || JTBotones[i - m][j + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i - 1][j + 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //*************************************************************+
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i][j + 1].getIcon().equals(ReinaB) || JTBotones[i][j + 1].getIcon().equals(AlfilB)
                                                    || JTBotones[i][j + 1].getIcon().equals(TorreB) || JTBotones[i][j + 1].getIcon().equals(CaballoB)
                                                    || JTBotones[i][j + 1].getIcon().equals(PeonB)) {
                                                JTBotones[i][j + 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 1].getIcon() == null) {
                                                JTBotones[i][j + 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + m].getIcon().equals(TorreB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m + 1].getIcon().equals(AlfilB) || JTBotones[i + m][j + m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon().equals(ReyB) || JTBotones[i + 1][j + 2].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + 1].getIcon().equals(TorreB) || JTBotones[i + m][j + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m + 1][j - m].getIcon().equals(AlfilB) || JTBotones[i + m + 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j - m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m + 1].getIcon().equals(AlfilB) || JTBotones[i - m][j - m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + 1].getIcon().equals(TorreB) || JTBotones[i - m][j + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m + 1].getIcon().equals(AlfilB) || JTBotones[i - m][j + m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i][j + 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //****************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(ReinaB) || JTBotones[i + 1][j + 1].getIcon().equals(AlfilB)
                                                    || JTBotones[i + 1][j + 1].getIcon().equals(TorreB) || JTBotones[i + 1][j + 1].getIcon().equals(CaballoB)
                                                    || JTBotones[i + 1][j + 1].getIcon().equals(PeonB)) {
                                                JTBotones[i + 1][j + 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon() == null) {
                                                JTBotones[i + 1][j + 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i + m][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 2].getIcon().equals(ReyB) || JTBotones[i + 2][j + 2].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m].getIcon().equals(AlfilB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + 1].getIcon().equals(TorreB) || JTBotones[i + m][j + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j - m + 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m + 2].getIcon().equals(AlfilB) || JTBotones[i + m][j - m + 2].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(ReyB) || JTBotones[i + 2][j].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - m].getIcon().equals(TorreB) || JTBotones[i + 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + 1].getIcon().equals(TorreB) || JTBotones[i - m][j + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m + 2][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m + 2][j + m].getIcon().equals(AlfilB) || JTBotones[i - m + 2][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + m].getIcon().equals(TorreB) || JTBotones[i + 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i + 1][j + 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //**********************************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(ReinaB) || JTBotones[i + 1][j].getIcon().equals(AlfilB)
                                                    || JTBotones[i + 1][j].getIcon().equals(TorreB) || JTBotones[i + 1][j].getIcon().equals(CaballoB)
                                                    || JTBotones[i + 1][j].getIcon().equals(PeonB)) {
                                                JTBotones[i + 1][j].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon() == null) {
                                                JTBotones[i + 1][j].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i + m][j].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j].getIcon().equals(TorreB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j - 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j - m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m + 1].getIcon().equals(AlfilB) || JTBotones[i + m][j - m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon().equals(ReyB) || JTBotones[i + 2][j - 1].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - m].getIcon().equals(TorreB) || JTBotones[i + 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m - 1].getIcon().equals(AlfilB) || JTBotones[i - m][j - m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m + 1].getIcon().equals(AlfilB) || JTBotones[i - m][j + m + 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + m].getIcon().equals(TorreB) || JTBotones[i + 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j + m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m - 1].getIcon().equals(AlfilB) || JTBotones[i + m][j + m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon().equals(ReyB) || JTBotones[i + 2][j + 1].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i + 1][j].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //******************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(ReinaB) || JTBotones[i + 1][j - 1].getIcon().equals(AlfilB)
                                                    || JTBotones[i + 1][j - 1].getIcon().equals(TorreB) || JTBotones[i + 1][j - 1].getIcon().equals(CaballoB)
                                                    || JTBotones[i + 1][j - 1].getIcon().equals(PeonB)) {
                                                JTBotones[i + 1][j - 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon() == null) {
                                                JTBotones[i + 1][j - 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i + m][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 2].getIcon().equals(ReyB) || JTBotones[i + 2][j - 2].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m].getIcon().equals(AlfilB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - m].getIcon().equals(TorreB) || JTBotones[i + 1][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j - m - 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m - 2].getIcon().equals(AlfilB) || JTBotones[i - m][j - m - 2].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - 1].getIcon().equals(TorreB) || JTBotones[i - m][j - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + m].getIcon().equals(TorreB) || JTBotones[i + 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j + m - 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m - 2].getIcon().equals(AlfilB) || JTBotones[i + m][j + m - 2].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(ReyB) || JTBotones[i + 2][j].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - 1].getIcon().equals(TorreB) || JTBotones[i + m][j - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i + 1][j - 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //*****************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(ReinaB) || JTBotones[i][j - 1].getIcon().equals(AlfilB)
                                                    || JTBotones[i][j - 1].getIcon().equals(TorreB) || JTBotones[i][j - 1].getIcon().equals(CaballoB)
                                                    || JTBotones[i][j - 1].getIcon().equals(PeonB)) {
                                                JTBotones[i][j - 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon() == null) {
                                                JTBotones[i][j - 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - m].getIcon().equals(TorreB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 2].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 3].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(CaballoB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m - 1].getIcon().equals(AlfilB) || JTBotones[i - m][j - m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(ReyB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - 1].getIcon().equals(TorreB) || JTBotones[i - m][j - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m - 1][j + m].getIcon().equals(AlfilB) || JTBotones[i - m - 1][j + m].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j + m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m - 1].getIcon().equals(AlfilB) || JTBotones[i + m][j + m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - 1].getIcon().equals(TorreB) || JTBotones[i + m][j - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m - 1].getIcon().equals(AlfilB) || JTBotones[i + m][j - m - 1].getIcon().equals(ReinaB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon().equals(ReyB) || JTBotones[i + 1][j - 2].getIcon().equals(PeonB)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i][j - 1].Selection(false);
                                            encontrado2 = false;
                                        }
                                    } catch (Exception ae) {
                                    }
                                    encontrado = true;
                                } else if (JTBotones[i][j].getIcon().equals(ReyB) && turnoB == true) {
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(ReinaN) || JTBotones[i - 1][j - 1].getIcon().equals(AlfilN)
                                                    || JTBotones[i - 1][j - 1].getIcon().equals(TorreN) || JTBotones[i - 1][j - 1].getIcon().equals(CaballoN)
                                                    || JTBotones[i - 1][j - 1].getIcon().equals(PeonN)) {
                                                JTBotones[i - 1][j - 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon() == null) {
                                                JTBotones[i - 1][j - 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i - m][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 2].getIcon().equals(ReyN) || JTBotones[i - 2][j - 2].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m].getIcon().equals(AlfilN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - 1].getIcon().equals(TorreN) || JTBotones[i - m][j - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j + m - 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m - 2].getIcon().equals(AlfilN) || JTBotones[i - m][j + m - 2].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(ReyN) || JTBotones[i - 2][j].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + m].getIcon().equals(TorreN) || JTBotones[i - 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - 1].getIcon().equals(TorreN) || JTBotones[i + m][j - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m - 2][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m - 2][j - m].getIcon().equals(AlfilN) || JTBotones[i + m - 2][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - m].getIcon().equals(TorreN) || JTBotones[i - 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i - 1][j - 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    // *******************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(ReinaN) || JTBotones[i - 1][j].getIcon().equals(AlfilN)
                                                    || JTBotones[i - 1][j].getIcon().equals(TorreN) || JTBotones[i - 1][j].getIcon().equals(CaballoN)
                                                    || JTBotones[i - 1][j].getIcon().equals(PeonN)) {
                                                JTBotones[i - 1][j].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon() == null) {
                                                JTBotones[i - 1][j].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i - m][j].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j].getIcon().equals(TorreN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j + m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m - 1].getIcon().equals(AlfilN) || JTBotones[i - m][j + m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + m].getIcon().equals(TorreN) || JTBotones[i - 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m + 1].getIcon().equals(AlfilN) || JTBotones[i + m][j + m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m - 1].getIcon().equals(AlfilN) || JTBotones[i + m][j - m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - m].getIcon().equals(TorreN) || JTBotones[i - 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j - m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m + 1].getIcon().equals(AlfilN) || JTBotones[i - m][j - m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i - 1][j].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //*****************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(ReinaN) || JTBotones[i - 1][j + 1].getIcon().equals(AlfilN)
                                                    || JTBotones[i - 1][j + 1].getIcon().equals(TorreN) || JTBotones[i - 1][j + 1].getIcon().equals(CaballoN)
                                                    || JTBotones[i - 1][j + 1].getIcon().equals(PeonN)) {
                                                JTBotones[i - 1][j + 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon() == null) {
                                                JTBotones[i - 1][j + 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i - m][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 2].getIcon().equals(ReyN) || JTBotones[i - 2][j + 2].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m].getIcon().equals(AlfilN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 3][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + m].getIcon().equals(TorreN) || JTBotones[i - 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j + m + 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m + 2].getIcon().equals(AlfilN) || JTBotones[i + m][j + m + 2].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + 1].getIcon().equals(TorreN) || JTBotones[i + m][j + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - m].getIcon().equals(TorreN) || JTBotones[i - 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j - m + 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m + 2].getIcon().equals(AlfilN) || JTBotones[i - m][j - m + 2].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(ReyN) || JTBotones[i - 2][j].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + 1].getIcon().equals(TorreN) || JTBotones[i - m][j + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i - 1][j + 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //*************************************************************+
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i][j + 1].getIcon().equals(ReinaN) || JTBotones[i][j + 1].getIcon().equals(AlfilN)
                                                    || JTBotones[i][j + 1].getIcon().equals(TorreN) || JTBotones[i][j + 1].getIcon().equals(CaballoN)
                                                    || JTBotones[i][j + 1].getIcon().equals(PeonN)) {
                                                JTBotones[i][j + 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 1].getIcon() == null) {
                                                JTBotones[i][j + 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + m].getIcon().equals(TorreN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m + 1].getIcon().equals(AlfilN) || JTBotones[i + m][j + m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + 1].getIcon().equals(TorreN) || JTBotones[i + m][j + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + m + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m + 1][j - m].getIcon().equals(AlfilN) || JTBotones[i + m + 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j - m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m + 1].getIcon().equals(AlfilN) || JTBotones[i - m][j - m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + 1].getIcon().equals(TorreN) || JTBotones[i - m][j + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m + 1].getIcon().equals(AlfilN) || JTBotones[i - m][j + m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon().equals(ReyN) || JTBotones[i - 1][j + 2].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i][j + 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //****************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(ReinaN) || JTBotones[i + 1][j + 1].getIcon().equals(AlfilN)
                                                    || JTBotones[i + 1][j + 1].getIcon().equals(TorreN) || JTBotones[i + 1][j + 1].getIcon().equals(CaballoN)
                                                    || JTBotones[i + 1][j + 1].getIcon().equals(PeonN)) {
                                                JTBotones[i + 1][j + 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon() == null) {
                                                JTBotones[i + 1][j + 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i + m][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m].getIcon().equals(AlfilN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + 1].getIcon().equals(TorreN) || JTBotones[i + m][j + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j - m + 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m + 2].getIcon().equals(AlfilN) || JTBotones[i + m][j - m + 2].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - m].getIcon().equals(TorreN) || JTBotones[i + 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + 1].getIcon().equals(TorreN) || JTBotones[i - m][j + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i - m + 2][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m + 2][j + m].getIcon().equals(AlfilN) || JTBotones[i - m + 2][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + m].getIcon().equals(TorreN) || JTBotones[i + 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i + 1][j + 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //**********************************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i + 1][j].getIcon().equals(ReinaN) || JTBotones[i + 1][j].getIcon().equals(AlfilN)
                                                    || JTBotones[i + 1][j].getIcon().equals(TorreN) || JTBotones[i + 1][j].getIcon().equals(CaballoN)
                                                    || JTBotones[i + 1][j].getIcon().equals(PeonN)) {
                                                JTBotones[i + 1][j].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j].getIcon() == null) {
                                                JTBotones[i + 1][j].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i + m][j].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j].getIcon().equals(TorreN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j - 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j - m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m + 1].getIcon().equals(AlfilN) || JTBotones[i + m][j - m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - m].getIcon().equals(TorreN) || JTBotones[i + 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m - 1].getIcon().equals(AlfilN) || JTBotones[i - m][j - m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j + m + 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j + m + 1].getIcon().equals(AlfilN) || JTBotones[i - m][j + m + 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + m].getIcon().equals(TorreN) || JTBotones[i + 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j + m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m - 1].getIcon().equals(AlfilN) || JTBotones[i + m][j + m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(PeonN) || JTBotones[i][j + 1].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i + 1][j].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //******************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon().equals(ReinaN) || JTBotones[i + 1][j - 1].getIcon().equals(AlfilN)
                                                    || JTBotones[i + 1][j - 1].getIcon().equals(TorreN) || JTBotones[i + 1][j - 1].getIcon().equals(CaballoN)
                                                    || JTBotones[i + 1][j - 1].getIcon().equals(PeonN)) {
                                                JTBotones[i + 1][j - 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 1].getIcon() == null) {
                                                JTBotones[i + 1][j - 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i + m][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m].getIcon().equals(AlfilN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 3][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + 1][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - m].getIcon().equals(TorreN) || JTBotones[i + 1][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j - m - 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m - 2].getIcon().equals(AlfilN) || JTBotones[i - m][j - m - 2].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - 1].getIcon().equals(TorreN) || JTBotones[i - m][j - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i + 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + m].getIcon().equals(TorreN) || JTBotones[i + 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j + m - 2].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m - 2].getIcon().equals(AlfilN) || JTBotones[i + m][j + m - 2].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 2;
                                        try {
                                            while (JTBotones[i + m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - 1].getIcon().equals(TorreN) || JTBotones[i + m][j - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 1].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i + 1][j - 1].Selection(false);
                                            encontrado2 = false;
                                        }

                                    } catch (Exception ae) {
                                    }
                                    //*****************************************************************
                                    try {
                                        int m = 2;
                                        try {
                                            if (JTBotones[i][j - 1].getIcon().equals(ReinaN) || JTBotones[i][j - 1].getIcon().equals(AlfilN)
                                                    || JTBotones[i][j - 1].getIcon().equals(TorreN) || JTBotones[i][j - 1].getIcon().equals(CaballoN)
                                                    || JTBotones[i][j - 1].getIcon().equals(PeonN)) {
                                                JTBotones[i][j - 1].Ataque(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 1].getIcon() == null) {
                                                JTBotones[i][j - 1].Selection(true);
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            while (JTBotones[i][j - m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i][j - m].getIcon().equals(TorreN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 2][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j - 2].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 2][j].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 3].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j + 1].getIcon().equals(CaballoN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - m - 1].getIcon().equals(AlfilN) || JTBotones[i - m][j - m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i - m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m][j - 1].getIcon().equals(TorreN) || JTBotones[i - m][j - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 0;
                                        try {
                                            while (JTBotones[i - m - 1][j + m].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - m - 1][j + m].getIcon().equals(AlfilN) || JTBotones[i - m - 1][j + m].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j + m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j + m - 1].getIcon().equals(AlfilN) || JTBotones[i + m][j + m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - 1].getIcon().equals(TorreN) || JTBotones[i + m][j - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        m = 1;
                                        try {
                                            while (JTBotones[i + m][j - m - 1].getIcon() == null) {
                                                m++;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + m][j - m - 1].getIcon().equals(AlfilN) || JTBotones[i + m][j - m - 1].getIcon().equals(ReinaN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i + 1][j - 2].getIcon().equals(ReyN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        try {
                                            if (JTBotones[i - 1][j - 2].getIcon().equals(PeonN) | JTBotones[i - 1][j].getIcon().equals(PeonN)) {
                                                encontrado2 = true;
                                            }
                                        } catch (Exception ae) {
                                        }
                                        if (encontrado2) {
                                            JTBotones[i][j - 1].Selection(false);
                                            encontrado2 = false;
                                        }
                                    } catch (Exception ae) {
                                    }
                                    encontrado = true;
                                }
                                encontrado4 = true;
                            } else {
                                for (int k = 0; k < 8; k++) {
                                    for (int l = 0; l < 8; l++) {
                                        JTBotones[k][l].Selection(false);
                                    }
                                }
                            }
                            if (encontrado == true) {
                                break;
                            }
                        }

                    }
                    if (encontrado == true) {
                        encontrado = false;
                        break;
                    }
                }
            } catch (Exception ae) {
            }
            //***************************************************************
            boolean encontrado3 = false;
            if (encontrado4) {
                try {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            int x = 0, y = 0;
                            boolean listo = false;
                            if (JTBotones[i][j].getIcon() == null) {
                                if (JTBotones[i][j].isSelected()) {
                                    if (JTBotones[i][j].getBackground().equals(Color.YELLOW)) {
                                        int num2 = 0, num = 0;
                                        pos3 = i;
                                        pos4 = j;
                                        String letra2 = "", letra = "";
                                        if (i == 0) {
                                            num2 = 8;
                                        } else if (i == 1) {
                                            num2 = 7;
                                        } else if (i == 2) {
                                            num2 = 6;
                                        } else if (i == 3) {
                                            num2 = 5;
                                        } else if (i == 4) {
                                            num2 = 4;
                                        } else if (i == 5) {
                                            num2 = 3;
                                        } else if (i == 6) {
                                            num2 = 2;
                                        } else if (i == 7) {
                                            num2 = 1;
                                        }
                                        if (j == 0) {
                                            letra2 = "A";
                                        } else if (j == 1) {
                                            letra2 = "B";
                                        } else if (j == 2) {
                                            letra2 = "C";
                                        } else if (j == 3) {
                                            letra2 = "D";
                                        } else if (j == 4) {
                                            letra2 = "E";
                                        } else if (j == 5) {
                                            letra2 = "F";
                                        } else if (j == 6) {
                                            letra2 = "G";
                                        } else if (j == 7) {
                                            letra2 = "H";
                                        }
                                        for (int k = 0; k < 8; k++) {
                                            for (int l = 0; l < 8; l++) {
                                                if (JTBotones[k][l].isSelected()) {
                                                    if (JTBotones[k][l].getIcon() != null) {
                                                        x = k;
                                                        y = l;
                                                        pos1 = k;
                                                        pos2 = l;
                                                        if (k == 0) {
                                                            num = 8;
                                                        } else if (k == 1) {
                                                            num = 7;
                                                        } else if (k == 2) {
                                                            num = 6;
                                                        } else if (k == 3) {
                                                            num = 5;
                                                        } else if (k == 4) {
                                                            num = 4;
                                                        } else if (k == 5) {
                                                            num = 3;
                                                        } else if (k == 6) {
                                                            num = 2;
                                                        } else if (k == 7) {
                                                            num = 1;
                                                        }
                                                        if (l == 0) {
                                                            letra = "A";
                                                        } else if (l == 1) {
                                                            letra = "B";
                                                        } else if (l == 2) {
                                                            letra = "C";
                                                        } else if (l == 3) {
                                                            letra = "D";
                                                        } else if (l == 4) {
                                                            letra = "E";
                                                        } else if (l == 5) {
                                                            letra = "F";
                                                        } else if (l == 6) {
                                                            letra = "G";
                                                        } else if (l == 7) {
                                                            letra = "H";
                                                        }
                                                        listo = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (listo) {
                                                listo = false;
                                                break;
                                            }
                                        }
                                        if (Turno.getBackground().equals(new Color(204, 153, 0))) {
                                            Turno.setBackground(Color.black);
                                        } else {
                                            Turno.setBackground(new Color(204, 153, 0));
                                        }
                                        JTBotones[i][j].setIcon(JTBotones[x][y].getIcon());
                                        JTBotones[x][y].setIcon(null);
                                        if (i == 0 && JTBotones[i][j].getIcon().equals(PeonB)) {
                                            JTBotones[i][j].setIcon(ReinaB);
                                        }
                                        if (i == 7 && JTBotones[i][j].getIcon().equals(PeonN)) {
                                            JTBotones[i][j].setIcon(ReinaN);
                                        }
                                        for (int k = 0; k < 8; k++) {
                                            for (int l = 0; l < 8; l++) {
                                                JTBotones[k][l].Selection(false);
                                                JTBotones[k][l].setSelected(false);
                                            }
                                        }
                                        if (JTBotones[i][j].getIcon().equals(PeonN)) {
                                            Movimientos.setText(Movimientos.getText() + "Peon Negro se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(PeonB)) {
                                            Movimientos.setText(Movimientos.getText() + "Peon blanco se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(CaballoN)) {
                                            Movimientos.setText(Movimientos.getText() + "Caballo Negro se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(CaballoB)) {
                                            Movimientos.setText(Movimientos.getText() + "Caballo Blanco se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(AlfilN)) {
                                            Movimientos.setText(Movimientos.getText() + "Alfil Negro se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(AlfilB)) {
                                            Movimientos.setText(Movimientos.getText() + "Alfil Blanco se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(ReinaN)) {
                                            Movimientos.setText(Movimientos.getText() + "Reina Negra se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(ReinaB)) {
                                            Movimientos.setText(Movimientos.getText() + "Reina Blanca se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(TorreN)) {
                                            Movimientos.setText(Movimientos.getText() + "Torre Negra se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(TorreB)) {
                                            Movimientos.setText(Movimientos.getText() + "Torre Blanca se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(ReyN)) {
                                            Movimientos.setText(Movimientos.getText() + "Rey Negro se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        } else if (JTBotones[i][j].getIcon().equals(ReyB)) {
                                            Movimientos.setText(Movimientos.getText() + "Rey Blanco se movió de (" + num + ", " + letra + ")" + " hasta " + "(" + num2 + ", " + letra2 + ")\n");
                                        }
                                        encontrado3 = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (encontrado3) {
                            encontrado3 = false;
                            break;
                        }
                    }
                    encontrado4 = false;
                } catch (Exception ae) {
                }
            }
            if (pos1 != pos4 || pos2 != pos3) {
                Guardar.add(Integer.toString(pos1) + "-" + Integer.toString(pos2) + "-" + Integer.toString(pos3) + "-" + Integer.toString(pos4));
            }
         
 

        
        }
    }
        
    
    public static void Guardar() {
        String texto;
        texto = "";
        for (int i = 0; i < Guardar.size(); i++) {
            texto = texto + Guardar.get(i) + "/";
        }

        Escribir("GA", texto);
    }

    public static void Cargar() {
        String texto;
        
        texto = Leer("GA");

        int a = 0;
        int b = 0;
        int u = 0;
        int v = 0;

        if (!texto.isEmpty()) {
            for (int i = 0; i < texto.split("/").length; i++) {
                
                a = Integer.parseInt(texto.split("/")[i].split("-")[0]);
                b = Integer.parseInt(texto.split("/")[i].split("-")[1]);
                u = Integer.parseInt(texto.split("/")[i].split("-")[2]);
                v = Integer.parseInt(texto.split("/")[i].split("-")[3]);
                JTBotones[u][v].setIcon(JTBotones[a][b].getIcon());
                JTBotones[a][b].setIcon(null);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JTBotones[i][j].setEnabled(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tablero = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jNuevaPartida = new javax.swing.JButton();
        jReanudar = new javax.swing.JButton();
        jGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Movimientos = new javax.swing.JTextArea();
        jContinuar = new javax.swing.JButton();
        Turno = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Tablero.setBackground(new java.awt.Color(255, 255, 255));
        Tablero.setPreferredSize(new java.awt.Dimension(650, 650));

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(153, 255, 153));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("8");
        jLabel2.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel2.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel2.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel3.setBackground(new java.awt.Color(153, 255, 153));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("1");
        jLabel3.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel3.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel3.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel4.setBackground(new java.awt.Color(153, 255, 153));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("2");
        jLabel4.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel4.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel4.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel5.setBackground(new java.awt.Color(153, 255, 153));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("3");
        jLabel5.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel5.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel5.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel6.setBackground(new java.awt.Color(153, 255, 153));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("4");
        jLabel6.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel6.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel6.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel7.setBackground(new java.awt.Color(153, 255, 153));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("5");
        jLabel7.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel7.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel7.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel8.setBackground(new java.awt.Color(153, 255, 153));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("6");
        jLabel8.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel8.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel8.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel9.setBackground(new java.awt.Color(153, 255, 153));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("7");
        jLabel9.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel9.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel9.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel10.setBackground(new java.awt.Color(153, 255, 153));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("A");
        jLabel10.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel10.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel10.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel11.setBackground(new java.awt.Color(153, 255, 153));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("B");
        jLabel11.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel11.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel11.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel12.setBackground(new java.awt.Color(153, 255, 153));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setText("C");
        jLabel12.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel12.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel12.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel13.setBackground(new java.awt.Color(153, 255, 153));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setText("D");
        jLabel13.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel13.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel13.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel14.setBackground(new java.awt.Color(153, 255, 153));
        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("E");
        jLabel14.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel14.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel14.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel15.setBackground(new java.awt.Color(153, 255, 153));
        jLabel15.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel15.setText("F");
        jLabel15.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel15.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel15.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel16.setBackground(new java.awt.Color(153, 255, 153));
        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setText("G");
        jLabel16.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel16.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel16.setPreferredSize(new java.awt.Dimension(15, 34));

        jLabel17.setBackground(new java.awt.Color(153, 255, 153));
        jLabel17.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel17.setText("H");
        jLabel17.setMaximumSize(new java.awt.Dimension(15, 34));
        jLabel17.setMinimumSize(new java.awt.Dimension(15, 34));
        jLabel17.setPreferredSize(new java.awt.Dimension(15, 34));

        jNuevaPartida.setText("NUEVA PARTIDA");
        jNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevaPartidaActionPerformed(evt);
            }
        });

        jReanudar.setText("REANUDAR");
        jReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReanudarActionPerformed(evt);
            }
        });

        jGuardar.setText("GUARDAR");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });

        Movimientos.setColumns(20);
        Movimientos.setRows(5);
        jScrollPane1.setViewportView(Movimientos);

        jContinuar.setText("<<<");
        jContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jContinuarActionPerformed(evt);
            }
        });

        Turno.setBackground(new java.awt.Color(204, 153, 0));

        javax.swing.GroupLayout TurnoLayout = new javax.swing.GroupLayout(Turno);
        Turno.setLayout(TurnoLayout);
        TurnoLayout.setHorizontalGroup(
            TurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        TurnoLayout.setVerticalGroup(
            TurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jContinuar))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jReanudar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(312, 312, 312))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jNuevaPartida)
                                        .addGap(18, 18, 18)
                                        .addComponent(jReanudar)
                                        .addGap(25, 25, 25)
                                        .addComponent(jGuardar))
                                    .addComponent(Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jContinuar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReanudarActionPerformed
        jNuevaPartida.setEnabled(false);     
        jReanudar.setEnabled(true);
        jContinuar.setEnabled(true);
        jGuardar.setEnabled(false);
          
    }//GEN-LAST:event_jReanudarActionPerformed

    private void jNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevaPartidaActionPerformed
        jNuevaPartida.setEnabled(false);
        jReanudar.setEnabled(false);
        jGuardar.setEnabled(true);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JTBotones[i][j].setEnabled(true);
            }
        }
    }//GEN-LAST:event_jNuevaPartidaActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jContinuarActionPerformed
         Cargar();
    }//GEN-LAST:event_jContinuarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Movimientos;
    private javax.swing.JPanel Tablero;
    private javax.swing.JPanel Turno;
    private javax.swing.JButton jContinuar;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jNuevaPartida;
    private javax.swing.JButton jReanudar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
