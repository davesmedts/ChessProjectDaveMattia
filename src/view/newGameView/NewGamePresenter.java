package view.newGameView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Game;
import view.gameView.GamePresenter;
import view.gameView.GameView;
import view.homeView.HomePresenter;
import view.homeView.HomeView;

public class NewGamePresenter {

    private Game model;
    private NewGameView view;

    public NewGamePresenter(Game model,
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

        view.getStartSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String playerOne = view.getTekstPlayerOne().getText();
                String playerTwo = view.getTekstPlayerTwo().getText();
                model.newGame(playerOne, playerTwo);

                GameView gameView = new GameView(view.getColorOne(), view.getColorTwo());
                GamePresenter homePresenter = new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();

                gameView.setBlackPlayerName(model.getBlackPlayer().toString());
                gameView.setWhitePlayerName(model.getWhitePlayer().toString());

            }
        });


    }


    private void updateView() {
    }

}
