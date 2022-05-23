package view.rankingView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;


public class RankingView extends BorderPane {
    private HBox mainContainer;
    private HBox helpIconsContainer;
    private VBox leftContainer;

    private HBox menuContainer;

    private Button newGame;
    private Button home;
    private Button hervatSpel;
    private Button historiek;


    private ImageView helpIcon;
    private ImageView infoIcon;
    private ImageView settingsIcon;

    private Label statusBarText;
    private Label titel;

    private final TableView table = new TableView();

    TableColumn datumCol;
    TableColumn spelerWitCol;
    TableColumn spelerZwartCol;
    TableColumn winnaarCol;

    public static String colorOne = "#57271d";
    public static String colorTwo = "#ecddc8";


    public RankingView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        //add data
        this.setId("RankingView");



//        mainContainerNodes
        this.mainContainer = new HBox();

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
        this.titel = new Label("Historiek");



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
        this.setTop(menuContainer);

//        MainContainerContent
        table.getColumns().addAll(datumCol, spelerWitCol, spelerZwartCol,winnaarCol);
        mainContainer.getChildren().addAll(table);
        this.setCenter(mainContainer);
        datumCol.setPrefWidth(150);
        spelerWitCol.setPrefWidth(150);
        spelerZwartCol.setPrefWidth(150);
        winnaarCol.setPrefWidth(150);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setMaxWidth(600);
        mainContainer.setMaxHeight(500);


////        leftArea
//        this.add(leftContainer, 0 ,1);
        titel.setId("titel");
        leftContainer.getChildren().addAll(titel);
        this.setLeft(leftContainer);


//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.setRight(helpIconsContainer);

        //        statusbar
        this.setBottom(statusBarText);
        statusBarText.setAlignment(Pos.CENTER);

        // padding
        helpIconsContainer.setPadding(new Insets(10,50, 0, 50));
        titel.setPadding(new Insets(10,50, 0, 50));
    }



    public TableView getTable() {
        return table;
    }

    public TableColumn getDatumCol() {
        return datumCol;
    }

    public TableColumn getSpelerWitCol() {
        return spelerWitCol;
    }

    public TableColumn getSpelerZwartCol() {
        return spelerZwartCol;
    }

    public TableColumn getWinnaarCol() {
        return winnaarCol;
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

    public static String getColorOne() {
        return colorOne;
    }

    public static String getColorTwo() {
        return colorTwo;
    }
}
