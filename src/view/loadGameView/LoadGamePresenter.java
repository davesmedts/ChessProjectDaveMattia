package view.loadGameView;

import model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.homeView.HomePresenter;
import view.homeView.HomeView;

public class LoadGamePresenter {

    private Game model;
    private LoadGameView view;

    public LoadGamePresenter(Game model,
                             LoadGameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {

        // Terug naar HomeScherm
        view.getHomeBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeView homeView = new HomeView();
                HomePresenter homePresenter = new HomePresenter(model, homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
            }
        });
    }

    private void updateView() {
    }

}
