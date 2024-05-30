package projek.akhir.klp7;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class SceneUtil {

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

    protected HBox createHBox(double spacing, Pos alignment, String id, Node... children) {
        HBox hBox = new HBox(spacing);
        hBox.setAlignment(alignment);
        hBox.setId(id);
        hBox.getChildren().addAll(children);
        return hBox;
    }

    public BorderPane createRecomendPane(String imageUrl, String text, EventHandler<MouseEvent> eventHandler) {
        String bgImageUrl = getClass().getResource(imageUrl).toExternalForm();
        Label label = new Label(text);
        label.setId("recomendtext");
        label.setOnMouseClicked(eventHandler);
        
        BorderPane recomendPane = new BorderPane();
        recomendPane.setPadding(new Insets(10));
        recomendPane.setId("recomend");
        recomendPane.setBottom(label);
        recomendPane.setStyle("-fx-background-image: url('" + bgImageUrl + "');");
        
        return recomendPane;
    }
}
