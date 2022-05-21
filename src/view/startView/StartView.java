package view.startView;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import view.splashScreenView.LoadBarTransition;

/**
 * @author Mattia Verreydt
 * @version 1.0 19-5-2022 20:56
 */
public class StartView extends GridPane {
    private MenuItem afsluiten;
    private MenuItem spelregels;
    private MenuItem info;

    private HBox hbox;
    private Label version;
    private Text program;
    private Text created;
    private Text by;
    private Text deef;
    private Text and;
    private Text mattimagic;

    private ProgressBar loadBar;

    private VBox vbox;
    private Label loading;


    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
        animatie();
    }

    private void initialiseNodes() {

        //progress bar
        loadBar = new ProgressBar();


//        menuNodes
        this.afsluiten = new MenuItem("afsluiten");
        this.spelregels = new MenuItem("spelregels");
        this.info = new MenuItem("info");

//       general nodes
        this.vbox = new VBox();
        this.loading = new Label("Loading... please wait");
        this.hbox = new HBox();
        this.program = new Text("program ");
        this.by = new Text("by ");
        this.created = new Text("created ");
        this.deef = new Text("Deef ");
        this.and = new Text("and ");
        this.mattimagic = new Text("MattiMagic");
        program.setFill(Color.WHITE);
        program.setFont(Font.font(null, FontWeight.BOLD, 20));
        by.setFill(Color.WHITE);
        by.setFont(Font.font(null, FontWeight.BOLD, 20));
        created.setFill(Color.WHITE);
        created.setFont(Font.font(null, FontWeight.BOLD, 20));
        deef.setFill(Color.WHITE);
        deef.setFont(Font.font(null, FontWeight.BOLD, 20));
        and.setFill(Color.WHITE);
        and.setFont(Font.font(null, FontWeight.BOLD, 20));
        mattimagic.setFill(Color.WHITE);
        mattimagic.setFont(Font.font(null, FontWeight.BOLD, 20));

        hbox.getChildren().addAll(program, created, by, deef, and, mattimagic);
        vbox.getChildren().addAll(loading, loadBar);


        this.version = new Label("version 1");
        version.setStyle("-fx-text-fill: white");

        this.setBackground(new Background(
                new BackgroundImage(
                        new Image("splashscreenImage.jpg"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(
                                Side.LEFT, 0.0, true, Side.BOTTOM, 0.0, true),
                        new BackgroundSize(100, 100, true, true, false, true)
                )));


    }

    private void layoutNodes() {

//        menu
        final Menu bestandMenu = new Menu("Bestand", null, this.afsluiten);
        final Menu helpMenu = new Menu("Help", null, this.spelregels, this.info);
        final MenuBar menuBar = new MenuBar(bestandMenu, helpMenu);
        this.add(menuBar, 0, 0, 3, 1);

//        general content
        this.add(hbox, 1, 1);
        this.add(vbox, 1, 1);
        this.add(version, 2, 2);

        this.setGridLinesVisible(true);

//        constraints & ID

        ColumnConstraints colConstraint1 = new ColumnConstraints();
        colConstraint1.setPercentWidth(34);

        ColumnConstraints colConstraint2 = new ColumnConstraints();
        colConstraint2.setPercentWidth(33);

        ColumnConstraints colConstraint3 = new ColumnConstraints();
        colConstraint3.setPercentWidth(33);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setPercentHeight(25);
        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setPercentHeight(50);
        RowConstraints rowConstraints3 = new RowConstraints();
        rowConstraints3.setPercentHeight(25);

        this.getColumnConstraints().addAll(colConstraint1, colConstraint2, colConstraint3);
        this.getRowConstraints().addAll(rowConstraints1, rowConstraints2, rowConstraints3);


        this.setConstraints(menuBar, 0, 0, 3, 1,
                HPos.CENTER, VPos.TOP,
                Priority.ALWAYS, Priority.ALWAYS);

        this.setConstraints(version, 2, 2, 3, 1,
                HPos.LEFT, VPos.BOTTOM,
                Priority.ALWAYS, Priority.ALWAYS);


        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        // refection
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        hbox.setEffect(reflection);


    }


    public void animatie() {

        // progressbar

        LoadBarTransition trans = new LoadBarTransition(this);
        trans.play();


// fade 1
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1), program);
        fadeTransition1.setFromValue(0.0);
        fadeTransition1.setToValue(1.0);


        //fade 2
        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), created);
        fadeTransition2.setFromValue(0.0);
        fadeTransition2.setToValue(1.0);


        //fade 3
        FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(1), by);
        fadeTransition3.setFromValue(0.0);
        fadeTransition3.setToValue(1.0);


        //fade 4
        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(1), deef);
        fadeTransition4.setFromValue(0.0);
        fadeTransition4.setToValue(1.0);


        //fade 5
        FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(1), and);
        fadeTransition5.setFromValue(0.0);
        fadeTransition5.setToValue(1.0);


        //fade 6
        FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(1), mattimagic);
        fadeTransition6.setFromValue(0.0);
        fadeTransition6.setToValue(1.0);

        //seq transisition
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition1,
                fadeTransition2, fadeTransition3, fadeTransition4, fadeTransition5, fadeTransition6, new PauseTransition(Duration.millis(3000)));
        sequentialTransition.setCycleCount(Timeline.INDEFINITE);
        sequentialTransition.play();


    }

    public ProgressBar getLoadBar() {
        return loadBar;
    }
}


