package view.rankingView;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class RankingView extends GridPane {
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
        this.add(menuBar, 0 ,0,3,1);

//        MainContainerContent
        table.getColumns().addAll(datumCol, spelerWitCol, spelerZwartCol,winnaarCol);
        mainContainer.getChildren().addAll(table);
        this.add(mainContainer, 1 ,2);
        datumCol.setPrefWidth(150);
        spelerWitCol.setPrefWidth(150);
        spelerZwartCol.setPrefWidth(150);
        winnaarCol.setPrefWidth(150);





//        leftArea
        leftContainer.getChildren().addAll(chessLogo, homeBtn);
        this.add(leftContainer, 0 ,1);

//      HelpIcons
        helpIconsContainer.getChildren().addAll(settingsIcon, helpIcon, infoIcon);
        this.add(helpIconsContainer, 2 ,1);

        //        statusbar
        this.add(statusBarText,1,3,1,1);

        this.setGridLinesVisible(true);



        // column constraints
        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(30);
        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(40);
        ColumnConstraints col3Constraints = new ColumnConstraints();
        col3Constraints.setPercentWidth(30);

        this.getColumnConstraints().addAll(col1Constraints, col2Constraints, col3Constraints);


        // constraints Gridpane
        this.setConstraints(menuBar,     0, 0, 3, 1,
                HPos.CENTER,       VPos.TOP,
                Priority.ALWAYS, Priority.ALWAYS);


        this.setConstraints(mainContainer,     1, 2, 1, 1,
                HPos.CENTER,       VPos.CENTER,
                Priority.ALWAYS, Priority.ALWAYS);

        this.setConstraints(helpIconsContainer,     2, 1, 1, 1,
                HPos.LEFT,       VPos.CENTER,
                Priority.ALWAYS, Priority.ALWAYS);


        this.setConstraints(statusBarText,     1, 3, 1, 1,
                HPos.CENTER,       VPos.BOTTOM,
                Priority.ALWAYS, Priority.ALWAYS);



    }

    public Button getHomeBtn() {
        return homeBtn;
    }
}
