package projek.akhir.klp7;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene1 {
    private Stage stage;

    
    //constructor
    public Scene1(Stage stage) {
        this.stage = stage;
    }



    public void show(){
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");


        //header
        Image image = new Image(getClass().getResourceAsStream("/image/logo_EXSA-removebg-preview 5.png"));
        ImageView logo = new ImageView(image);
        logo.setFitWidth(80); 
        logo.setFitHeight(30);
        logo.setId("headerLogo");

        Label EXSA = new Label("EXSA");
        EXSA.setId("HeaderText");
        
        //spacer
        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);


        HBox header = new HBox();
        header.getChildren().addAll(logo,spacer1,EXSA);
        header.setPadding(new Insets(10));
        header.setId("header");



        //body
        Label mainText1 = new Label("Discover The Beauty\nOf Indonesia");
        mainText1.setPadding(new Insets(50));
        mainText1.setId("mainText");
        Label mainText2 = new Label("LOG IN .");
        mainText2.setId("loginFieldText");

        TextField usernameField = new TextField();
        usernameField.setId("userfield");
        usernameField.setPromptText("username");
        
        TextField passwordField = new TextField();
        passwordField.setId("userfield");
        passwordField.setPromptText("password");

        Button loginButton = new Button("Login");
        Button signupButton = new Button("Sign up");
        loginButton.setId("mainButton");
        signupButton.setId("mainButton");

        HBox buttonContainer = new HBox(10);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(loginButton,signupButton);

        VBox userField = new VBox(20);
        userField.setAlignment(Pos.CENTER);
        userField.getChildren().addAll(usernameField,passwordField);
        
        HBox loginFieldText = new HBox(mainText2);
        loginFieldText.setPadding(new Insets(10));

        VBox loginField = new VBox(90);
        loginField.setAlignment(Pos.CENTER);
        loginField.setPadding(new Insets(20));
        loginField.setId("loginField");
        loginField.getChildren().addAll(loginFieldText,userField,buttonContainer);


        HBox mainTextContainer = new HBox(mainText1);

        HBox mainContainer = new HBox(170);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setId("mainContainer");
        mainContainer.getChildren().addAll(mainTextContainer,loginField);



        //button action listener
        loginButton.setOnAction(V -> {
            Scene4B scene3 = new Scene4B(stage);
            scene3.show(); 
        });

        signupButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });



        //scene layouting
        root_1.setTop(header);
        root_1.setCenter(mainContainer);

        
        
        

        // scene-1
        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
}
