package pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class King extends Piece{

    public King(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = col;
        this.xpos =  col * board.tileSize;
        this.ypos =  row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "King";
        this.sprite = sheet.getSubimage(0*sheetScale,isWhite?0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
}
