package view.symbolView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import model.Game;
import view.gameView.ChessBoardView;
import view.gameView.GamePresenter;
import view.gameView.GameView;
import view.newGameView.NewGamePresenter;
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

            }
        });

        view.getThemeTwo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String colorOne = "PINK";
                String colorTwo = "YELLOW";

                NewGameView.colorOne = colorOne;
                NewGameView.colorTwo = colorTwo;

            }
        });

        view.getThemeThree().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String colorOne = "CORAL";
                String colorTwo = "TEAL";

                NewGameView.colorOne = colorOne;
                NewGameView.colorTwo = colorTwo;

            }
        });

    }

    private void updateView() {
    }

}
