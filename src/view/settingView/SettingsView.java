package view.settingView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 * @author Mattia Verreydt
 * @version 1.0 9-5-2022 14:50
 */
public class SettingsView extends GridPane {

    private ToggleButton themeOne;
    private ToggleButton themeTwo;
    private ToggleButton themeThree;
    static int themeSetter = 1; //moet dit public blijven staan?
    private HBox buttonContainer;
    private HBox kleurContainer;
    private Label settingTitle;

    private Label kleurClassic;
    private Label kleurFunky;
    private Label kleurStylish;

    private Label uitleg;
    private HBox uitlegContainer;

    private int widthGrid;


    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();

    }


    private void initialiseNodes() {
        this.setId("HomeView");
        themeOne = new ToggleButton("bruin-wit");
        themeTwo = new ToggleButton("blauw");
        themeThree = new ToggleButton("groen");
        this.buttonContainer = new HBox(35);
        this.settingTitle = new Label("Settings");


        this.kleurContainer = new HBox(15);
        this.kleurClassic = new Label("Bruin - Wit");
        this.kleurFunky = new Label("Geel - Roos");
        this.kleurStylish = new Label("Blauw");

        this.uitleg = new Label("Kies de kleuren van je bord");
        this.uitlegContainer = new HBox();


        updateStyle(themeSetter);


    }

    public void updateStyle(int themeSetter) {
        if (themeSetter == 1) {
            themeOne.setStyle("-fx-background-color: GREEN");
            themeTwo.setStyle("-fx-background-color: RED");
            themeThree.setStyle("-fx-background-color: RED");
        }

        if (themeSetter == 2) {
            themeOne.setStyle("-fx-background-color: RED");
            themeTwo.setStyle("-fx-background-color: GREEN");
            themeThree.setStyle("-fx-background-color: RED");
        }

        if (themeSetter == 3) {
            themeOne.setStyle("-fx-background-color: RED");
            themeTwo.setStyle("-fx-background-color: RED");
            themeThree.setStyle("-fx-background-color: GREEN");
        }

    }


    private void layoutNodes() {
        buttonContainer.getChildren().addAll(themeOne, themeTwo, themeThree);
        uitlegContainer.getChildren().addAll(uitleg);

        uitleg.setFont(Font.font(17));
        uitleg.setStyle("-fx-text-fill: #E7DFBC;");

        this.add(settingTitle, 0, 0);
        this.add(uitleg, 0, 1);
        this.add(buttonContainer, 0, 2);


        RowConstraints rowConstraint1 = new RowConstraints();
        rowConstraint1.setMinHeight(15);
        RowConstraints rowConstraint2 = new RowConstraints();
        rowConstraint2.setMinHeight(8);

        ColumnConstraints columnConstraint1 = new ColumnConstraints();
        columnConstraint1.setMinWidth(10);

        this.getColumnConstraints().addAll(columnConstraint1);
        this.getRowConstraints().addAll(rowConstraint1, rowConstraint2);



        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: BLACK;");

        settingTitle.setStyle(" -fx-font-weight: bold;" + "-fx-text-fill: WHITE");
        settingTitle.setFont(Font.font(20));

    }

    public ToggleButton getThemeOne() {
        return themeOne;
    }

    public ToggleButton getThemeTwo() {
        return themeTwo;
    }

    public ToggleButton getThemeThree() {
        return themeThree;
    }
}
