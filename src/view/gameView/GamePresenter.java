package view.gameView;

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
