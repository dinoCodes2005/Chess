package pieces;

import Main.Board;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Piece {

    public int row, col;
    public int xpos, ypos;
    public boolean isWhite;
    public String name;
    public int value;

    BufferedImage sheet;

    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pic1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Image sprite;
    Board board;

    protected int sheetScale = sheet.getWidth() / 6;

    public Piece(Board board) {
        this.board = board;
    }

    public void paint(Graphics2D graphics2D) {
        graphics2D.drawImage(sprite, xpos, ypos, null);
    }

}
