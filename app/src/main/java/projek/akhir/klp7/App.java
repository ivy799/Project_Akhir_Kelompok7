package projek.akhir.klp7;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("EXA");
        stage.setResizable(false);
        Image iconApp = new Image(getClass().getResourceAsStream("/image/LayoutImage/logo3.png"));
        stage.getIcons().add(iconApp);
        LoginScene homeScene = new LoginScene(stage);
        homeScene.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
