package view.symbolView;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.WindowEvent;

/**
 * @author Mattia Verreydt
 * @version 1.0 9-5-2022 14:50
 */
public class SettingsView extends GridPane {

    private static ToggleButton themeOne;
    private static ToggleButton themeTwo;
    private static ToggleButton themeThree;
    private HBox buttonContainer;
    private Label settingTitle;


    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();

    }


    private void initialiseNodes() {
        this.setId("HomeView");
        themeOne = new ToggleButton("classic");
        themeTwo = new ToggleButton("funky");
        themeThree = new ToggleButton("stylish");
        this.buttonContainer = new HBox(15);
        this.settingTitle = new Label("Settings");


        themeOne.setStyle("-fx-background-color: GREEN");
        themeTwo.setStyle("-fx-background-color: RED");
        themeThree.setStyle("-fx-background-color: RED");


    }


    private void layoutNodes() {
        buttonContainer.getChildren().addAll(themeOne, themeTwo, themeThree);

this.add(settingTitle,0,0);
        this.add(buttonContainer, 1, 1);

        ColumnConstraints colConstraints = new ColumnConstraints();
        colConstraints.setPercentWidth(33);

        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: BLACK;");

        settingTitle.setStyle(" -fx-font-weight: bold;" +"-fx-text-fill: WHITE");

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

    public void setThemeOne(ToggleButton themeOne) {
        this.themeOne = themeOne;
    }

    public void setThemeTwo(ToggleButton themeTwo) {
        this.themeTwo = themeTwo;
    }

    public void setThemeThree(ToggleButton themeThree) {
        this.themeThree = themeThree;
    }

}
