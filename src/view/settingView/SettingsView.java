package view.settingView;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

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

        this.add(settingTitle, 0, 0);
        this.add(buttonContainer, 1, 1);

        ColumnConstraints colConstraints = new ColumnConstraints();
        colConstraints.setPercentWidth(33);

        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: BLACK;");

        settingTitle.setStyle(" -fx-font-weight: bold;" + "-fx-text-fill: WHITE");

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
