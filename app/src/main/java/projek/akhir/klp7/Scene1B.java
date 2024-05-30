package projek.akhir.klp7;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import projek.controller.DataUserController;
import projek.model.DataUser;

public class Scene1B extends SceneUtil{
    private Stage stage;

    
    //constructor
    public Scene1B(Stage stage) {
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


        HBox header = createHBox(0, null, "header", logo,spacer1,EXSA);
        header.setPadding(new Insets(10));




        //body
        Label mainText1 = new Label("Discover The Beauty\nOf Indonesia");
        mainText1.setPadding(new Insets(50));
        mainText1.setId("mainText");
        Label mainText2 = new Label("SIGN UP .");
        mainText2.setId("loginFieldText");

        TextField usernameField = new TextField();
        usernameField.setId("userfield");
        usernameField.setPromptText("username");
        
        TextField emailField = new TextField();
        emailField.setId("userfield");
        emailField.setPromptText("Email");
        
        TextField passwordField = new TextField();
        passwordField.setId("userfield");
        passwordField.setPromptText("password");

        Button signupButton = new Button("Sign up");
        signupButton.setId("mainButton");
        Button returButton = new Button("Return");
        returButton.setId("mainButton");

        HBox buttonContainer = createHBox(10, Pos.CENTER, null, signupButton, returButton);

        VBox userField = createVBox(20, Pos.CENTER, null, usernameField,emailField,passwordField);

        HBox loginFieldText = new HBox(mainText2);
        loginFieldText.setPadding(new Insets(10));

        VBox loginField = createVBox(70, Pos.CENTER, "loginField", loginFieldText,userField,buttonContainer);
        loginField.setPadding(new Insets(20));

        HBox mainTextContainer = new HBox(mainText1);

        HBox mainContainer = createHBox(170, Pos.CENTER, "mainContainer", mainTextContainer,loginField);





        signupButton.setOnAction(V -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Sign Up Error");
                alert.setHeaderText(null);
                alert.setContentText("All fields must be filled out.");
                alert.showAndWait();
            } else {
                // Proceed with creating the user account
                DataUser userAccount = new DataUser(username, email, password);
                DataUserController.addUser(userAccount);
                Scene1A loginPage = new Scene1A(stage);
                loginPage.show();
            }
        });

        returButton.setOnAction(V -> {
            Scene1A loginPage = new Scene1A(stage);
            loginPage.show(); 
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
