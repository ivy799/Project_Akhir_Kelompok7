package projek.akhir.klp7;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        //main-stage-1
        stage.setTitle("EXA");
        stage.setResizable(false);
        Scene2 homeScene = new Scene2(stage);
        homeScene.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
