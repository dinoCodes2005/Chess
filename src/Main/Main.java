package Main;

import java.awt.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setMinimumSize(new Dimension(1000,1000));
        jframe.setLayout(new GridBagLayout());
        Board board = new Board();
        jframe.add(board);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}