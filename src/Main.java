import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Ranking;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;
import view.settingView.SettingsPresenter;
import view.settingView.SettingsView;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
//        Game model = new Game(new Player("Deef"), new Player("Matti magic"), true);
//
//        SplashScreenView view = new SplashScreenView();
//        SplashScreenPresenter presenter = new SplashScreenPresenter(model, view);
//        Scene scene = new Scene(view);
//        scene.getStylesheets().add("/stylesheets/generalStyling.css");
//
//
//        primaryStage.setScene(scene);
////        presenter.addWindowEventHandlers();
//        primaryStage.show();
//    }


        Game model = new Game();

        HomeView view = new HomeView();
        HomePresenter presenter = new HomePresenter(model, view);
        Scene scene = new Scene(view, 1100, 700);
        scene.getStylesheets().add("/stylesheets/generalStyling.css");

        primaryStage.setScene(scene);
//        presenter.addWindowEventHandlers();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
