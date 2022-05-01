package view.gameView;

import model.Model;

public class GamePresenter {

    private Model model;
    private GameView view;

    public GamePresenter(Model model,
                         GameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
    }

    private void updateView() {
    }

}
