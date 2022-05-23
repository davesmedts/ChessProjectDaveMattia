package view.splashScreenView;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.Reflection;
import javafx.geometry.HPos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class SplashScreenView extends BorderPane {

    private HBox hbox;
    private Label version;
    private Text program;
    private Text created;
    private Text by;
    private Text dave;
    private Text and;
    private Text mattia;


    public SplashScreenView() {
        this.initialiseNodes();
        this.layoutNodes();
        animatie();
    }

    private void initialiseNodes() {



//       general nodes
        this.hbox = new HBox();
        this.program = new Text("program ");
        this.by = new Text("by ");
        this.created = new Text("created ");
        this.dave = new Text("Dave ");
        this.and = new Text("and ");
        this.mattia = new Text("Mattia");
        program.setFill(Color.WHITE);
        program.setFont(Font.font(null, FontWeight.BOLD, 20));
        by.setFill(Color.WHITE);
        by.setFont(Font.font(null, FontWeight.BOLD, 20));
        created.setFill(Color.WHITE);
        created.setFont(Font.font(null, FontWeight.BOLD, 20));
        dave.setFill(Color.WHITE);
        dave.setFont(Font.font(null, FontWeight.BOLD, 20));
        and.setFill(Color.WHITE);
        and.setFont(Font.font(null, FontWeight.BOLD, 20));
        mattia.setFill(Color.WHITE);
        mattia.setFont(Font.font(null, FontWeight.BOLD, 20));

        hbox.getChildren().addAll(program, created, by, dave, and, mattia);


        this.version = new Label("version 1");
        version.setStyle("-fx-text-fill: white");

        this.setBackground(new Background(
                new BackgroundImage(
                        new Image("splashscreenImage.jpg"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(
                                Side.LEFT, 0.0, true, Side.BOTTOM, 0.0, true),
                        new BackgroundSize(50, 50, true, true, false, true)
                )));


    }

    private void layoutNodes() {


//        general content

        this.setCenter(hbox);
        this.setBottom(version);


//        constraints & ID

//        ColumnConstraints colConstraint1 = new ColumnConstraints();
//        colConstraint1.setMinWidth(10);
//
//        ColumnConstraints colConstraint2 = new ColumnConstraints();
//        colConstraint2.setMinWidth(10);
//
//        ColumnConstraints colConstraint3 = new ColumnConstraints();
//        colConstraint3.setMinWidth(10);
//
//        RowConstraints rowConstraints1 = new RowConstraints();
//        rowConstraints1.setMinHeight(10);
//        RowConstraints rowConstraints2 = new RowConstraints();
//        rowConstraints2.setMinHeight(10);
//        RowConstraints rowConstraints3 = new RowConstraints();
//        rowConstraints3.setMinHeight(10);
//
//        this.getColumnConstraints().addAll(colConstraint1, colConstraint2, colConstraint3);
//        this.getRowConstraints().addAll(rowConstraints1, rowConstraints2, rowConstraints3);


//
//        this.setConstraints(version, 2, 2, 3, 1,
//                HPos.LEFT, VPos.BOTTOM,
//                Priority.ALWAYS, Priority.ALWAYS);


        hbox.setAlignment(Pos.CENTER);


    }


    public void animatie() {
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
        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(1), dave);
        fadeTransition4.setFromValue(0.0);
        fadeTransition4.setToValue(1.0);


        //fade 5
        FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(1), and);
        fadeTransition5.setFromValue(0.0);
        fadeTransition5.setToValue(1.0);


        //fade 6
        FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(1), mattia);
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

}
