package view.gameView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import model.Board;
import model.Game;
import model.Square;
import model.chessPieces.Piece;

import java.util.List;

public class GamePresenter {

    private Game model;
    private GameView view;

    public GamePresenter(Game model,
                         GameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
//        EventHandler<ActionEvent> buttonEventHandler(){
//            return event -> {
//                Node node = (Node) event.getTarget();
//                int row = GridPane.getRowIndex(node);
//                int column = GridPane.getColumnIndex(node);
//            };
        }


    private void updateView() {
       Board backendBoard = model.getGameBoard();

       List<Square> backendSquares =backendBoard.getSquares();
       List<ChessBoardSquare> frontendSquares = view.getChessBoardSquares();

        for (Square backendSquare : backendSquares) {
            for (ChessBoardSquare frontendSquare : frontendSquares) {
                if(backendSquare.getRowNumber() == frontendSquare.getRowNumber() && backendSquare.getColumnLetter() == frontendSquare.getColumnLetter() ){
                    if(backendSquare.getSquareContent() != null){
                       String piece = backendSquare.getSquareContent().toString();
                       frontendSquare.setContent(piece);



                    }

                }

            }

        }


    }

}
