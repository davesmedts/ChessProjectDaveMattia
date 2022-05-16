import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.gameView.GamePresenter;
import view.gameView.GameView;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.splashScreenView.SplashScreenPresenter;
import view.splashScreenView.SplashScreenView;

import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Game model = new Game(new Player("Deef"), new Player("Matti magic"), true);

        HomeView view = new HomeView();
        HomePresenter presenter = new HomePresenter(model, view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/stylesheets/generalStyling.css");

        primaryStage.setScene(scene);
        presenter.addWindowEventHandlers();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
