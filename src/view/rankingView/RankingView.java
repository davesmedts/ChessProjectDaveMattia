package view.rankingView;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class RankingView extends BorderPane {
    private HBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;

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


    private final TableView table = new TableView();



    TableColumn datumCol;
    TableColumn spelerWitCol;
    TableColumn spelerZwartCol;
    TableColumn winnaarCol;




    public RankingView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        mainContainerNodes
        this.mainContainer = new HBox();
        this.chessLogo = new ImageView("/applicationLogoSmall.png");

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
        this.helpIconsContainer = new HBox(8);
        this.helpIcon = new ImageView("/questionIconGold.png");
        this.settingsIcon = new ImageView("/settingsIconGold.png");
        this.infoIcon = new ImageView("/infoIconGold.png");


        //        statusbar
        this.statusBarText = new Label("designed and build with by Dave Smedts and Mattia Verreydt");


        //columns
        this.datumCol = new TableColumn("Datum");
        this.spelerWitCol = new TableColumn("Player White");
        this.spelerZwartCol = new TableColumn("Player Black");
        this.winnaarCol = new TableColumn("Winnaar");



    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand",null, this.openen, this.opslaan, this.afsluiten);
        final Menu helpMenu = new Menu("Help",null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.setTop(menuBar);

//        MainContainerContent
        table.getColumns().addAll(datumCol, spelerWitCol, spelerZwartCol,winnaarCol);
        mainContainer.getChildren().addAll(table);
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

    public Button getHomeBtn() {
        return homeBtn;
    }
}
