package view.gameView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Board;
import model.Game;
import model.Square;
import model.chessPieces.Piece;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;

import java.util.List;

public class GamePresenter {
    private static class Position {
        double x;
        double y;
    }


    private Game model;
    private GameView view;


    public GamePresenter(Game model,
                         GameView view) {
        this.model = model;
        this.view = view;
        this.updateView();
        this.addEventHandlers();

    }


    private void addEventHandlers() {
//        List<ChessBoardSquare> chessBoardSquares = view.getChessBoardSquares();
//        ImageView piece;
//
//        for (ChessBoardSquare chessboardsquare : chessBoardSquares) {
//            piece = chessboardsquare.getImageView();
//
//
//        piece.setOnMouseClicked(
//                new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent event) {
//                        System.out.println("click click");
//                    }
//                });}


        List<ChessBoardSquare> iv = view.getChessBoardSquares();


        for (int i = 0; i < iv.size(); i++) {

            ImageView piece = iv.get(i).getImageView();

            if (piece == null) {
                System.out.println("ok");
            } else {


                piece.setOnMouseDragEntered(
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                System.out.printf("X: %3.0f,Y: %3.0f%n",
                                        event.getX(),event.getY());
                            }
                        });}



//            draggable(piece);
//                piece.relocate(200, 200);



            }

        }


    private void draggable(Node node) {
        final Position pos = new Position();

        //Prompt the user that the node can be clicked
        node.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> node.setCursor(Cursor.HAND));
        node.addEventHandler(MouseEvent.MOUSE_EXITED, event -> node.setCursor(Cursor.DEFAULT));

        //Prompt the user that the node can be dragged
        node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            node.setCursor(Cursor.MOVE);

            //When a press event occurs, the location coordinates of the event are cached
            pos.x = event.getX();
            pos.y = event.getY();
        });

        node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> node.setCursor(Cursor.DEFAULT));

        //Realize drag and drop function
        node.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            double distanceX = event.getX() - pos.x;
            double distanceY = event.getY() - pos.y;

            double x = node.getLayoutX() + distanceX;
            double y = node.getLayoutY() + distanceY;

            //After calculating X and y, relocate the node to the specified coordinate point (x, y)
            node.relocate(x, y);
        });


    }


    private void updateView() {
        Board backendBoard = model.getGameBoard();

        List<Square> backendSquares = backendBoard.getSquares();
        List<ChessBoardSquare> frontendSquares = view.getChessBoardSquares();

        for (Square backendSquare : backendSquares) {
            for (ChessBoardSquare frontendSquare : frontendSquares) {
                if (backendSquare.getRowNumber() == frontendSquare.getRowNumber() && backendSquare.getColumnLetter() == frontendSquare.getColumnLetter()) {
                    if (backendSquare.getSquareContent() != null) {
                        String piece = backendSquare.getSquareContent().toString();
                        frontendSquare.setContent(piece);


                    }

                }

            }

        }


    }

}
