package view.rankingView;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Game;
import model.HistoryRecord;
import view.homeView.HomePresenter;
import view.homeView.HomeView;

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
        view.getHomeBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeView homeView = new HomeView();
                HomePresenter homePresenter = new HomePresenter(model, homeView);
                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().sizeToScene();
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
