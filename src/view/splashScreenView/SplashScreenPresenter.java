package view.splashScreenView;


import model.Game;
import view.startView.StartView;

public class SplashScreenPresenter {

    private Game model;
    private SplashScreenView splashScreenView;
    private StartView startview;

    public SplashScreenPresenter(Game model,
                                 SplashScreenView view) {
        this.model = model;
        this.splashScreenView = view;
        this.addEventHandlers();
        this.updateView();
    }

    public SplashScreenPresenter(Game model,
                                 StartView view) {
        this.model = model;
        this.startview = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {


    }

    private void updateView() {
    }


}
