package view.help;

import model.Game;

public class HelpPresenter {
    private Game model;
    private HelpView view;

    public HelpPresenter(HelpView view) {
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
