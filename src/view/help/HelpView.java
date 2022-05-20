package view.help;

import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dave Smedts
 * @version 1.0 10/05/2022 20:15
 */
public class HelpView extends BorderPane {
    ScrollBar scrollBar;
    private TextArea rules;

    public ScrollBar getScrollBar() {
        return scrollBar;
    }

    public HelpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.rules = new TextArea(readRulesFile());
        rules.setId("rules");
        rules.setPrefWidth(Double.MAX_VALUE);
        rules.setPrefHeight(Double.MAX_VALUE);
        rules.setWrapText(true);
        rules.setFont(Font.font("Arial",12));
        rules.setEditable(false);
    }


    private void layoutNodes() {
        this.setCenter(rules);
    }


    public String readRulesFile() {
        String rules = null;
        Path rulesTxt = Paths.get("resources/rules.txt");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rulesTxt.toFile()));) {
            String regel = reader.readLine();
            while (regel != null) {
                builder.append(regel);
                builder.append("\n");
                regel = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        rules = builder.toString();
        System.out.println(rules);
        return rules;
    }


}
