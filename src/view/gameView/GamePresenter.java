package view.gameView;

import exceptions.IllegalMoveException;
import exceptions.IllegalPieceSelectionException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Board;
import model.Color;
import model.Game;
import model.Square;
import model.chessPieces.Pawn;
import model.chessPieces.Piece;
import view.help.HelpPresenter;
import view.help.HelpView;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;
import view.promotionView.PromotionPresenter;
import view.promotionView.PromotionView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;
import view.settingView.SettingsPresenter;
import view.settingView.SettingsView;
import view.splashScreenView.SplashScreenPresenter;
import view.splashScreenView.SplashScreenView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        view.getHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeView homeView = new HomeView();
                HomePresenter homePresenter = new HomePresenter(model, homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
            }
        });

//      Following part is for adding eventhandles to the chessBoardSquares
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
//                                        if (backendSquare.getSquareContent() != null && backendSquare.getSquareContent().getColor() != model.getTurn() ) {
//                                            frontendSquare.setStyle("-fx-background-color:RED");
//                                        }

                                    }
                                }
                            }
                            selectCounter++;

                        } catch (IllegalPieceSelectionException e) {
//                            if (model.getTurn() == Color.WHITE) {
//                                view.setWhitePlayerFeedback("Selectie niet mogelijk: " + e.getMessage());
//                            } else {
//                                view.setBlackPlayerFeedback("Selectie niet mogelijk: " + e.getMessage());
//                            }
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Selectie niet mogelijk");
                            alert.setContentText(e.getMessage());
                            alert.showAndWait();
                        }

                    } else {
                        try {
                            if (model.getTurn() == Color.WHITE) {
                                model.moveWhitePiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                                Square backendSquare = model.getWhitePlayer().lookupSquare(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                                if (backendSquare.getSquareContent() instanceof Pawn && backendSquare.getRowNumber() == 8) {
//                                    ((Pawn) backendSquare.getSquareContent()).promotePiece();
                                    PromotionView promotionView = new PromotionView();
                                    PromotionPresenter promotionPresenter = new PromotionPresenter(model, promotionView);
                                    promotionPresenter.setPawn((Pawn) backendSquare.getSquareContent());
                                    Stage stage = new Stage();
                                    stage.initOwner(view.getScene().getWindow());
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    Scene promotionScene = new Scene(promotionView, 600, 400);
                                    promotionScene.getStylesheets().add("/stylesheets/generalStyling.css");
                                    stage.setScene(promotionScene);
                                    stage.showAndWait();

                                }
                                model.setTurn(Color.BLACK);
                                model.getSaver().save();
                                if (model.getBlackPlayer().kingLookup(Color.BLACK).isChecked() && !model.getWhitePlayer().isWinner()) {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("SCHAAK!");
                                    alert.setContentText("Zwart staat schaak!");
                                    alert.showAndWait();

                                }

                                if (model.getWhitePlayer().isWinner()) {
                                    model.setGameFinished(true);
                                    model.setWinner(model.getWhitePlayer());
                                    model.getSaver().logHistory();

                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Game over!");
                                    alert.setContentText("schaakmat! " + model.getWhitePlayer().toString() + " wint");
                                    alert.showAndWait();

                                    HomeView homeView = new HomeView();
                                    HomePresenter homePresenter = new HomePresenter(model, homeView);
                                    view.getScene().setRoot(homeView);
                                    homeView.getScene().getWindow().sizeToScene();

                                }


                            } else {
                                model.moveBlackPiece(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                                Square backendSquare = model.getBlackPlayer().lookupSquare(iv.get(finalI).getColumnLetter(), iv.get(finalI).getRowNumber());
                                if (backendSquare.getSquareContent() instanceof Pawn && backendSquare.getRowNumber() == 1) {
//                                    ((Pawn) backendSquare.getSquareContent()).promotePiece();
                                    PromotionView promotionView = new PromotionView();
                                    PromotionPresenter promotionPresenter = new PromotionPresenter(model, promotionView);
                                    promotionPresenter.setPawn((Pawn) backendSquare.getSquareContent());
                                    Stage stage = new Stage();
                                    stage.initOwner(view.getScene().getWindow());
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    Scene promotionScene = new Scene(promotionView, 600, 400);
                                    promotionScene.getStylesheets().add("/stylesheets/generalStyling.css");
                                    stage.setScene(promotionScene);
                                    stage.showAndWait();

                                }

                                model.setTurn(Color.WHITE);
                                model.getSaver().save();
                                if (model.getWhitePlayer().kingLookup(Color.WHITE).isChecked() && !model.getBlackPlayer().isWinner()) {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("SCHAAK!");
                                    alert.setContentText("Wit staat schaak!");
                                    alert.showAndWait();

                                }


                                if (model.getBlackPlayer().isWinner()) {
                                    model.setGameFinished(true);
                                    model.setWinner(model.getBlackPlayer());
                                    model.getSaver().logHistory();

                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Game over!");
                                    alert.setContentText("Schaakmat! " + model.getBlackPlayer().toString() + " wint");
                                    alert.showAndWait();

                                    HomeView homeView = new HomeView();
                                    HomePresenter homePresenter = new HomePresenter(model, homeView);
                                    view.getScene().setRoot(homeView);
                                    homeView.getScene().getWindow().sizeToScene();

                                }
                            }
                            ChessBoardView updatedView = (ChessBoardView) new ChessBoardView().drawBoard(view.getGameChessBoardGrid().getColorOne(), view.getGameChessBoardGrid().getColorTwo());
                            view.setGameChessBoardGrid(updatedView);
                            addEventHandlers();
                            updateView();
                            System.out.println("movePieceMethod");
                            selectCounter++;

                        } catch (IllegalMoveException e) {
//                            if (model.getTurn() == Color.WHITE) {
//                                view.setWhitePlayerFeedback("Zet niet mogelijk: " + e.getMessage());
//                            } else {
//                                view.setBlackPlayerFeedback("Zet niet mogelijk: " + e.getMessage());
//                            }

                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Zet niet mogelijk");
                            alert.setContentText(e.getMessage());
                            alert.showAndWait();
                            ChessBoardView updatedView = (ChessBoardView) new ChessBoardView().drawBoard(view.getGameChessBoardGrid().getColorOne(), view.getGameChessBoardGrid().getColorTwo());
                            view.setGameChessBoardGrid(updatedView);
                            addEventHandlers();
                            updateView();
                            selectCounter--;
                        }
                    }
                }
            });
        }

        view.getHelpIcon().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HelpView helpView = new HelpView();
                HelpPresenter helpPresenter = new HelpPresenter(helpView);
                Stage helpStage = new Stage();
                helpStage.setTitle("Hoe speel je schaak?");
                helpStage.initOwner(view.getScene().getWindow());
                helpStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(helpView);
//                scene.getStylesheets().add("stylesheets/style.css");
                helpStage.setScene(scene);
                helpStage.setX(view.getScene().getWindow().getX());
                helpStage.setY(view.getScene().getWindow().getY() + 100);
                helpStage.showAndWait();
            }
        });


        view.getInfoIcon().setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SplashScreenView splashScreenView = new SplashScreenView();
                SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(model, splashScreenView);
                Stage settingPresenter = new Stage();
                settingPresenter.initOwner(view.getScene().getWindow());
                settingPresenter.initModality(Modality.APPLICATION_MODAL);
                settingPresenter.setScene(new Scene(splashScreenView));
                settingPresenter.setX(view.getScene().getWindow().getX() + 100);
                settingPresenter.setY(view.getScene().getWindow().getY() + 100);
                settingPresenter.showAndWait();

            }

        });

        view.getNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NewGameView newGameView = new NewGameView();
                NewGamePresenter gamePresenter = new NewGamePresenter(model, newGameView);
                view.getScene().setRoot(newGameView);
                newGameView.getScene().getWindow().sizeToScene();

            }
        });


        view.getHistoriek().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RankingView rankingView = new RankingView();
                RankingPresenter presenter = new RankingPresenter(model, rankingView);
                view.getScene().setRoot(rankingView);
                rankingView.getScene().getWindow().sizeToScene();

            }
        });

        view.getHervatSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File("resources/savedGames"));
                fileChooser.setTitle("Load Data File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Textfiles", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(
                        view.getScene().getWindow());
                if ((selectedFile != null)) {
                    System.out.println(selectedFile.getName());
                    String nameWithoutExtension = selectedFile.getName().split("\\.")[0];
                    model.loadGame(nameWithoutExtension);

                    GameView gameView = new GameView(view.getColorOne(), view.getColorTwo());
                    GamePresenter gamePresenter = new GamePresenter(model, gameView);
                    view.getScene().setRoot(gameView);
                    gameView.getScene().getWindow().sizeToScene();

                    gameView.setBlackPlayerName(model.getBlackPlayer().toString());
                    gameView.setWhitePlayerName(model.getWhitePlayer().toString());
                }
            }
        });

    }

    private void updateView() {
        Board backendBoard = model.getGameBoard();
        if (model.getTurn() == Color.WHITE) {
            view.getWhitePlayerName().setStyle("-fx-underline: true; -fx-text-fill: black; -fx-border-width: 3px;");
            view.getBlackPlayerName().setStyle("-fx-underline: false; -fx-text-fill: #858383; -fx-border-width: 1px;");
        } else {
            view.getBlackPlayerName().setStyle("-fx-underline: true; -fx-text-fill: black; -fx-border-width: 3px;");
            view.getWhitePlayerName().setStyle("-fx-underline: false; -fx-text-fill: #858383; -fx-border-width: 1px;");

        }

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

        List<String> whiteCapturedPieces = model.getWhitePlayer().getCapturedPieces();
        view.getWhiteCapturedPieces().getChildren().clear();
        for (String whitePiece : whiteCapturedPieces) {
            ImageView pieceImage = getPieceImage(whitePiece);
            view.getWhiteCapturedPieces().getChildren().add(pieceImage);
        }
        List<String> blackCapturedPieces = model.getBlackPlayer().getCapturedPieces();
//        view.getBlackCapturedPieces().getChildren().clear();
        for (String blackPiece : blackCapturedPieces) {
            ImageView pieceImage = getPieceImage(blackPiece);
            view.getBlackCapturedPieces().getChildren().add(pieceImage);
        }
    }

    private ImageView getPieceImage(String pieceName) {
        ImageView image = null;
        switch (pieceName) {
            case "Knightblack":
                image = new ImageView("/Knightblack.png");
                break;
            case "Kingblack":
                image = new ImageView("/Kingblack.png");
                break;
            case "Queenblack":
                image = new ImageView("/Queenblack.png");
                break;
            case "Pawnblack":
                image = new ImageView("/Pawnblack.png");
                break;
            case "Rookblack":
                image = new ImageView("/Rookblack.png");
                break;
            case "Bishopblack":
                image = new ImageView("/BishopBlack.png");
                break;
            case "Knightwhite":
                image = new ImageView("Knightwhite.png");
                break;
            case "Kingwhite":
                image = new ImageView("Kingwhite.png");
                break;
            case "Queenwhite":
                image = new ImageView("Queenwhite.png");
                break;
            case "Pawnwhite":
                image = new ImageView("Pawnwhite.png");
                break;
            case "Rookwhite":
                image = new ImageView("Rookwhite.png");
                break;
            case "Bishopwhite":
                image = new ImageView("Bishopwhite.png");
                break;
        }
        image.setFitHeight(40);
        image.setPreserveRatio(true);
        image.setSmooth(true);
        return image;
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
