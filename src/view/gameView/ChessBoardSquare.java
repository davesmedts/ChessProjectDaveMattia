package view.gameView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
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

    public ChessBoardSquare(int rowNumber, char columnLetter) {
        this.rowNumber = rowNumber;
        this.columnLetter = columnLetter;

    }


    public void setContent(String piece) {
        switch (piece) {
            case "Knightblack":
                this.imageView = new ImageView("/Knightblack.png");
                break;
            case "Kingblack":
                this.imageView = new ImageView("/Kingblack.png");
                break;
            case "Queenblack":
                this.imageView = new ImageView("/Queenblack.png");
                break;
            case "Pawnblack":
                this.imageView = new ImageView("/Pawnblack.png");
                break;
            case "Rookblack":
                this.imageView = new ImageView("/Rookblack.png");
                break;
            case "Bishopblack":
                this.imageView = new ImageView("/BishopBlack.png");
                break;
            case"Knightwhite":
                this.imageView = new ImageView("Knightwhite.png");
                break;
            case"Kingwhite":
                this.imageView = new ImageView("Kingwhite.png");
                break;
            case"Queenwhite":
                this.imageView = new ImageView("Queenwhite.png");
                break;
            case"Pawnwhite":
                this.imageView = new ImageView("Pawnwhite.png");
                break;
            case"Rookwhite":
                this.imageView = new ImageView("Rookwhite.png");
                break;
            case"Bishopwhite":
                this.imageView = new ImageView("Bishopwhite.png");
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
