package view.splashScreenView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;

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
