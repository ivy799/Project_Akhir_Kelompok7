package projek.akhir.klp7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
// import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // scene-1-root-1
        BorderPane root = new BorderPane();
        
        // scene-1-root-1-HeaderText
        Label headerLabel = new Label("EXA");
        headerLabel.setId("headerLabel");
        
        // scene-1-root-1-header-logo
        Image image = new Image(getClass().getResourceAsStream("/image/logo_EXSA-removebg-preview 5.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80); 
        imageView.setFitHeight(30);
        imageView.setId("headerLogo");
        
        // scene-1-root-1-spacer
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        
        
        // scene-1-root-1-leaf-1
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));
        header.setId("header");
        header.getChildren().addAll(headerLabel,spacer,imageView);
        
        // root-1
        root.setTop(header);

        // scene-1
        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/styling/style.css").toExternalForm());
        
        //main-stage-1
        primaryStage.setTitle("EXA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
