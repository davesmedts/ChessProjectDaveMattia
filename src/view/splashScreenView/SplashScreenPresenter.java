package view.splashScreenView;


import model.Game;

public class SplashScreenPresenter {

    private Game model;
    private SplashScreenView view;

    public SplashScreenPresenter(Game model,
                                 SplashScreenView view) {
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
