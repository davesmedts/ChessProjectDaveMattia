package view.homeView;

import model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.loadGameView.LoadGamePresenter;
import view.loadGameView.LoadGameView;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;


public class HomePresenter {

    private Game model;
    private HomeView view;

    public HomePresenter(Game model,
                         HomeView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }


    private void addEventHandlers() {
        // blijven op dezelfde Stage, new Game starten
        view.getNewGameBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NewGameView newGameView = new NewGameView();
                NewGamePresenter newGamePresenter = new NewGamePresenter(model, newGameView);
                view.getScene().setRoot(newGameView);
                newGameView.getScene().getWindow().sizeToScene();
            }
        });

        // blijven op dezelfde Stage, rangschikking opvragen
        view.getRangschikkingBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RankingView RankingView = new RankingView();
                RankingPresenter loadGamePresenter = new RankingPresenter(model, RankingView);
                view.getScene().setRoot(RankingView);
                RankingView.getScene().getWindow().sizeToScene();
            }
        });

        // blijven op dezelfde Stage, spel hervatten
        view.getOpenenBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoadGameView RankingView = new LoadGameView();
                LoadGamePresenter LoadGamePresenter = new LoadGamePresenter(model, RankingView);
                view.getScene().setRoot(RankingView);
                RankingView.getScene().getWindow().sizeToScene();
            }
        });

    }

    private void updateView() {
    }

}
