package pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Rook extends Piece{

    public Rook(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xpos =  col * board.tileSize;
        this.ypos =  row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Rook";
        this.sprite = sheet.getSubimage(4*sheetScale,isWhite?0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    @Override
    public boolean isValidMovement(int col,int row)
    {
        int dx = Math.abs(col - this.col);
        int dy = Math.abs(row - this.row);
        return dx==0 || dy == 0;
    }

    @Override
    public boolean moveCollideWithPieces(int col,int row)
    {
        //left
        if(this.col > col)
        {
            for(int c=this.col-1;c>=col;c--)
            {
                if(board.getPiece(c,this.row) != null)
                    return true;
            }
        }

        //right
        if(this.col < col)
        {
            for(int c=this.col+1;c<=col;c++)
            {
                if(board.getPiece(c,this.row) != null)
                    return true;
            }
        }

        //up
        if(this.row > row)
        {
            for(int r=this.row-1;r>=row;r--)
            {
                if(board.getPiece(this.col,r) != null)
                    return true;
            }
        }

        //down
        if(this.row < row)
        {
            for(int r=this.row+1;r<=row;r++)
            {
                if(board.getPiece(this.col,r) != null)
                    return true;
            }
        }
        return false;
    }
}
