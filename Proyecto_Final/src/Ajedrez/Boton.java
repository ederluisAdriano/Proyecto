
package Ajedrez;

import java.awt.Color;

public class Boton extends javax.swing.JToggleButton {

    private Color ColorOriginal;
    private Color ColorRuta = Color.YELLOW;
    private Color ColorAtaque = Color.RED;

    public Boton() {

    }

    public void ColorBase(Color color) {
        this.ColorOriginal = color;
        this.setBackground(this.ColorOriginal);
    }
    

    public void Selection(boolean a) {
        if (a) {
            this.setBackground(this.ColorRuta);
        } else {
            this.setBackground(this.ColorOriginal);
        }
    }
    
    public void Ataque (boolean b) {
        if(b) {
            this.setBackground(this.ColorAtaque);
        }
    }

}

