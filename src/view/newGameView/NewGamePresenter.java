package view.newGameView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Game;
import view.gameView.GamePresenter;
import view.gameView.GameView;
import view.help.HelpPresenter;
import view.help.HelpView;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;
import view.settingView.SettingsPresenter;
import view.settingView.SettingsView;
import view.splashScreenView.SplashScreenPresenter;
import view.splashScreenView.SplashScreenView;

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

        view.getHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeView homeView = new HomeView();
                HomePresenter homePresenter = new HomePresenter(model, homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();

            }
        });


        view.getGeschiedenis().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RankingView rankingView = new RankingView();
                RankingPresenter presenter = new RankingPresenter(model, rankingView);
                view.getScene().setRoot(rankingView);
                rankingView.getScene().getWindow().sizeToScene();

            }
        });

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


        view.getHelpIcon().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HelpView helpView = new HelpView();
                HelpPresenter helpPresenter = new HelpPresenter(helpView);
                Stage helpStage = new Stage();
                helpStage.setTitle("Hoe speel je schaak?");
                helpStage.initOwner(view.getScene().getWindow());
                helpStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(helpView);
//                scene.getStylesheets().add("stylesheets/style.css");
                helpStage.setScene(scene);
                helpStage.setX(view.getScene().getWindow().getX());
                helpStage.setY(view.getScene().getWindow().getY() + 100);
                helpStage.showAndWait();
            }
        });

        view.getSettingsIcon().setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SettingsView settingsView = new SettingsView();
                SettingsPresenter settingsPresenter = new SettingsPresenter(model, settingsView);
                Stage settingPresenter = new Stage();
                settingPresenter.initOwner(view.getScene().getWindow());
                settingPresenter.initModality(Modality.APPLICATION_MODAL);
                settingPresenter.setScene(new Scene(settingsView));
                settingPresenter.setX(view.getScene().getWindow().getX() + 100);
                settingPresenter.setY(view.getScene().getWindow().getY() + 100);
                settingPresenter.showAndWait();

            }

        });

        view.getInfoIcon().setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SplashScreenView splashScreenView = new SplashScreenView();
                SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(model, splashScreenView);
                Stage settingPresenter = new Stage();
                settingPresenter.initOwner(view.getScene().getWindow());
                settingPresenter.initModality(Modality.APPLICATION_MODAL);
                settingPresenter.setScene(new Scene(splashScreenView));
                settingPresenter.setX(view.getScene().getWindow().getX() + 100);
                settingPresenter.setY(view.getScene().getWindow().getY() + 100);
                settingPresenter.showAndWait();
            }
        });


    }


    private void updateView() {
    }

}
