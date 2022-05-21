package view.homeView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class HomeView extends GridPane {
    private VBox mainContainer;
    private HBox helpIconsContainer;

    private Button newGameBtn;
    private Button openenBtn;
    private Button rangschikkingBtn;


    private MenuItem spelregels;
    private MenuItem info;
    private MenuItem instellingen;
    private MenuItem algemeen;
    private MenuItem newGame;
    private MenuItem home;
    private MenuItem rangschikking;
    private MenuItem history;


    private Label titel;

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
        this.rangschikkingBtn = new Button("Rangschikking");
        this.titel = new Label("Welkom bij Chess");
        titel.setId("TitelHomeView");
        this.setId("HomeView");

//        menuNodes
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");
        this.rangschikking = new MenuItem("rangschikking");
        this.history = new MenuItem("Oude spellen");
        this.home = new MenuItem("home");
        this.newGame = new MenuItem("nieuw spel");
        this.instellingen = new MenuItem("instellingen");
        this.algemeen = new MenuItem("algemeen");






//        Icons on the right part of the screen
        this.helpIconsContainer = new HBox(8);
        this.helpIcon = new ImageView("/questionIconGold.png");
        this.settingsIcon = new ImageView("/settingsIconGold.png");
        this.infoIcon = new ImageView("/infoIconGold.png");

//        statusbar
        this.statusBarText = new Label("designed and build with by Dave Smedts and Mattia Verreydt");

    }

    private void layoutNodes() {

//        menu
        final Menu home = new Menu("Home");
        final Menu newGame = new Menu("Nieuw spel",null);
        final Menu rangschikking = new Menu("rangschikking", null);
        final Menu history = new Menu("history",null);
        final Menu Algemeen = new Menu("Algemeen",null,this.instellingen, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(home,newGame,rangschikking,history, Algemeen);


        this.add(menuBar, 0 ,0,4,1);


//        MainContainerContent
        this.newGameBtn.setPrefSize(150, 40);
        this.openenBtn.setPrefSize(150, 40);
        this.rangschikkingBtn.setPrefSize(150, 40);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(20));
        mainContainer.getChildren().addAll(titel, newGameBtn, openenBtn, rangschikkingBtn);
        mainContainer.setAlignment(Pos.TOP_RIGHT);
        this.add(mainContainer, 2 ,2);


//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        helpIconsContainer.setAlignment(Pos.TOP_RIGHT);
        this.add(helpIconsContainer, 3 ,1);

//        statusbar
        statusBarText.setAlignment(Pos.BOTTOM_CENTER);
        this.add(statusBarText,1,3,2,1);



        // column constraints
        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(30);
        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(20);
        ColumnConstraints col3Constraints = new ColumnConstraints();
        col3Constraints.setPercentWidth(30);
        ColumnConstraints col4Constraints = new ColumnConstraints();
        col4Constraints.setPercentWidth(20);
        this.getColumnConstraints().addAll(col1Constraints, col2Constraints, col3Constraints,col4Constraints);


        // constraints Gridpane
        this.setConstraints(menuBar,     0, 0, 4, 1,
                HPos.CENTER,       VPos.TOP,
                Priority.ALWAYS, Priority.ALWAYS);


        this.setConstraints(mainContainer,     2, 2, 1, 1,
                HPos.LEFT,       VPos.CENTER,
                Priority.ALWAYS, Priority.ALWAYS);

        this.setConstraints(helpIconsContainer,     3, 1, 1, 1,
                HPos.LEFT,       VPos.CENTER,
                Priority.ALWAYS, Priority.ALWAYS);


        this.setConstraints(statusBarText,     1, 3, 2, 1,
                HPos.CENTER,       VPos.BOTTOM,
                Priority.ALWAYS, Priority.ALWAYS);

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


    public MenuItem getSpelregels() {
        return spelregels;
    }

    public MenuItem getInfo() {
        return info;
    }

    public MenuItem getInstellingen() {
        return instellingen;
    }

    public MenuItem getNewGame() {
        return newGame;
    }

    public MenuItem getHome() {
        return home;
    }

    public MenuItem getRangschikking() {
        return rangschikking;
    }

    public MenuItem getHistory() {
        return history;
    }
}
