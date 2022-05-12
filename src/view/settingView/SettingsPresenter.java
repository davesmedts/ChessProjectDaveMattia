package view.settingView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import view.newGameView.NewGameView;


/**
 * @author Mattia Verreydt
 * @version 1.0 9-5-2022 14:51
 */
public class SettingsPresenter {

    private Game model;
    private SettingsView view;

    public SettingsPresenter(Game model,
                             SettingsView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {

        view.getThemeOne().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String colorOne = "#57271d";
                String colorTwo = "#ecddc8";

                NewGameView.colorOne = colorOne;
                NewGameView.colorTwo = colorTwo;

                int theme= 1;

                view.updateStyle(SettingsView.themeSetter=1);

            }
        });

        view.getThemeTwo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String colorOne = "PINK";
                String colorTwo = "YELLOW";

                NewGameView.colorOne = colorOne;
                NewGameView.colorTwo = colorTwo;

                view.updateStyle(SettingsView.themeSetter=2);
            }
        });

        view.getThemeThree().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String colorOne = "CORAL";
                String colorTwo = "TEAL";

                NewGameView.colorOne = colorOne;
                NewGameView.colorTwo = colorTwo;

                view.updateStyle(SettingsView.themeSetter=3);

            }
        });



    }


    private void updateView() {

    }

}
