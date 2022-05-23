package view.newGameView;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class NewGameView extends BorderPane {
    private VBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;
    private VBox saveContainer;
    private GridPane GridPane;

    private Button startSpel;
    private Button applyPlayerOne;
    private Button applyPlayerTwo;

    private HBox menuContainer;

    private Button newGame;
    private Button home;
    private Button hervatSpel;
    private Button geschiedenis;

    private Label titel;

    private ImageView helpIcon;
    private ImageView infoIcon;
    private ImageView settingsIcon;

    private Label statusBarText;
    private Label description;
    private Label naamPlayerWhite;
    private Label naamPlayerBlack;

    private TextField tekstPlayerOne;
    private TextField tekstPlayerTwo;

    public static String colorOne = "#57271d";
    public static String colorTwo = "#ecddc8";

    public String getColorOne() {
        return colorOne;
    }

    public String getColorTwo() {
        return colorTwo;
    }


    public ImageView getHelpIcon() {
        return helpIcon;
    }

    public ImageView getInfoIcon() {
        return infoIcon;
    }

    public ImageView getSettingsIcon() {
        return settingsIcon;
    }

    public NewGameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }


    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new VBox();
        this.titel = new Label("Nieuw spel");
        this.description = new Label("Voer hier de naam van de spelers in");
        this.naamPlayerWhite = new Label("");
        this.naamPlayerBlack = new Label("");
        this.tekstPlayerOne = new TextField();
        this.tekstPlayerTwo = new TextField();
        this.startSpel = new Button("Start spel");
        this.applyPlayerOne = new Button("Save");
        this.applyPlayerTwo = new Button(("Save"));
        this.GridPane = new GridPane();

        titel.setId("titel");



        //vbox
        this.saveContainer = new VBox(5);


//        menuNodes
        this.hervatSpel = new Button("HERVAT SPEL");
        this.home = new Button("HOME");
        this.newGame = new Button("NIEUW SPEL");
        this.geschiedenis = new Button("HISTORIEK");

//        left area nodes
        this.leftContainer = new VBox();


//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox(8);
        this.helpIcon = new ImageView("/questionIconGold.png");
        this.settingsIcon = new ImageView("/settingsIconGold.png");
        this.infoIcon = new ImageView("/infoIconGold.png");


//        statusbar
        this.statusBarText = new Label("designed and build by Dave Smedts and Mattia Verreydt");

        this.setId("NewGameView");


        this.menuContainer = new HBox(100);

    }


    private void layoutNodes() {

//        menu
        menuContainer.getChildren().addAll(home, newGame, hervatSpel, geschiedenis);
        menuContainer.setId("menuContainer");
        this.setTop(menuContainer);

//        MainContainerContent
        this.tekstPlayerOne.setMaxWidth(200);
        this.tekstPlayerTwo.setMaxWidth(200);
        mainContainer.getChildren().addAll(description, naamPlayerWhite, tekstPlayerOne, naamPlayerBlack, tekstPlayerTwo, startSpel, saveContainer);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setSpacing(25);
        this.setCenter(mainContainer);


//        leftArea
        leftContainer.getChildren().addAll(titel);
        this.setLeft(leftContainer);
        leftContainer.setSpacing(25);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

        //        statusbar
        this.setBottom(statusBarText);

        this.setId("NewGameView");

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

    public TextField getTekstPlayerOne() {
        return tekstPlayerOne;
    }

    public TextField getTekstPlayerTwo() {
        return tekstPlayerTwo;
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

    public Button getGeschiedenis() {
        return geschiedenis;
    }
}
