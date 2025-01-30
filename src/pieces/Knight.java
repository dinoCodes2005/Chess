package pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Knight extends Piece{

    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xpos =  col * board.tileSize;
        this.ypos =  row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Knight";
        this.sprite = sheet.getSubimage(3*sheetScale,isWhite?0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public boolean isValidMovement(int col,int row)
    {
        int dx = Math.abs(col - this.col);
        int dy = Math.abs(row - this.row);
        if(dx * dy == 2)
        {
            return true;
        }
        return false;
    }
}
