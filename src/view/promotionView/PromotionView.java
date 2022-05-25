package view.promotionView;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PromotionView extends VBox {

    private Label titel;
    private HBox buttonContainer;

//    private Button queenBtn;
//    private Button bishopBtn;
//    private Button knightBtn;
//    private Button rookBtn;

    private ImageView queenImg;
    private ImageView bishopImg;
    private ImageView knightImg;
    private ImageView rookImg;

    public PromotionView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes(){
        this.titel = new Label("Kies het stuk waarnaar je wil promoveren");
        titel.setId("titel");

        this.queenImg = new ImageView("Queenwhite.png");
        this.bishopImg = new ImageView("Bishopwhite.png");
        this.rookImg = new ImageView("Rookwhite.png");
        this.knightImg = new ImageView("Knightwhite.png");

        this.buttonContainer = new HBox();

        this.setId("PromotionView");
    }

    private void layoutNodes(){
        buttonContainer.getChildren().addAll(queenImg, bishopImg, rookImg, knightImg);
        this.getChildren().addAll(titel, buttonContainer);
        buttonContainer.setSpacing(40);
        buttonContainer.setAlignment(Pos.CENTER);
    }

    public ImageView getQueenImg() {
        return queenImg;
    }

    public ImageView getBishopImg() {
        return bishopImg;
    }

    public ImageView getKnightImg() {
        return knightImg;
    }

    public ImageView getRookImg() {
        return rookImg;
    }
}
