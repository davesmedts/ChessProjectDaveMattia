package view.gameView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * @author Mattia Verreydt
 * @version 1.0 5-5-2022 20:22
 */
public class ChessBoardSquare extends GridPane {

    private final int rowNumber;
    private final char columnLetter;
    private String piece;

    private ImageView imageView;

    public String getPiece() {
        return piece;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public ChessBoardSquare(int rowNumber, char columnLetter) {
        this.rowNumber = rowNumber;
        this.columnLetter = columnLetter;

    }


    public void setContent(String piece) {
        switch (piece) {
            case "Knightblack":
                this.imageView = new ImageView("/Knightblack.png");
                this.piece = piece;
                break;
            case "Kingblack":
                this.imageView = new ImageView("/Kingblack.png");
                this.piece = piece;
                break;
            case "Queenblack":
                this.imageView = new ImageView("/Queenblack.png");
                this.piece = piece;
                break;
            case "Pawnblack":
                this.imageView = new ImageView("/Pawnblack.png");
                this.piece = piece;
                break;
            case "Rookblack":
                this.imageView = new ImageView("/Rookblack.png");
                this.piece = piece;
                break;
            case "Bishopblack":
                this.imageView = new ImageView("/BishopBlack.png");
                this.piece = piece;
                break;
            case"Knightwhite":
                this.imageView = new ImageView("Knightwhite.png");
                this.piece = piece;
                break;
            case"Kingwhite":
                this.imageView = new ImageView("Kingwhite.png");
                this.piece = piece;
                break;
            case"Queenwhite":
                this.imageView = new ImageView("Queenwhite.png");
                this.piece = piece;
                break;
            case"Pawnwhite":
                this.imageView = new ImageView("Pawnwhite.png");
                this.piece = piece;
                break;
            case"Rookwhite":
                this.imageView = new ImageView("Rookwhite.png");
                this.piece = piece;
                break;
            case"Bishopwhite":
                this.imageView = new ImageView("Bishopwhite.png");
                this.piece = piece;
                break;
        }
        if (imageView != null) {
            this.add(imageView, 0, 0);
            GridPane.setHalignment(imageView, HPos.CENTER);
        }
    }


    public int getRowNumber() {
        return rowNumber;
    }

    public char getColumnLetter() {
        return columnLetter;
    }

}
