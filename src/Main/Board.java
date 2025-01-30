package Main;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    int rows = 8, cols = 8;
    public int tileSize = 85;
    public Piece selectedPiece;
    Input input = new Input(this);
    public int enPassant = -1;

    ArrayList<Piece> pieceList = new ArrayList<>();

    public void addPiece() {
        //black Pieces
        pieceList.add(new Knight(this, 1, 0, false));
        pieceList.add(new Knight(this, 6, 0, false));
        pieceList.add(new Bishop(this, 2, 0, false));
        pieceList.add(new Bishop(this, 5, 0, false));
        pieceList.add(new Rook(this, 0, 0, false));
        pieceList.add(new Rook(this, 7, 0, false));
        pieceList.add(new King(this, 3, 0, false));
        pieceList.add(new Queen(this, 4, 0, false));
        for (int i = 0; i < 8; i++) {
            pieceList.add(new Pawn(this, i, 1, false));
        }

        //white Pieces
        pieceList.add(new Knight(this, 1, 7, true));
        pieceList.add(new Knight(this, 6, 7, true));
        pieceList.add(new Bishop(this, 2, 7, true));
        pieceList.add(new Bishop(this, 5, 7, true));
        pieceList.add(new Rook(this, 0, 7, true));
        pieceList.add(new Rook(this, 7, 7, true));
        pieceList.add(new King(this, 3, 7, true));
        pieceList.add(new Queen(this, 4, 7, true));
        for (int i = 0; i < 8; i++) {
            pieceList.add(new Pawn(this, i, 6, true));
        }

    }

    public Board() {
        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        addPiece();
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public Piece getPiece(int col, int row) {
        for (Piece piece : pieceList) {
            if (piece.row == row && piece.col == col) {
                System.out.println("Found Piece");
                return piece;
            }
        }
        return null;
    }

    public void makeMove(Move move) {
        if (move.piece.name == "Pawn") {
            movePawn(move);
        } else {
            move.piece.col = move.newCol;
            move.piece.row = move.newRow;
            move.piece.xpos = move.newCol * tileSize;
            move.piece.ypos = move.newRow * tileSize;
            move.piece.isFirstMove = false;
            capture(move);
        }
    }

    public void movePawn(Move move) {
        //en Passant

        int colorIndex = move.piece.isWhite?1:-1;
        move.piece.col = move.newCol;
        move.piece.row = move.newRow;
        move.piece.xpos = move.newCol * tileSize;
        move.piece.ypos = move.newRow * tileSize;
        move.piece.isFirstMove = false;
        capture(move);
    }


    public void capture(Move move) {
        pieceList.remove(move.capture);
    }

    public boolean isValidMove(Move move) {
        if (sameTeam(move.piece, move.capture)) {
            return false;
        }

        if (!move.piece.isValidMovement(move.newCol, move.newRow)) {
            return false;
        }

        if (move.piece.moveCollideWithPieces(move.newCol, move.newRow)) {
            return false;
        }
        return true;
    }


    public boolean sameTeam(Piece piece1, Piece piece2) {
        if (piece1 == null || piece2 == null) {
            return false;
        }
        return piece1.isWhite == piece2.isWhite;
    }

    public int getTile(int col, int row) {
        return row * rows + col;
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //paints the chess board alternate pattern
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //for alternate board coloring pattern
                if ((r + c) % 2 == 0) g2d.setColor(new Color(157, 105, 53));
                else g2d.setColor(new Color(227, 198, 181));
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }


        //paints the valid places to move with light green color
        if (selectedPiece != null) {

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {
                        g2d.setColor(new Color(102, 255, 0, 158));
                        g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
                    }
                }
            }
        }


        for (Piece piece : pieceList) {
            piece.paint(g2d);
        }
    }


}
