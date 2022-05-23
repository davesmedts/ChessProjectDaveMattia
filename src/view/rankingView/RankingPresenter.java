package view.rankingView;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Game;
import model.HistoryRecord;
import view.gameView.GamePresenter;
import view.gameView.GameView;
import view.help.HelpPresenter;
import view.help.HelpView;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;
import view.settingView.SettingsPresenter;
import view.settingView.SettingsView;
import view.splashScreenView.SplashScreenPresenter;
import view.splashScreenView.SplashScreenView;

import java.io.File;

public class RankingPresenter {

    private Game model;
    private RankingView view;

    public RankingPresenter(Game model,
                            RankingView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
        // Terug naar HomeScherm
        view.getHome().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeView homeView = new HomeView();
                HomePresenter homePresenter = new HomePresenter(model, homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
            }
        });

        view.getNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NewGameView newGameView = new NewGameView();
                NewGamePresenter gamePresenter = new NewGamePresenter(model, newGameView);
                view.getScene().setRoot(newGameView);
                newGameView.getScene().getWindow().sizeToScene();

            }
        });

        view.getHervatSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File("resources/savedGames"));
                fileChooser.setTitle("Load Data File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Textfiles", "*.txt"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                File selectedFile = fileChooser.showOpenDialog(
                        view.getScene().getWindow());
                if ((selectedFile != null)) {
                    System.out.println(selectedFile.getName());
                    String nameWithoutExtension = selectedFile.getName().split("\\.")[0];
                    model.loadGame(nameWithoutExtension);

                    GameView gameView = new GameView(view.getColorOne(), view.getColorTwo());
                    GamePresenter gamePresenter = new GamePresenter(model, gameView);
                    view.getScene().setRoot(gameView);
                    gameView.getScene().getWindow().sizeToScene();

                    gameView.setBlackPlayerName(model.getBlackPlayer().toString());
                    gameView.setWhitePlayerName(model.getWhitePlayer().toString());
                }
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
                settingPresenter.setScene(new Scene(settingsView, 800, 500));
//                settingPresenter.setX(view.getScene().getWindow().getX() + 100);
//                settingPresenter.setY(view.getScene().getWindow().getY() + 100);
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
//                settingPresenter.setX(view.getScene().getWindow().getX() + 100);
//                settingPresenter.setY(view.getScene().getWindow().getY() + 100);
                settingPresenter.showAndWait();
            }
        });


    }

    private void updateView() {
        view.getDatumCol().setCellValueFactory(
                new PropertyValueFactory<>("date")
        );
        view.getSpelerWitCol().setCellValueFactory(
                new PropertyValueFactory<>("whitePlayer")
        );
        view.getSpelerZwartCol().setCellValueFactory(
                new PropertyValueFactory<>("blackPlayer")
        );
        view.getWinnaarCol().setCellValueFactory(
                new PropertyValueFactory<>("winner")
        );

        ObservableList<HistoryRecord> historyRecords = FXCollections.observableList(model.getHistory().readHistoryRecords());
        view.getTable().setItems(historyRecords);
    }

}
