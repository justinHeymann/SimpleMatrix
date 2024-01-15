package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    public static void main(String[] args){
        new Gui();
    }
    public Gui(){
        super("Simple Matrix");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(1600, 900);
        JPanel centerPanel = new JPanel(new FlowLayout());
        this.add(new MatrixInputPanel(4, 4), BorderLayout.CENTER);
        centerPanel.setBackground(Color.BLACK);

        this.add(new MatrixCreationPanel(), BorderLayout.NORTH);
        this.setVisible(true);
    }
}
