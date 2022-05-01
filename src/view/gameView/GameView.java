package view.gameView;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class GameView extends BorderPane {
    private VBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;

    private Button homeBtn;
    private Button stopSpelBtn;
    private Button opslaanBtn;

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

    private GridPane gameChessBoard;


    private ImageView knight;


    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes

        this.chessLogo = new ImageView("/applicationLogoSmall.png");
        this.knight = new ImageView("/chess-knight-solid2.png");
        gameChessBoard = new ChessBoardView().drawBoard();



//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.openen = new MenuItem("openen");
        this.opslaan = new MenuItem("opslaan");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        left area nodes
        this.leftContainer = new VBox();
        this.homeBtn = new Button("Home page");
        this.opslaanBtn = new Button("opslaan");
        this.stopSpelBtn = new Button("Stop spel");

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

        this.setCenter(knight);
        this.setCenter(gameChessBoard);

//        leftArea
        leftContainer.getChildren().addAll(chessLogo, homeBtn, opslaanBtn, stopSpelBtn);
        this.setLeft(leftContainer);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

        //        statusbar
        this.setBottom(statusBarText);

    }


}



