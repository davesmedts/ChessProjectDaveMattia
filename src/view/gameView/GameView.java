package view.gameView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;


public class GameView extends BorderPane {
    private VBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;
    private HBox whiteCapturedPieces;
    private HBox blackCapturedPieces;

    private Button homeBtn;

    private MenuItem afsluiten;
    private MenuItem opslaan;
    private MenuItem openen;
    private MenuItem spelregels;
    private MenuItem info;

    private ImageView chessLogo;

    private ImageView helpIcon;
    private ImageView infoIcon;
    private ImageView settingsIcon;

    private Label statusBarText;
    private Label whitePlayerName;
    private Label blackPlayerName;
    private Label whitePlayerFeedback;
    private Label blackPlayerFeedback;

    private ChessBoardView gameChessBoardGrid;
    private List<ChessBoardSquare> chessBoardSquares;


    public Button getHomeBtn() {
        return homeBtn;
    }

    public ImageView getChessLogo() {
        return chessLogo;
    }

    public ChessBoardView getGameChessBoardGrid() {
        return gameChessBoardGrid;
    }

    public void setGameChessBoardGrid(ChessBoardView gameChessBoardGrid) {
        this.gameChessBoardGrid = gameChessBoardGrid;
        gameChessBoardGrid.setAlignment(Pos.CENTER);
        this.chessBoardSquares = gameChessBoardGrid.getGameSquares();
        this.blackCapturedPieces = new HBox();
        this.whiteCapturedPieces = new HBox();
        blackCapturedPieces.setAlignment(Pos.CENTER);
        whiteCapturedPieces.setAlignment(Pos.CENTER);
        mainContainer.getChildren().clear();
        mainContainer.getChildren().addAll(blackPlayerName,blackPlayerFeedback,blackCapturedPieces, gameChessBoardGrid, whitePlayerName, whitePlayerFeedback,whiteCapturedPieces);

    }

    public GameView(String colorOne, String colorTwo) {
        this.initialiseNodes(colorOne,colorTwo);
        this.layoutNodes();
    }

    public void initialiseNodes(String colorOne, String colorTwo) {

//        mainContainerNodes
        this.mainContainer = new VBox();
        this.chessLogo = new ImageView("/applicationLogoSmall.png");
        gameChessBoardGrid = (ChessBoardView)new ChessBoardView().drawBoard(colorOne, colorTwo);
        whitePlayerName = new Label();
        blackPlayerName = new Label();
        whitePlayerFeedback = new Label();
        blackPlayerFeedback = new Label();
        whiteCapturedPieces = new HBox();
        blackCapturedPieces = new HBox();


        chessBoardSquares = gameChessBoardGrid.getGameSquares();



//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.openen = new MenuItem("openen");
        this.opslaan = new MenuItem("opslaan");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        left area nodes
        this.leftContainer = new VBox();
        this.homeBtn = new Button("Home page");

//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox();
        this.helpIcon = new ImageView("/questionIcon.png");
        this.settingsIcon = new ImageView("/infoIcon.png");
        this.infoIcon = new ImageView("/settingsIcon.png");

        //        statusbar
        this.statusBarText = new Label("designed and build with by Dave Smedts and Mattia Verreydt");


    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand", null, this.openen, this.opslaan, this.afsluiten);
        final Menu helpMenu = new Menu("Help", null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);

//        MainContainerContent
        mainContainer.setAlignment(Pos.TOP_CENTER);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(10));
        mainContainer.getChildren().addAll(blackPlayerName,blackPlayerFeedback,blackCapturedPieces, gameChessBoardGrid, whitePlayerName, whitePlayerFeedback,whiteCapturedPieces);
        gameChessBoardGrid.setAlignment(Pos.CENTER);
        blackCapturedPieces.setAlignment(Pos.CENTER);
        whiteCapturedPieces.setAlignment(Pos.CENTER);

        this.setCenter(mainContainer);

//        leftArea
        leftContainer.getChildren().addAll(chessLogo, homeBtn);
        this.setLeft(leftContainer);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

        //        statusbar
        this.setBottom(statusBarText);

    }

    public List<ChessBoardSquare> getChessBoardSquares() {
        return chessBoardSquares;
    }

    public void setChessBoardSquares(List<ChessBoardSquare> chessBoardSquares) {
        this.chessBoardSquares = chessBoardSquares;
    }

    public void setWhitePlayerName(String whitePlayerName) {
        this.whitePlayerName.setText(whitePlayerName);
    }

    public void setBlackPlayerName(String blackPlayerName) {
        this.blackPlayerName.setText(blackPlayerName);
    }

    public void setWhitePlayerFeedback(String feedback) {
        this.whitePlayerFeedback.setText(feedback);
    }

    public void setBlackPlayerFeedback(String feedback) {
        this.blackPlayerFeedback.setText(feedback);
    }

    public VBox getMainContainer() {
        return mainContainer;
    }

    public HBox getWhiteCapturedPieces() {
        return whiteCapturedPieces;
    }

    public HBox getBlackCapturedPieces() {
        return blackCapturedPieces;
    }
}



