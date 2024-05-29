package projek.akhir.klp7;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import projek.controller.DataUserController;
import projek.model.DataUser;

public class LoginScene {
    private Stage stage;

    public LoginScene(Stage stage) {
        this.stage = stage;
    }

    private VBox createVBox(double spacing, Pos alignment, String id, Node... children) {
        VBox vbox = new VBox(spacing);
        vbox.setAlignment(alignment);
        vbox.setId(id);
        vbox.getChildren().addAll(children);
        return vbox;
    }

    private FadeTransition createFadeTransition(Duration duration, double fromValue, double toValue, Node node) {
        FadeTransition fadeTransition = new FadeTransition(duration, node);
        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        return fadeTransition;
    }

    private PathTransition createPathTransition(Duration duration, Path path, Node node) {
        PathTransition pathTransition = new PathTransition(duration, path, node);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);
        return pathTransition;
    }

    public void show() {
        Image lineImage = new Image("/image/line2.png");
        ImageView line11 = new ImageView(lineImage);
        ImageView line22 = new ImageView(lineImage);

        Label mainText1 = new Label("DISCOVER THE BEAUTY OF INDONESIA");
        mainText1.setId("mainText1");
        mainText1.setWrapText(true);
        mainText1.setMaxWidth(350);

        Label innerText1 = new Label("Dont have account ?");
        innerText1.setId("innerText1");

        Button toSignUpButton = new Button("Create account ->");
        toSignUpButton.setId("toSignUpButton");

        VBox signUpContainer = createVBox(0, Pos.CENTER, "signUpContainer", innerText1, toSignUpButton, line11);
        VBox leftCNTR1 = createVBox(80, Pos.CENTER, "leftCNTR", mainText1, signUpContainer);

        Label mainText2 = new Label("JOIN US TO EXPLORE INDONESIAN CULTURE");
        mainText2.setId("mainText1");
        mainText2.setWrapText(true);
        mainText2.setMaxWidth(455);

        Button toLogInButton = new Button("<- return to login page");
        toLogInButton.setId("toSignUpButton");

        VBox loginContainer = createVBox(0, Pos.CENTER, "signUpContainer", toLogInButton, line22);
        VBox leftCNTR2 = createVBox(80, Pos.CENTER, "leftCNTR", mainText2, loginContainer);
        leftCNTR2.setVisible(false);

        StackPane leftMainContainer = new StackPane(leftCNTR1, leftCNTR2);
        leftMainContainer.setId("leftMainContainer");

        Label innerText2 = new Label("Login to your account");
        innerText2.setId("innerText2");

        TextField usernameTF1 = new TextField();
        usernameTF1.setPromptText("Username");
        usernameTF1.setId("userTextField");

        TextField passwordTF1 = new TextField();
        passwordTF1.setPromptText("Password");
        passwordTF1.setId("userTextField");

        Button loginButton = new Button("LOGIN");
        loginButton.setId("LSButton");
        loginButton.setPadding(new Insets(10));

        VBox textFieldContainer1 = createVBox(20, Pos.CENTER, "textFieldContainer1", usernameTF1, passwordTF1);
        VBox rightCNTR1 = createVBox(100, Pos.CENTER, "innerRightContainer", innerText2, textFieldContainer1, loginButton);

        Label innerText3 = new Label("Make your account");
        innerText3.setId("innerText2");

        TextField usernameTF2 = new TextField();
        usernameTF2.setPromptText("Username");
        usernameTF2.setId("userTextField");

        TextField passwordTF2 = new TextField();
        passwordTF2.setPromptText("Password");
        passwordTF2.setId("userTextField");

        TextField emailTF2 = new TextField();
        emailTF2.setPromptText("Email");
        emailTF2.setId("userTextField");

        Button signButton = new Button("SIGN UP");
        signButton.setId("LSButton");

        VBox textFieldContainer2 = createVBox(20, Pos.CENTER, "textFieldContainer1", usernameTF2, passwordTF2, emailTF2);
        VBox rightCNTR2 = createVBox(70, Pos.CENTER, "innerRightContainer", innerText3, textFieldContainer2, signButton);
        rightCNTR2.setVisible(false);

        String bgImage = getClass().getResource("/image/LayoutImage/bgImage.png").toExternalForm();
        StackPane rightMainContainer = new StackPane(rightCNTR1, rightCNTR2);
        rightMainContainer.setId("rightMainContainer");
        rightMainContainer.setStyle("-fx-background-image: url('" + bgImage + "');");

        Path path1 = new Path(new MoveTo(325, 325), new LineTo(-325, 325));
        Path path2 = new Path(new MoveTo(325, 325), new LineTo(975, 325));
        Path path3 = new Path(new MoveTo(975, 325), new LineTo(325, 325));
        Path path4 = new Path(new MoveTo(-500, 325), new LineTo(325, 325));

        PathTransition pathTransition1 = createPathTransition(Duration.seconds(2), path1, rightMainContainer);
        PathTransition pathTransition2 = createPathTransition(Duration.seconds(2), path2, leftMainContainer);
        PathTransition pathTransition3 = createPathTransition(Duration.seconds(2), path3, leftMainContainer);
        PathTransition pathTransition4 = createPathTransition(Duration.seconds(2), path4, rightMainContainer);

        FadeTransition fadeIn1 = createFadeTransition(Duration.seconds(2), 1, 0, rightCNTR1);
        FadeTransition fadeIn2 = createFadeTransition(Duration.seconds(2), 0, 1, rightCNTR2);
        FadeTransition fadeIn3 = createFadeTransition(Duration.seconds(2), 1, 0, leftCNTR1);
        FadeTransition fadeIn4 = createFadeTransition(Duration.seconds(2), 0, 1, leftCNTR2);

        FadeTransition fadeOut1 = createFadeTransition(Duration.seconds(2), 0, 1, rightCNTR1);
        FadeTransition fadeOut2 = createFadeTransition(Duration.seconds(2), 1, 0, rightCNTR2);
        FadeTransition fadeOut3 = createFadeTransition(Duration.seconds(2), 0, 1, leftCNTR1);
        FadeTransition fadeOut4 = createFadeTransition(Duration.seconds(2), 1, 0, leftCNTR2);

        toSignUpButton.setOnAction(v -> {
            pathTransition1.play();
            pathTransition2.play();
            rightCNTR1.setVisible(false);
            rightCNTR2.setVisible(true);
            leftCNTR1.setVisible(false);
            leftCNTR2.setVisible(true);
            fadeIn1.play();
            fadeIn2.play();
            fadeIn3.play();
            fadeIn4.play();

        });

        toLogInButton.setOnAction(v -> {
            pathTransition3.play();
            pathTransition4.play();
            rightCNTR1.setVisible(true);
            rightCNTR2.setVisible(false);
            leftCNTR1.setVisible(true);
            leftCNTR2.setVisible(false);
            fadeOut1.play();
            fadeOut2.play();
            fadeOut3.play();
            fadeOut4.play();
        });

        loginButton.setOnAction(v ->{
            String username = usernameTF1.getText();
            String password = passwordTF1.getText();
            System.out.println("helloworld");

            if (username.isEmpty() || password.isEmpty()) {
                // Display alert if any field is empty
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Username and password must be filled out.");
                alert.showAndWait();
            } else {
                boolean loginSuccessful = DataUserController.loginUser(username, password);
                if (loginSuccessful) {
                    System.out.println("Login successful!");
                    Scene2 scene2 = new Scene2(stage);
                    scene2.show();
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid username or password.");
                    alert.showAndWait();
                }
            }
        });

        signButton.setOnAction(v ->{
            String username = usernameTF2.getText();
            String email = emailTF2.getText();
            String password = passwordTF2.getText();

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
                pathTransition3.play();
                pathTransition4.play();
                rightCNTR1.setVisible(true);
                rightCNTR2.setVisible(false);
                leftCNTR1.setVisible(true);
                leftCNTR2.setVisible(false);
                fadeOut1.play();
                fadeOut2.play();
                fadeOut3.play();
                fadeOut4.play();
            }
        });

        BorderPane root = new BorderPane();
        root.setId("body");
        root.setLeft(leftMainContainer);
        root.setRight(rightMainContainer);
        Scene scene = new Scene(root, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/login.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
