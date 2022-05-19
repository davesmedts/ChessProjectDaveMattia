package view.splashScreenView;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.util.Duration;
import startView.StartView;

import javax.swing.text.View;

/**
 * @author Mattia Verreydt
 * @version 1.0 19-5-2022 21:11
 */
public class LoadBarTransition extends Transition {

    private final StartView view;

    public LoadBarTransition(StartView view) {
        this.view = view;
        this.setCycleDuration(Duration.seconds(8));
        this.setCycleCount(Timeline.INDEFINITE);
        this.setInterpolator(Interpolator.LINEAR);
    }
    @Override
    protected void interpolate(double frac) {
        this.view.getLoadBar().setProgress(frac);
    }



}
