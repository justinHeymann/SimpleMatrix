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

        JPanel wrapperPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        wrapperPanel.add(new MatrixCalculationPanel(), BorderLayout.NORTH);
        this.add(scrollPane);

        this.setVisible(true);
    }
}
