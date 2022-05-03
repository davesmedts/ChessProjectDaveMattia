package view.gameView;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Mattia Verreydt
 * @version 1.0 27-4-2022 22:39
 */
public class ChessBoardView extends GridPane {


    //backgroundcolor
    // foto in zetten de chesssKnight
    // you can add nex pane object to each column and row and then add color to the pane with chessboard.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));


    public GridPane drawBoard() {
        int count = 0;

        for (int column = 8; column > 0; column--) {
            count++;

            for (int row = 8; row > 0; row--) {

                GridPane gameSquare = new GridPane();

                ColumnConstraints column1 = new ColumnConstraints(75);
                gameSquare.getColumnConstraints().addAll(column1);

                RowConstraints rowHeight = new RowConstraints(75);
                gameSquare.getRowConstraints().addAll(rowHeight);

                char columnLetter = (char) (64 + column); //ASCII code gebruiken om int naar char om te zetten

                int rowNumber = 0;

                //workaround for the squares
                switch (row) {
                    case 8:
                        rowNumber = rowNumber + 1;
                        break;
                    case 7:
                        rowNumber = rowNumber + 2;
                        break;
                    case 6:
                        rowNumber = rowNumber + 3;
                        break;
                    case 5:
                        rowNumber = rowNumber + 4;
                        break;
                    case 4:
                        rowNumber = rowNumber + 5;
                        break;
                    case 3:
                        rowNumber = rowNumber + 6;
                        break;
                    case 2:
                        rowNumber = rowNumber + 7;
                        break;
                    case 1:
                        rowNumber = rowNumber + 8;
                        break;
                }



                String squareName = columnLetter + String.valueOf(rowNumber);


                Text SQUARENAME = new Text(squareName);

//                ImageView knight = new ImageView("/chess-knight-solid2.png");


                if (count % 2 == 0) {

                    gameSquare.setStyle("-fx-background-color: #718d71;");

                    this.add(gameSquare, column, row);


                } else {

                    gameSquare.setStyle("-fx-background-color: #e7e3e3;");

                    this.add(gameSquare, column, row);
//                    this.add(knight, row, column);
                }

                gameSquare.add(SQUARENAME, column, row);

                count++;

            }


        }


        return this;

    }
}


