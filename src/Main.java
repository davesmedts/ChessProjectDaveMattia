import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.gameView.GamePresenter;
import view.gameView.GameView;
import view.loadGameView.LoadGamePresenter;
import view.loadGameView.LoadGameView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        GameView view = new GameView();
        GamePresenter presenter = new GamePresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
