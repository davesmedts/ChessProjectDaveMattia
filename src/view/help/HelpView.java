package view.help;

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
public class HelpView extends VBox {
    private Text rules;

    public HelpView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.rules = new Text();
        rules.setText(readRulesFile());
        rules.setFont(new Font(15));
        rules.setWrappingWidth(700);
        rules.setTextAlignment(TextAlignment.JUSTIFY);
    }


    private void layoutNodes() {
        this.getChildren().add(rules);
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
