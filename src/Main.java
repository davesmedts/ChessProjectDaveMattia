import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Ranking;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.rankingView.RankingPresenter;
import view.rankingView.RankingView;


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

        RankingView view = new RankingView();
        RankingPresenter presenter = new RankingPresenter(model, view);
        Scene scene = new Scene(view);
        scene.getStylesheets().add("/stylesheets/generalStyling.css");

        primaryStage.setScene(scene);
//        presenter.addWindowEventHandlers();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
