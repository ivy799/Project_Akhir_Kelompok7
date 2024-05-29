package projek.akhir.klp7;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class AbstractAnimation {

    protected FadeTransition createFadeTransition(Duration duration, double fromValue, double toValue, Node node) {
        FadeTransition fadeTransition = new FadeTransition(duration, node);
        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        return fadeTransition;
    }

    protected PathTransition createPathTransition(Duration duration, Path path, Node node) {
        PathTransition pathTransition = new PathTransition(duration, path, node);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);
        return pathTransition;
    }

    protected VBox createVBox(double spacing, Pos alignment, String id, Node... children) {
        VBox vbox = new VBox(spacing);
        vbox.setAlignment(alignment);
        vbox.setId(id);
        vbox.getChildren().addAll(children);
        return vbox;
    }
}
