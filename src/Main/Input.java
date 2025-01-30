package Main;

import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {
    Board board;

    public Input(Board board) {
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //getX() gives the position of the mouse event e wrt. to the Board of the Jframe
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;
        if (col >= 0 && col < board.cols && row >= 0 && row < board.rows) {
            System.out.println("Pressed at: " + col + " " + row);
            Piece pieceXY = board.getPiece(col, row);
            if (pieceXY != null) {
                board.selectedPiece = pieceXY;
            }

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (board.selectedPiece != null) {
            //to center the cursor with the center of the piece
            //otherwise the cursor stays at aligned with top left corner of the piece
            board.selectedPiece.xpos = e.getX() - board.tileSize / 2;
            board.selectedPiece.ypos = e.getY() - board.tileSize / 2;
            System.out.println("Dragged at: " + board.selectedPiece.xpos + "-x" + board.selectedPiece.ypos + "-y");
            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;
        if (board.selectedPiece != null) {
            Move move = new Move(board, board.selectedPiece, col, row);
            if (board.isValidMove(move)) {
                board.makeMove(move);
            } else {
                board.selectedPiece.xpos = board.selectedPiece.col * board.tileSize;
                board.selectedPiece.ypos = board.selectedPiece.row * board.tileSize;
            }
        }

        board.selectedPiece = null;
        board.repaint();
    }


}
