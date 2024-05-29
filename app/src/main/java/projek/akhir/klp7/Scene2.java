package projek.akhir.klp7;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import projek.controller.DataKotaController;
import projek.model.DataKota;

public class Scene2 extends AbstractAnimation implements Show{
    private Stage stage;

    //constructor
    public Scene2(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void show(){
        
        // main Article (right)
        Image logoUrl = new Image("/image/LayoutImage/logo1.png");
        ImageView logo = new ImageView(logoUrl);


        Label subText = new Label("EXSPLORE NUSANTARA");
        subText.setId("subText");


        Button backButton = new Button("BACK");
        backButton.setId("backButton");
        HBox backButtonContainer = new HBox(backButton);
        backButtonContainer.setAlignment(Pos.TOP_RIGHT);
        backButtonContainer.setPadding(new Insets(10));


        String recomendBgImageUrl1 = getClass().getResource("/image/LayoutImage/Scene2RecomendImg1.png").toExternalForm();
        Label label1 = new Label("BALI");
        label1.setId("recomendtext");
        BorderPane recomend1 = new BorderPane();
        recomend1.setPadding(new Insets(10));
        recomend1.setId("recomend");
        recomend1.setBottom(label1);
        recomend1.setStyle("-fx-background-image: url('" + recomendBgImageUrl1 + "');");


        String recomendBgImageUrl2 = getClass().getResource("/image/LayoutImage/Scene2RecomendImg2.png").toExternalForm();
        Label label2 = new Label("SURABAYA");
        label2.setId("recomendtext");
        BorderPane recomend2 = new BorderPane();
        recomend2.setPadding(new Insets(10));
        recomend2.setId("recomend");
        recomend2.setBottom(label2);
        recomend2.setStyle("-fx-background-image: url('" + recomendBgImageUrl2 + "');");

        
        String recomendBgImageUrl3 = getClass().getResource("/image/LayoutImage/Scene2RecomendImg3.png").toExternalForm();
        Label label3 = new Label("MAKASSAR");
        label3.setId("recomendtext");
        BorderPane recomend3 = new BorderPane();
        recomend3.setPadding(new Insets(10));
        recomend3.setId("recomend");
        recomend3.setBottom(label3);
        recomend3.setStyle("-fx-background-image: url('" + recomendBgImageUrl3 + "');");


        VBox recomendContainer = new VBox(10);
        recomendContainer.setAlignment(Pos.CENTER);
        recomendContainer.setId("recomendContainer");
        recomendContainer.getChildren().addAll(logo,subText,recomend1,recomend2,recomend3);

        HBox container2 = new HBox(recomendContainer);
        container2.setId("container2");
        container2.setAlignment(Pos.CENTER);

        VBox container3 = new VBox();
        container3.getChildren().addAll(backButtonContainer,container2);






        //main article (left)
        Label mainText = new Label("EXSPLORE MORE");
        mainText.setId("mainText");

        ListView<String> listView = new ListView<>();
        ObservableList<String> cityNames = FXCollections.observableArrayList(
                "BALI",
                "MAKASSAR",
                "BULUKUMBA",
                "BONE",
                "GOWA",
                "BANDUNG",
                "JAKARTA",
                "SOLO",
                "PARE-PARE",
                "BALI",
                "JOGJA",
                "SURABAYA",
                "YOGYAKARTA"
                );
        

        HBox mainTextcontainer = new HBox(mainText);
        mainTextcontainer.setAlignment(Pos.CENTER);
        mainTextcontainer.setId("mainTextcontainer");


        VBox leftContainer = new VBox();
        leftContainer.getChildren().addAll(listView);
        leftContainer.setAlignment(Pos.CENTER);
        leftContainer.setId("listViewContainer");


        VBox mainContainer = new VBox(15);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setId("mainContainer");
        mainContainer.getChildren().addAll(mainTextcontainer, leftContainer);

        VBox container1 = new VBox();
        container1.getChildren().addAll(mainContainer);
        container1.setAlignment(Pos.CENTER);
        container1.setId("container1");

        



        //node animation
        FadeTransition fadein1 = createFadeTransition(Duration.seconds(0.5), 0, 1, recomend1);
        fadein1.play();

        FadeTransition fadein2 = createFadeTransition(Duration.seconds(2.5), 0, 1, recomend2);
        fadein2.play();

        FadeTransition fadein3 = createFadeTransition(Duration.seconds(3.5), 0, 2, recomend3);
        fadein3.play();


        

        

        //button event listener
        backButton.setOnAction(V -> {
            LoginScene loginPage = new LoginScene(stage);
            loginPage.show(); 
        });


        label1.setOnMouseClicked(event -> {
            DataKota dataKota = DataKotaController.getDataKota("BALI");
            Scene3 scene3 = new Scene3(stage,dataKota);
            scene3.show();
        });
        label2.setOnMouseClicked(event -> {
            DataKota dataKota = DataKotaController.getDataKota("SURABAYA");
            Scene3 scene3 = new Scene3(stage,dataKota);
            scene3.show();
        });
        label3.setOnMouseClicked(event -> {
            DataKota dataKota = DataKotaController.getDataKota("MAKASSAR");
            Scene3 scene3 = new Scene3(stage,dataKota);
            scene3.show();
        });


        listView.setItems(cityNames);
        listView.setId("listView");

        listView.setOnMouseClicked(e -> {
            String selectedCity = listView.getSelectionModel().getSelectedItem();
            DataKota dataKota = DataKotaController.getDataKota(selectedCity);
            Scene3 scene3 = new Scene3(stage,dataKota);
            scene3.show();
        });





        //layout arragnment
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");
        root_1.setLeft(container1);
        root_1.setRight(container3);



        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/stylee.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
