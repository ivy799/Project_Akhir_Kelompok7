package projek.akhir.klp7;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // scene-1-root_1
        BorderPane root_1 = new BorderPane();
        
        // scene-1-root_1-HeaderText
        Label headerLabel = new Label("EXA");
        headerLabel.setId("headerLabel");
        
        // scene-1-root_1-header-logo
        Image image = new Image(getClass().getResourceAsStream("/image/logo_EXSA-removebg-preview 5.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80); 
        imageView.setFitHeight(30);
        imageView.setId("headerLogo");
        
        // scene-1-root_1-spacer
        Pane spacer = new Pane();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        
        
        // scene-1-root_1-leaf-1
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));
        header.setId("header");
        header.getChildren().addAll(headerLabel,spacer,imageView);




        // scene-1-root_1-mainText
        Label mainText = new Label("SELAMAT DATANG");
        mainText.setId("mainText");

        // scene-1-root_1-searchBar
        TextField searchBar = new TextField();
        searchBar.setPromptText("Cari kota/kabupaten");
        searchBar.setPrefWidth(200);

        //searchBar container
        HBox searchBarBox = new HBox(searchBar);
        searchBarBox.setAlignment(Pos.CENTER);
        
        // scene-1-root_1-leaf-2
        VBox main = new VBox();
        main.setPadding(new Insets(10));
        main.setId("main");
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(mainText,searchBarBox);
        main.setPrefWidth(300);
        main.setSpacing(20);

        
        

        // root_1 layout
        root_1.setTop(header);
        root_1.setLeft(main);

        // scene-1
        Scene scene = new Scene(root_1, 700, 500);
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
