package view.splashScreenView;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class SplashScreenView extends GridPane {


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


//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//       general nodes
        this.contentCreators = new Label("Program created by Deef and MattiMagic");
        this.version = new Label("version 1");

    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand", null, this.afsluiten);
        final Menu helpMenu = new Menu("Help", null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.add(menuBar, 0, 0,2,1);

//        general content
        this.add(contentCreators, 1, 2);
        this.add(version, 1,2);

        this.setGridLinesVisible(true);

//        constraints & ID

        ColumnConstraints colConstraint1 = new ColumnConstraints();
        colConstraint1.setPercentWidth(50);

        ColumnConstraints colConstraint2 = new ColumnConstraints();
        colConstraint2.setPercentWidth(50);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setPercentHeight(25);
        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setPercentHeight(50);
        RowConstraints rowConstraints3 = new RowConstraints();
        rowConstraints3.setPercentHeight(25);

        this.getColumnConstraints().addAll(colConstraint1,colConstraint2);
        this.getRowConstraints().addAll(rowConstraints1,rowConstraints2,rowConstraints3);

        this.setId("SplashScreen");

    }

}
