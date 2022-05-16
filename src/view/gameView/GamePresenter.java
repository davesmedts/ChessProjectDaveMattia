package view.gameView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
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

import java.util.ArrayList;
import java.util.List;

public class GamePresenter {
    private static class Position {
        double x;
        double y;
    }

    private Game model;
    private GameView view;

    private int selectCounter = 0;

    public GamePresenter(Game model, GameView view) {
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
            ChessBoardSquare frontEndSquare = iv.get(i);

//            if (piece == null) {
//                System.out.println("ok");
//            } else {

                int finalI = i;
                frontEndSquare.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        List<Square> backendValidMoveSquares = new ArrayList<>();
                        System.out.printf("X: %3.0f,Y: %3.0f%n", event.getX(), event.getY());

                        if (selectCounter == 0 || selectCounter % 2 == 0) {
                            backendValidMoveSquares.addAll(model.selectWhitePiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber()));
                            List<ChessBoardSquare> frontendSquares = view.getChessBoardSquares();
                            frontEndSquare.setStyle("-fx-background-color: BLUE");
                            frontEndSquare.removePiece();
                            updateView();

                            for (Square backendSquare : backendValidMoveSquares) {
                                for (ChessBoardSquare frontendSquare : frontendSquares) {
                                    if (backendSquare.getRowNumber() == frontendSquare.getRowNumber() && backendSquare.getColumnLetter() == frontendSquare.getColumnLetter()) {
                                        frontendSquare.setStyle("-fx-background-color:GREEN");
                                    }
                                }

                            }
                            selectCounter++;
                        } else {
                            model.moveWhitePiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                            System.out.println("movePieceMethod");
                            ChessBoardView newBoard = new ChessBoardView();
                            view.setGameChessBoardGrid(newBoard);
                            view.setChessBoardSquares(view.getChessBoardSquares());
                            updateView();
                            selectCounter++;
                        }
                    }
                });

//                piece.setOnMouseReleased(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent mouseEvent) {
//                        updateView();
//                    }
//                });
//            }

//            int finalI1 = i;
//            iv.get(i).setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    model.moveWhitePiece(iv.get(finalI1).getColumnLetter(), iv.get(finalI1).getRowNumber());
//                    updateView();
//                }
//            });
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
