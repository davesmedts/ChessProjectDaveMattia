package view.splashScreenView;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import model.Game;
import view.startView.StartView;

public class SplashScreenPresenter {

    private Game model;
    private SplashScreenView splashScreenView;
    private StartView startview;
    private Timeline stopwatchTimeline;

    public SplashScreenPresenter(Game model,
                                 SplashScreenView view) {
        this.model = model;
        this.splashScreenView = view;
        this.addEventHandlers();
        this.updateView();
    }

    public SplashScreenPresenter(Game model,
                                 StartView view) {
        this.model = model;
        this.startview = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {


    }

    private void updateView() {
    }

//    private void setupTimeline() {
//        stopwatchTimeline = new Timeline(new KeyFrame(
//                Duration.millis(this.model.getTickDurationMillis()),
//                new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        model.tick();
//                        updateView();
//                    }
//                }));
//        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);


}
