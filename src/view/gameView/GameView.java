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

    private HBox menuContainer;

    private Button newGame;
    private Button home;
    private Button hervatSpel;
    private Button historiek;

    private ImageView helpIcon;
    private ImageView infoIcon;

    private Label statusBarText;
    private Label whitePlayerName;
    private Label blackPlayerName;
    private Label titel;


    public static String colorOne = "#57271d";
    public static String colorTwo = "#ecddc8";


    private ChessBoardView gameChessBoardGrid;
    private List<ChessBoardSquare> chessBoardSquares;


    public ChessBoardView getGameChessBoardGrid() {
        return gameChessBoardGrid;
    }

    public Label getWhitePlayerName() {
        return whitePlayerName;
    }

    public Label getBlackPlayerName() {
        return blackPlayerName;
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
        mainContainer.getChildren().addAll(blackPlayerName,blackCapturedPieces, gameChessBoardGrid, whitePlayerName, whiteCapturedPieces);
    }

    public GameView(String colorOne, String colorTwo) {
        this.initialiseNodes(colorOne,colorTwo);
        this.layoutNodes();
    }

    public void initialiseNodes(String colorOne, String colorTwo) {

//        mainContainerNodes
        this.mainContainer = new VBox();
        gameChessBoardGrid = (ChessBoardView)new ChessBoardView().drawBoard(colorOne, colorTwo);
        whitePlayerName = new Label();
        whitePlayerName.setId("playerNameGameView");
        blackPlayerName = new Label();
        blackPlayerName.setId("playerNameGameView");
        whiteCapturedPieces = new HBox();
        blackCapturedPieces = new HBox();


        chessBoardSquares = gameChessBoardGrid.getGameSquares();

        this.setId("gameView");


//        menuNodes
        this.menuContainer = new HBox(100);

        this.hervatSpel = new Button("HERVAT SPEL");
        this.home = new Button("HOME");
        this.newGame = new Button("NIEUW SPEL");
        this.historiek = new Button("HISTORIEK");

        menuContainer.setId("menuContainer");
        menuContainer.getChildren().addAll(home, newGame, hervatSpel, historiek);

//        left area nodes
        this.leftContainer = new VBox();
        this.titel = new Label("Schaakspel");


//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox();
        this.helpIcon = new ImageView("/questionIconGold.png");
        this.infoIcon = new ImageView("/infoIconGold.png");

        //        statusbar
        this.statusBarText = new Label("designed and build with by Dave Smedts and Mattia Verreydt");
    }

    private void layoutNodes() {




//        menu
        this.setTop(menuContainer);

//        MainContainerContent
        mainContainer.setAlignment(Pos.TOP_CENTER);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(10));
        mainContainer.getChildren().addAll(blackPlayerName,blackCapturedPieces, gameChessBoardGrid, whitePlayerName, whiteCapturedPieces);
        gameChessBoardGrid.setAlignment(Pos.CENTER);
        blackCapturedPieces.setAlignment(Pos.CENTER);
        whiteCapturedPieces.setAlignment(Pos.CENTER);

        this.setCenter(mainContainer);

//        leftArea
        leftContainer.getChildren().addAll(titel);
        titel.setId("titel");
        this.setLeft(leftContainer);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(helpIcon, infoIcon);
        this.setRight(helpIconsContainer);


        //        statusbar
        this.setBottom(statusBarText);


        // padding
        helpIconsContainer.setPadding(new Insets(10,50, 0, 50));
        titel.setPadding(new Insets(10,50, 0, 50));
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

    public VBox getMainContainer() {
        return mainContainer;
    }

    public HBox getWhiteCapturedPieces() {
        return whiteCapturedPieces;
    }

    public HBox getBlackCapturedPieces() {
        return blackCapturedPieces;
    }

    public Button getNewGame() {
        return newGame;
    }

    public Button getHome() {
        return home;
    }

    public Button getHervatSpel() {
        return hervatSpel;
    }

    public Button getHistoriek() {
        return historiek;
    }

    public ImageView getHelpIcon() {
        return helpIcon;
    }

    public ImageView getInfoIcon() {
        return infoIcon;
    }

    public static String getColorOne() {
        return colorOne;
    }

    public static String getColorTwo() {
        return colorTwo;
    }
}



