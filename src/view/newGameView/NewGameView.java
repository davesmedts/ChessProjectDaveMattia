package view.newGameView;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class NewGameView extends BorderPane {
    private VBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;
    private VBox saveContainer;


    private Button homeBtn;
    private Button startSpel;
    private Button applyPlayerOne;
    private Button applyPlayerTwo;


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
    private Label description;
    private Label naamPlayerWhite;
    private Label naamPlayerBlack;

    private TextField tekstPlayerWhite;
    private TextField tekstPlayerBlack;

    public static String colorOne = "#57271d";
    public static String colorTwo = "#ecddc8";

    public String getColorOne() {
        return colorOne;
    }

    public String getColorTwo() {
        return colorTwo;
    }


    public NewGameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new VBox();
        this.chessLogo = new ImageView("/applicationLogoSmall.png");
        this.description = new Label("Voer hier de naam van de spelers in");
        this.naamPlayerWhite = new Label("Speler 1:");
        this.naamPlayerBlack = new Label("Speler 2");
        this.tekstPlayerWhite = new TextField();
        this.tekstPlayerBlack = new TextField();
        this.startSpel = new Button("Start spel");
        this.applyPlayerOne = new Button("Save");
        this.applyPlayerTwo = new Button(("Save"));

        //hbox
        this.saveContainer = new VBox(5);




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

        this.setId("NewGameView");

    }


    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand", null, this.openen, this.opslaan, this.afsluiten);
        final Menu helpMenu = new Menu("Help", null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);

//        MainContainerContent
        this.tekstPlayerWhite.setMaxWidth(200);
        this.tekstPlayerBlack.setMaxWidth(200);
        mainContainer.getChildren().addAll(description, naamPlayerWhite, tekstPlayerWhite, naamPlayerBlack, tekstPlayerBlack, startSpel);
        mainContainer.setAlignment(Pos.CENTER_RIGHT);
        mainContainer.setSpacing(25);
        this.setCenter(mainContainer);

        // saveContainer
        saveContainer.getChildren().addAll(applyPlayerOne, applyPlayerTwo);
        saveContainer.setAlignment(Pos.CENTER_LEFT);
        this.setCenter(saveContainer);

//        leftArea
        leftContainer.getChildren().addAll(chessLogo, homeBtn);
        this.setLeft(leftContainer);
        leftContainer.setSpacing(25);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

        //        statusbar
        this.setBottom(statusBarText);

    }

    public Button getHomeBtn() {
        return homeBtn;
    }

    public Button getStartSpel() {
        return startSpel;
    }

    public Button getApplyPlayerOne() {
        return applyPlayerOne;
    }

    public Button getApplyPlayerTwo() {
        return applyPlayerTwo;
    }

    public TextField getTekstPlayerWhite() {
        return tekstPlayerWhite;
    }

    public TextField getTekstPlayerBlack() {
        return tekstPlayerBlack;
    }
}
