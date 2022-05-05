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
        switch(piece) {
            case "Knightblack":
                this.imageView = new ImageView("/Knightblack.png");


        }

        if(imageView != null){

            this.add(imageView,0,0);
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
