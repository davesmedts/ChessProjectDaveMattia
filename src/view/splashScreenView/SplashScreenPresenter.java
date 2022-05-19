package view.splashScreenView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import startView.StartView;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;

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
