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
    private ToggleButton ThemeOne;
    private ToggleButton ThemeTwo;
    private ToggleButton ThemeThree;
    private Button applyColor;


    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();

    }


    private void initialiseNodes() {
//         this.colorOne= new TextField("GREEN");
//         this.colorTwo= new TextField("BLUE");
        ThemeOne = new ToggleButton("classic");
        ThemeTwo = new ToggleButton("funky");
        ThemeThree = new ToggleButton("stylish");
         applyColor = new Button ("apply");

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

//    public TextField getColorOne() {
//        return colorOne;
//    }
//
//    public TextField getColorTwo() {
//        return colorTwo;
//    }
}
