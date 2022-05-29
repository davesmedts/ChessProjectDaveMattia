package view.newGameView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
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

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            public void handle(ActionEvent event) {
                HomeView homeView = new HomeView();
                HomePresenter homePresenter = new HomePresenter(model, homeView);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Home");

                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();

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
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Schaakspel");

                    view.getScene().setRoot(gameView);
                    gameView.getScene().getWindow().sizeToScene();

                    gameView.setBlackPlayerName(model.getBlackPlayer().toString());
                    gameView.setWhitePlayerName(model.getWhitePlayer().toString());
                }
            }
        });


        view.getGeschiedenis().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RankingView rankingView = new RankingView();
                RankingPresenter presenter = new RankingPresenter(model, rankingView);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Historiek");

                view.getScene().setRoot(rankingView);
                rankingView.getScene().getWindow().sizeToScene();

            }
        });


        view.getStartSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String playerOne = view.getTekstPlayerOne().getText();
                String playerTwo = view.getTekstPlayerTwo().getText();


                if (!playerOne.isEmpty() && !playerTwo.isEmpty()) {

                    model.newGame(playerOne, playerTwo);
                    GameView gameView = new GameView(view.getColorOne(), view.getColorTwo());
                    GamePresenter homePresenter = new GamePresenter(model, gameView);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setTitle("Schaakspel");

                    view.getScene().setRoot(gameView);
                    gameView.getScene().getWindow().sizeToScene();

                    gameView.setBlackPlayerName(model.getBlackPlayer().toString());
                    gameView.setWhitePlayerName(model.getWhitePlayer().toString());


                }

                if (playerOne.isEmpty() && !playerTwo.isEmpty()) {
                    view.getTekstPlayerOne().setStyle("-fx-text-box-border: red;");
                    view.getTekstPlayerTwo().setStyle("-fx-text-box-border: black;");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Naam speler 1");
                    alert.setContentText("Vul aub een naam in voor speler 1");
                    alert.showAndWait();

                }

                if (playerTwo.isEmpty() && !playerOne.isEmpty()) {
                    view.getTekstPlayerTwo().setStyle("-fx-text-box-border: red;");
                    view.getTekstPlayerOne().setStyle("-fx-text-box-border: black;");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Naam speler 2");
                    alert.setContentText("Vul aub een naam in voor speler 2");
                    alert.showAndWait();
                }

                if (playerTwo.isEmpty() && playerOne.isEmpty()) {
                    view.getTekstPlayerTwo().setStyle("-fx-text-box-border: red;");
                    view.getTekstPlayerOne().setStyle("-fx-text-box-border: red;");

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Naam spelers");
                    alert.setContentText("Vul aub een naam in voor beide spelers");
                    alert.showAndWait();


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
                helpStage.showAndWait();
            }
        });

        view.getSettingsIcon().setOnMouseClicked(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent event) {
                        SettingsView settingsView = new SettingsView();
                        SettingsPresenter settingsPresenter = new SettingsPresenter(model, settingsView);
                        Stage settingPresenter = new Stage();
                        settingPresenter.setTitle("Settings");
                        settingPresenter.initOwner(view.getScene().getWindow());
                        settingPresenter.initModality(Modality.APPLICATION_MODAL);
                        settingPresenter.setScene(new Scene(settingsView));
                        settingPresenter.showAndWait();
                    }

                });

        view.getInfoIcon().setOnMouseClicked(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent event) {
                        SplashScreenView splashScreenView = new SplashScreenView();
                        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(model, splashScreenView);

                        Stage settingPresenter = new Stage();
                        settingPresenter.setTitle("Info");
                        settingPresenter.initOwner(view.getScene().getWindow());
                        settingPresenter.initModality(Modality.APPLICATION_MODAL);
                        settingPresenter.setScene(new Scene(splashScreenView, 800, 400));
                        settingPresenter.showAndWait();


                    }

                });


    }


    private void updateView() {
    }


}
