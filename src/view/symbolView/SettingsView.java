package view.symbolView;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 * @author Mattia Verreydt
 * @version 1.0 9-5-2022 14:50
 */
public class SettingsView extends GridPane {

//    TextField colorOne;
//    TextField colorTwo;
    private static ToggleButton ThemeOne;
    private static ToggleButton ThemeTwo;
    private static ToggleButton ThemeThree;
    private Button applyColor;


    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();

    }


    private void initialiseNodes() {
        this.setId("HomeView");
        ThemeOne = new ToggleButton("classic");
        ThemeTwo = new ToggleButton("funky");
        ThemeThree = new ToggleButton("stylish");




       ThemeOne.setStyle("-fx-background-color: GREEN");
       ThemeTwo.setStyle("-fx-background-color: RED");
       ThemeThree.setStyle("-fx-background-color: RED");

    }


    private void layoutNodes() {
//        this.add(colorOne, 1, 0, 2, 1);
//        this.add(colorTwo, 1, 1, 2, 1);
        this.add(ThemeOne,1,1);
        this.add(ThemeTwo,2,2);
        this.add(ThemeThree,3,3);
//        this.add(applyColor,4,4);

        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(20);

    }

//    public Button getApplyColor() {
//        return applyColor;
//    }

    public ToggleButton getThemeOne() {
        return ThemeOne;
    }

    public ToggleButton getThemeTwo() {
        return ThemeTwo;
    }

    public ToggleButton getThemeThree() {
        return ThemeThree;
    }

    public void setThemeOne(ToggleButton themeOne) {
        ThemeOne = themeOne;
    }

    public void setThemeTwo(ToggleButton themeTwo) {
        ThemeTwo = themeTwo;
    }

    public void setThemeThree(ToggleButton themeThree) {
        ThemeThree = themeThree;
    }

    //    public TextField getColorOne() {
//        return colorOne;
//    }
//
//    public TextField getColorTwo() {
//        return colorTwo;
//    }
}
