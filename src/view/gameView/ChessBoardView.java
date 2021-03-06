package view.gameView;


import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.Color;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Mattia Verreydt
 * @version 1.0 27-4-2022 22:39
 */
public class ChessBoardView extends GridPane {
    private List<ChessBoardSquare> gameSquares = new ArrayList<>();
    String colorOne;
    String colorTwo;


    public List<ChessBoardSquare> getGameSquares() {
        return gameSquares;
    }

    public String getColorOne() {
        return colorOne;
    }

    public String getColorTwo() {
        return colorTwo;
    }

    public GridPane drawBoard(String colorOne, String colorTwo) {
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;

        int count = 0;

        for (int column = 8; column > 0; column--) {
            count++;

            for (int row = 8; row > 0; row--) {


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

                ChessBoardSquare gameSquare = new ChessBoardSquare(rowNumber, columnLetter);
                gameSquare.setId("boardSquare");
                gameSquares.add(gameSquare);

                ImageView knight = new ImageView("/Knightblack.png");

                ColumnConstraints column1 = new ColumnConstraints(75);
                gameSquare.getColumnConstraints().addAll(column1);

                RowConstraints rowHeight = new RowConstraints(75);
                gameSquare.getRowConstraints().addAll(rowHeight);


                if (count % 2 == 0) {

                    gameSquare.setStyle("-fx-background-color:" + colorOne);
                    gameSquare.setColorOne(colorOne);

                    this.add(gameSquare, column, row);


                } else {

                    gameSquare.setStyle("-fx-background-color:" + colorTwo);
                    gameSquare.setColorOne(colorTwo);

                    this.add(gameSquare, column, row);

                }

//                gameSquare.add(SQUARENAME, column, row);

                count++;

            }


        }


        return this;

    }
}


