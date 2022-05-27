import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Game;
import view.homeView.HomePresenter;
import view.homeView.HomeView;
import view.splashScreenView.SplashScreenPresenter;
import view.splashScreenView.SplashScreenView;
import view.startView.StartView;


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
        StartView view = new StartView();
        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(model, view);
        Scene scene = new Scene(view, 1100, 700);
        scene.getStylesheets().add("/stylesheets/generalStyling.css");

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(7800),
                ae -> openHome(model, scene)));
        timeline.play();

        primaryStage.setScene(scene);
//        homepresenter.addWindowEventHandlers();
        primaryStage.show();


//        HomeView homeview = new HomeView();
//        HomePresenter homepresenter = new HomePresenter(model, homeview);
//        Scene homescene = new Scene(homeview, 1100, 700);
//        homescene.getStylesheets().add("/stylesheets/generalStyling.css");

    }
    public void openHome(Game model, Scene scene) {
        //The task you want to do
//                System.out.println("Hello World");)
        HomeView homeView = new HomeView();
        HomePresenter homePresenter = new HomePresenter(model, homeView);
        scene.setRoot(homeView);
        homeView.getScene().getWindow().sizeToScene();
    }




    public static void main(String[] args) {
        Application.launch(args);

    }
}
