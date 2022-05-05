import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import view.newGameView.NewGamePresenter;
import view.newGameView.NewGameView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Game model = new Game(new Player("Deef"), new Player("Matti magic"));
        NewGameView view = new NewGameView();
        NewGamePresenter presenter = new NewGamePresenter(model, view);
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
