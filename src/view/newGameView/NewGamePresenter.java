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
                GameView gameView = new GameView(view.getColorOne(), view.getColorTwo());
                GamePresenter homePresenter = new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();

                String playerOne = view.getTekstPlayerWhite().getText();


                String playerTwo = view.getTekstPlayerBlack().getText();
               new Game(playerOne, playerTwo, true);


            }
        });


    }


    private void updateView() {
    }

}
