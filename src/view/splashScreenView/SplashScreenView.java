package view.splashScreenView;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class SplashScreenView extends GridPane {
   private VBox mainContainer;
    private VBox leftContainer;

    private Button homeBtn;

    private MenuItem afsluiten;
    private MenuItem spelregels;
    private MenuItem info;

    private Label contentCreators;
    private Label version;


    public SplashScreenView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {

//        mainContainerNodes
        this.mainContainer = new VBox();


//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//        left area nodes
        this.leftContainer = new VBox();
        this.homeBtn = new Button("Home page");
        this.contentCreators = new Label("Program created by Deef and MattiMagic");
        this.version = new Label("version 1");

    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand",null, this.afsluiten);
        final Menu helpMenu = new Menu("Help",null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.add(menuBar,0,0);

//        MainContainerContent
        mainContainer.getChildren().addAll(contentCreators);
        mainContainer.setSpacing(20);
        mainContainer.setAlignment(Pos.CENTER);
        this.add(mainContainer,0,1);


//        leftArea
        leftContainer.getChildren().addAll( homeBtn);
        this.add(leftContainer,0,2);

        this.setId("SplashScreen");

    }

    public Button getHomeBtn() {
        return homeBtn;
    }
}
