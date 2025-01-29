package Main;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    int rows=8,cols=8;
    public int tileSize = 85;
    public int xOffset = (getWidth()- cols * tileSize)/2;
    public int yOffset = (getHeight() - rows * tileSize)/2;

    ArrayList<Piece> pieceList = new ArrayList<>();
    public Board()
    {
        this.setPreferredSize(new Dimension(cols*tileSize,rows*tileSize));
        addPiece();
    }

    public void addPiece()
    {
        //black Pieces
        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        pieceList.add(new Rook(this,0,0,false));
        pieceList.add(new Rook(this,7,0,false));
        pieceList.add(new King(this,3,0,false));
        pieceList.add(new Queen(this,4,0,false));
        for(int i=0;i<8;i++)
        {
            pieceList.add(new Pawn(this,i,1,false));
        }

        //white Pieces
        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Knight(this,6,7,true));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new Bishop(this,5,7,true));
        pieceList.add(new Rook(this,0,7,true));
        pieceList.add(new Rook(this,7,7,true));
        pieceList.add(new King(this,3,7,true));
        pieceList.add(new Queen(this,4,7,true));
        for(int i=0;i<8;i++)
        {
            pieceList.add(new Pawn(this,i,6,true));
        }

    }


    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //to center the chess board

        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if((r+c)%2==0) g2d.setColor(new Color(157,105,53));
                else g2d.setColor(new Color(227,198,181));
                g2d.fillRect( r * tileSize, c * tileSize,tileSize,tileSize);
            }
        }

        for(Piece piece:pieceList)
        {
            piece.paint(g2d);
        }
    }


}
