package view.gameView;

import exceptions.IllegalMoveException;
import exceptions.IllegalPieceSelectionException;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Board;
import model.Color;
import model.Game;
import model.Square;
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
    private char selectionColumn;
    private int selectionRow;


    public GamePresenter(Game model, GameView view) {
        this.model = model;
        this.view = view;
        this.updateView();
        this.addEventHandlers();
    }

    private void addEventHandlers() {

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

                        try {
                            if (model.getTurn() == Color.WHITE) {
                                backendValidMoveSquares.addAll(model.selectWhitePiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber()));
                            } else {
                                backendValidMoveSquares.addAll(model.selectBlackPiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber()));
                            }
                            List<ChessBoardSquare> frontendSquares = view.getChessBoardSquares();
                            frontEndSquare.setStyle("-fx-background-color: BLUE");
                            selectionColumn = frontEndSquare.getColumnLetter();
                            selectionRow = frontEndSquare.getRowNumber();

                            for (Square backendSquare : backendValidMoveSquares) {
                                for (ChessBoardSquare frontendSquare : frontendSquares) {
                                    if (backendSquare.getRowNumber() == frontendSquare.getRowNumber() && backendSquare.getColumnLetter() == frontendSquare.getColumnLetter()) {
                                        frontendSquare.setStyle("-fx-background-color:GREEN");
                                    }
                                }
                            }
                            selectCounter++;

                        } catch (IllegalPieceSelectionException e) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Selectie niet mogelijk");
                            alert.setContentText(e.getMessage());
                            alert.showAndWait();
                        }

                    } else {
                        try {
                            if (model.getTurn() == Color.WHITE) {
                                model.moveWhitePiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                                model.setTurn(Color.BLACK);
                                model.getSaver().save();

                                if (model.getWhitePlayer().isWinner()) {
                                    model.setGameFinished(true);
                                    model.setWinner(model.getWhitePlayer());
                                    model.getSaver().logHistory();

                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Game over!");
                                    alert.setContentText(model.getWhitePlayer().toString() + " wint");
                                    alert.showAndWait();
                                }


                            } else {
                                model.moveBlackPiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                                model.setTurn(Color.WHITE);
                                model.getSaver().save();

                                if (model.getBlackPlayer().isWinner()) {
                                    model.setGameFinished(true);
                                    model.setWinner(model.getBlackPlayer());
                                    model.getSaver().logHistory();

                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Game over!");
                                    alert.setContentText(model.getBlackPlayer().toString() + " wint");
                                    alert.showAndWait();
                                }
                            }
                            ChessBoardView updatedView = (ChessBoardView) new ChessBoardView().drawBoard(view.getGameChessBoardGrid().getColorOne(), view.getGameChessBoardGrid().getColorTwo());
                            view.setGameChessBoardGrid(updatedView);
                            view.setCenter(updatedView);
                            addEventHandlers();
                            updateView();
                            System.out.println("movePieceMethod");
                            selectCounter++;

                        } catch (IllegalMoveException e) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Zet niet mogelijk");
                            alert.setContentText(e.getMessage());
                            alert.showAndWait();
                        }
                    }
                }
            });


        }
    }

//    private void removeImage() {
//        List<ChessBoardSquare> frontendSquares = view.getChessBoardSquares();
//        for (int i = 0; i < frontendSquares.size(); i++) {
//            if (frontendSquares.get(i).getColumnLetter() == selectionColumn && frontendSquares.get(i).getRowNumber() == selectionRow) {
//                int index = i;
//                ChessBoardSquare replacementSquare = new ChessBoardSquare(selectionRow, selectionColumn);
//                frontendSquares.set(index, replacementSquare);
//            }
//        }
//
//    }


    private void updateView() {
        Board backendBoard = model.getGameBoard();

        List<Square> backendSquares = backendBoard.getSquares();
        List<ChessBoardSquare> frontendSquares = view.getChessBoardSquares();

        for (Square backendSquare : backendSquares) {
            for (ChessBoardSquare frontendSquare : frontendSquares) {
                if (backendSquare.getRowNumber() == frontendSquare.getRowNumber() && backendSquare.getColumnLetter() == frontendSquare.getColumnLetter()) {
                    frontendSquare.setStyle("-fx-background-color: " + frontendSquare.getColorOneInitial());
                    if (backendSquare.getSquareContent() != null) {
                        String piece = backendSquare.getSquareContent().toString();
                        frontendSquare.setContent(piece);
                    }
                }
            }
        }
    }


    //    private void draggable(Node node) {
//        final Position pos = new Position();
//
//        //Prompt the user that the node can be clicked
//        node.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> node.setCursor(Cursor.HAND));
//        node.addEventHandler(MouseEvent.MOUSE_EXITED, event -> node.setCursor(Cursor.DEFAULT));
//
//        //Prompt the user that the node can be dragged
//        node.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
//            node.setCursor(Cursor.MOVE);
//
//            //When a press event occurs, the location coordinates of the event are cached
//            pos.x = event.getX();
//            pos.y = event.getY();
//        });
//
//        node.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> node.setCursor(Cursor.DEFAULT));
//
//        //Realize drag and drop function
//        node.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
//            double distanceX = event.getX() - pos.x;
//            double distanceY = event.getY() - pos.y;
//
//            double x = node.getLayoutX() + distanceX;
//            double y = node.getLayoutY() + distanceY;
//
//            //After calculating X and y, relocate the node to the specified coordinate point (x, y)
//            node.relocate(x, y);
//        });
//    }


}
