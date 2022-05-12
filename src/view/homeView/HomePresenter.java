package view.homeView;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.loadGameView.LoadGamePresenter;
import view.loadGameView.LoadGameView;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;
import view.symbolView.SettingsPresenter;
import view.symbolView.SettingsView;


public class HomePresenter {

    private Game model;
    private HomeView view;

    public static String colorOne;
    public static String colorTwo;

    public HomePresenter(Game model,
                         HomeView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
//        this.addWindowEventHandlers();
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
                SettingsPresenter.colorOne = colorOne;
                SettingsPresenter.colorTwo = colorTwo;

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


    public void addWindowEventHandlers() {

            view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Wilt u het spel verlaten?");
                    alert.setContentText("Ben je zeker?");
                    alert.setTitle("Opgelet!");
                    alert.getButtonTypes().clear();
                    ButtonType neen = new ButtonType("Neen");
                    ButtonType ja = new ButtonType("Ja");
                    alert.getButtonTypes().addAll(neen, ja);
                    alert.showAndWait();
                    if (alert.getResult() == null || alert.getResult().equals(neen)) {
                        event.consume();
                    }
                }
            });
        }




    private void updateView() {
    }

}
