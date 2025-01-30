package pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class King extends Piece{

    public King(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xpos =  col * board.tileSize;
        this.ypos =  row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "King";
        this.sprite = sheet.getSubimage(0,isWhite?0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int col,int row)
    {
        int dx = Math.abs(col - this.col);
        int dy = Math.abs(row - this.row);
        if((dx + dy == 1) || (dx+dy==2 && dx!=0 && dy!=0))
        {
            return true;
        }
        return false;
    }
}
