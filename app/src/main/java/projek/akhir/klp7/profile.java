package projek.akhir.klp7;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

public class profile extends SceneUtil implements Show{
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
        backButton.setPadding(new Insets(10));

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

        Image profilImage = new Image("/image/LayoutImage/icon1.png");
        ImageView profileImageContainer = new ImageView(profilImage);

        ImageView logoutButton = new ImageView(new Image("/image/LayoutImage/logoutImg.png"));
        logoutButton.setId("logoutImg");
        HBox logoutBox = createHBox(0, Pos.CENTER_LEFT, null, logoutButton);
        logoutBox.setPadding(new Insets(10));

        VBox profileField = createVBox(10, Pos.CENTER, "profileField", username,email,password);
        VBox container1 = createVBox(20, Pos.CENTER, "container1", profileImageContainer,profileField,editProfile,logoutBox);


        //edit profile section
        Image editProfilImage = new Image("/image/LayoutImage/icon2.png");
        ImageView editProfileImageContainer = new ImageView(editProfilImage);

        Label editText = new Label("Masukkan profil baru anda !");
        editText.setId("editText");

        TextField editUsername = new TextField();
        editUsername.setId("profileText");
        editUsername.setPromptText("Enter new username");

        TextField editEmail = new TextField();
        editEmail.setId("profileText");
        editEmail.setPromptText("Enter new email adress");

        TextField editPassword = new TextField();
        editPassword.setId("profileText");
        editPassword.setPromptText("Enter new password");

        Button updateButton = new Button("UPDATE");
        updateButton.setId("editButton");
        updateButton.setPadding(new Insets(5));

        VBox textFieldContainer = createVBox(10, Pos.CENTER, "textFieldContainer", editUsername,editEmail,editPassword);
        VBox container2 = createVBox(10, Pos.CENTER, "container2", editProfileImageContainer);

        VBox container3 = createVBox(20, Pos.CENTER, "container3", editText, textFieldContainer,updateButton);

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
            String newUsername = editUsername.getText();
            String newEmail = editEmail.getText();
            String newPassword = editPassword.getText();

            boolean updateStatus = DataUserController.updateUserDetails(username.getText(), newUsername, newEmail, newPassword);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (updateStatus) {
                user.setUsername(newUsername);
                user.setEmail(newEmail);
                user.setPassword(newPassword); // Assuming you have a setPassword method

                alert.setTitle("Update Successful");
                alert.setHeaderText(null);
                alert.setContentText("User details updated successfully!");
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Update Failed");
                alert.setHeaderText(null);
                alert.setContentText("Failed to update user details. Please try again.");
            }
        });


        logoutButton.setOnMouseClicked(v ->{
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
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
