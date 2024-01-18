package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static void main(String[] args){
        new GUI();
    }
    public GUI(){
        super("Simple Matrix");
        this.setSize(1900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(new MatrixCalculationPanel(), BorderLayout.NORTH);

        this.setVisible(true);
    }
}
