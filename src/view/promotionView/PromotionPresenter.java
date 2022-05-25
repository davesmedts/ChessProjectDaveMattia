package view.promotionView;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import model.Square;
import model.chessPieces.Pawn;

public class PromotionPresenter {
    private Game model;
    private PromotionView view;
    Pawn pawn;

    public PromotionPresenter(Game model, PromotionView view){
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers(){
        view.getBishopImg().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pawn.promotePiece("B");
                Stage stage = (Stage) view.getScene().getWindow();
                stage.close();
            }
        });
        view.getQueenImg().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pawn.promotePiece("Q");
                Stage stage = (Stage) view.getScene().getWindow();
                stage.close();

            }
        });
        view.getKnightImg().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pawn.promotePiece("K");
                Stage stage = (Stage) view.getScene().getWindow();
                stage.close();

            }
        });
        view.getRookImg().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pawn.promotePiece("R");
                Stage stage = (Stage) view.getScene().getWindow();
                stage.close();

            }
        });
    }

    private void updateView(){

    }

    public void addWindowEventHandlers(){

    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
}
