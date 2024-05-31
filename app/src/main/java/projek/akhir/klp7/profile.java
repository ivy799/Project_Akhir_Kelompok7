package projek.akhir.klp7;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projek.controller.DataUserController;
import projek.model.DataUser;

public class profile extends SceneUtil{
    private Stage stage;
    private DataUser user;


    public profile(Stage stage, DataUser user) {
        this.stage = stage;
        this.user = user;
    }


    public void show(){

        //header
        Button backButton = new Button("BACK");
        backButton.setId("backButton");

        HBox buttonContainer = createHBox(0, Pos.CENTER_RIGHT, null, backButton);



        //profile section
        Label username = new Label(DataUserController.getUserDetails(user.getUsername()).getUsername());
        username.setId("profileText");
        Label email = new Label(DataUserController.getUserDetails(user.getUsername()).getEmail());
        email.setId("profileText");
        Label password = new Label(DataUserController.getUserDetails(user.getUsername()).getPassword());
        password.setId("profileText");
        
        Button editProfile = new Button("EDIT PROFILE");
        editProfile.setId("editButton");

        Image profilImage = new Image("/image/LayoutImage/profile0.png");
        ImageView profileImageContainer = new ImageView(profilImage);

        VBox profileField = createVBox(10, Pos.CENTER, "profileField", username,email,password);
        VBox container1 = createVBox(40, Pos.CENTER, "container1", profileImageContainer,profileField,editProfile);


        //edit profile section
        Image editProfilImage = new Image("/image/LayoutImage/profile0.png");
        ImageView editProfileImageContainer = new ImageView(editProfilImage);


        TextField editUsername = new TextField();
        editUsername.setId("profileText");
        TextField editEmail = new TextField();
        editEmail.setId("profileText");

        Button updateButton = new Button("UPDATE");
        updateButton.setId("editButton");
        updateButton.setPadding(new Insets(40,0,0,0));

        VBox textFieldContainer = createVBox(10, Pos.CENTER, "textFieldContainer", editUsername,editEmail);
        VBox container2 = createVBox(10, Pos.CENTER, "container2", editProfileImageContainer);

        VBox container3 = createVBox(10, Pos.CENTER, "container3", textFieldContainer,updateButton);

        HBox container4 = createHBox(40, Pos.CENTER, "container4", container2,container3);
        container4.setOpacity(0);


        HBox mainContainer = new HBox(150);
        mainContainer.getChildren().addAll(container1,container4);
        mainContainer.setAlignment(Pos.CENTER);





        //button event listener
        editProfile.setOnAction(v ->{
            container4.setOpacity(1);
        });

        backButton.setOnAction(v ->{
            Scene2 scene2 = new Scene2(stage, user);
            scene2.show();
        });

        updateButton.setOnAction(v ->{
            
        });



        BorderPane root = new BorderPane();
        root.setId("body");
        root.setCenter(mainContainer);
        root.setTop(buttonContainer);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/profile.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
