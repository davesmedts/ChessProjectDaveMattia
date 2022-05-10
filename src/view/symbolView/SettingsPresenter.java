package view.symbolView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import view.gameView.ChessBoardView;
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

        view.getApplyColor().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

    }

    private void updateView() {
    }

}
