package view.symbolView;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 * @author Mattia Verreydt
 * @version 1.0 9-5-2022 14:50
 */
public class SettingsView extends GridPane {

    TextField colorOne;
    TextField colorTwo;
    Button applyColor;


    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();

    }


    private void initialiseNodes() {
         colorOne= new TextField("GREY");
         colorTwo= new TextField("PINK");
         applyColor = new Button("apply");

    }


    private void layoutNodes() {
        this.add(colorOne, 1, 0, 2, 1);
        this.add(colorTwo, 1, 1, 2, 1);
        this.add(applyColor,1,2,2,1);

        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(30);

    }

    public Button getApplyColor() {
        return applyColor;
    }

    public TextField getColorOne() {
        return colorOne;
    }

    public TextField getColorTwo() {
        return colorTwo;
    }
}
