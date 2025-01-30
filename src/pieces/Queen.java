package pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Queen extends Piece{

    public Queen(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xpos =  col * board.tileSize;
        this.ypos =  row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Queen";
        this.sprite = sheet.getSubimage(1*sheetScale,isWhite?0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col,int row)
    {
        int dx = Math.abs(col - this.col);
        int dy = Math.abs(row - this.row);
        if((dx == dy) || (dx==0 || dy==0))
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean moveCollideWithPieces(int col, int row) {
        if(this.col == col || this.row == row)
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
        }
        else{

            //up left
            if(this.col > col && this.row>row)
            {
                for(int i=1;i<Math.abs(this.col - col);i++)
                {
                    if(board.getPiece(this.col - i,this.row - i)!=null)
                        return true;
                }
            }

            //up right
            if(this.col < col && this.row>row)
            {
                for(int i=1;i<Math.abs(this.col - col);i++)
                {
                    if(board.getPiece(this.col + i,this.row - i)!=null)
                        return true;
                }
            }

            //down left

            if(this.col > col && this.row<row)
            {
                for(int i=1;i<Math.abs(this.col - col);i++)
                {
                    if(board.getPiece(this.col - i,this.row + i)!=null)
                        return true;
                }
            }

            //down right
            if(this.col < col && this.row < row)
            {
                for(int i=1;i<Math.abs(this.col - col);i++)
                {
                    if(board.getPiece(this.col + i,this.row + i)!=null)
                        return true;
                }
            }
        }
        return false;
    }
}
