package view.homeView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class HomeView extends BorderPane {
    private GridPane GridPane;
    private VBox mainContainer;
    private HBox helpIconsContainer;

    private Button newGameBtn;
    private Button openenBtn;
    private Button rangschikkingBtn;

    private HBox menuContainer;

    private Button newGame;
    private Button home;
    private Button hervatSpel;
    private Button historiek;

    private Label titel;
    private Label welkom;


    private ImageView helpIcon;
    private ImageView infoIcon;
    private ImageView settingsIcon;

    private Label statusBarText;

    String colorOne = "#57271d";
    String colorTwo = "#ecddc8";

    public String getColorOne() {
        return colorOne;
    }

    public String getColorTwo() {
        return colorTwo;
    }

    public HomeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new VBox();
        this.newGameBtn = new Button("nieuw spel");
        this.openenBtn = new Button("hervat spel");
        this.rangschikkingBtn = new Button("historiek");
        this.welkom = new Label("Welkom bij Chess");
        welkom.setId("TitelHomeView");
        this.setId("HomeView");

        this.titel = new Label("Home");
        titel.setId("titel");

//        menuNodes

        this.menuContainer = new HBox(100);

        this.hervatSpel = new Button("HERVAT SPEL");
        this.home = new Button("HOME");
        this.newGame = new Button("NIEUW SPEL");
        this.historiek = new Button("HISTORIEK");






//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox(8);
        this.helpIcon = new ImageView("/questionIconGold.png");
        this.settingsIcon = new ImageView("/settingsIconGold.png");
        this.infoIcon = new ImageView("/infoIconGold.png");

//        statusbar
        this.statusBarText = new Label("designed and build by Dave Smedts and Mattia Verreydt");

    }

    private void layoutNodes() {
        this.setLeft(titel);

//        menu
        menuContainer.getChildren().addAll(home, newGame, hervatSpel, historiek);
        menuContainer.setId("menuContainer");

        this.setTop(menuContainer);


//        MainContainerContent
        this.newGameBtn.setPrefSize(150, 40);
        this.openenBtn.setPrefSize(150, 40);
        this.rangschikkingBtn.setPrefSize(150, 40);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(20));
        mainContainer.getChildren().addAll(welkom, newGameBtn, openenBtn, rangschikkingBtn);
        mainContainer.setAlignment(Pos.TOP_RIGHT);
        this.GridPane = new GridPane();
        this.setCenter(GridPane);
        GridPane.add(mainContainer,1,1);




//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        helpIconsContainer.setAlignment(Pos.TOP_RIGHT);
        this.setRight(helpIconsContainer);


//        statusbar
        statusBarText.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(statusBarText);

        // column constraints
        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(40);
        ColumnConstraints col4Constraints = new ColumnConstraints();
        col4Constraints.setPercentWidth(60);
        GridPane.getColumnConstraints().addAll(col1Constraints, col4Constraints);

        RowConstraints rowConstraint1 = new RowConstraints();
        rowConstraint1.setPercentHeight(7);
        rowConstraint1.setMaxHeight(100);
        RowConstraints rowConstraint2 = new RowConstraints();
        rowConstraint2.setPercentHeight(35);
        RowConstraints rowConstraint3 = new RowConstraints();
        rowConstraint3.setPercentHeight(35);
        RowConstraints rowConstraint4 = new RowConstraints();
        rowConstraint4.setPercentHeight(15);
        GridPane.getRowConstraints().addAll(rowConstraint1,rowConstraint2,rowConstraint3,rowConstraint4);


        // constraints Gridpane
        GridPane.setConstraints(mainContainer, 1, 2, 1, 1,
                HPos.LEFT, VPos.CENTER,
                Priority.ALWAYS, Priority.ALWAYS);


        // padding
        helpIconsContainer.setPadding(new Insets(10,50, 0, 50));
        titel.setPadding(new Insets(10,50, 0, 50));
    }

    public Button getNewGameBtn() {
        return newGameBtn;
    }

    public Button getRangschikkingBtn() {
        return rangschikkingBtn;
    }

    public Button getOpenenBtn() {
        return openenBtn;
    }

    public ImageView getHelpIcon() {
        return helpIcon;
    }

    public ImageView getSettingsIcon() {
        return settingsIcon;
    }

    public ImageView getInfoIcon() {
        return infoIcon;
    }

    public Button getNewGame() {
        return newGame;
    }

    public Button getHome() {
        return home;
    }

    public Button getOudeSpellen() {
        return hervatSpel;
    }

    public Button getGeschiedenis() {
        return historiek;
    }

    public Button getHervatSpel() {
        return hervatSpel;
    }
}
