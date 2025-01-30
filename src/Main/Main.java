package Main;

import java.awt.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setMinimumSize(new Dimension(1000,1000));
        //grid bag layout is necessary to center the board... normal grid layout is obsolete and won't be able to do that
        jframe.setLayout(new GridBagLayout());
        Board board = new Board();
        jframe.add(board);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}