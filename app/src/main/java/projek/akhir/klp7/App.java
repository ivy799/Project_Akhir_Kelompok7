package projek.akhir.klp7;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("EXA");
        stage.setResizable(false);
        LoginScene homeScene = new LoginScene(stage);
        homeScene.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
