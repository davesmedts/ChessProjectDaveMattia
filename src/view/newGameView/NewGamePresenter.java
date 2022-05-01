package view.newGameView;

import model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.homeView.HomePresenter;
import view.homeView.HomeView;

public class NewGamePresenter {

    private Model model;
    private NewGameView view;

    public NewGamePresenter(Model model,
                            NewGameView view) {
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
