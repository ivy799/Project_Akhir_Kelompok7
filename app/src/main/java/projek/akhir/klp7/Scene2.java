package projek.akhir.klp7;

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
import projek.controller.DataKotaController;
import projek.model.DataKota;

public class Scene2 {
    private Stage stage;

    //constructor
    public Scene2(Stage stage) {
        this.stage = stage;
    }



    public void show(){
        //scene 2 main variabel
        String recomendBgImageUrl1 = getClass().getResource("/image/LayoutImage/Scene2RecomendImg1.png").toExternalForm();
        Label label1 = new Label("CITY");
        label1.setId("recomendtext");
        BorderPane recomend1 = new BorderPane();
        recomend1.setPadding(new Insets(10));
        recomend1.setId("recomend");
        recomend1.setBottom(label1);
        recomend1.setStyle("-fx-background-image: url('" + recomendBgImageUrl1 + "');");

        String recomendBgImageUrl2 = getClass().getResource("/image/LayoutImage/Scene2RecomendImg2.png").toExternalForm();
        Label label2 = new Label("TRIP");
        label2.setId("recomendtext");
        BorderPane recomend2 = new BorderPane();
        recomend2.setPadding(new Insets(10));
        recomend2.setId("recomend");
        recomend2.setBottom(label2);
        recomend2.setStyle("-fx-background-image: url('" + recomendBgImageUrl2 + "');");

        String recomendBgImageUrl3 = getClass().getResource("/image/image19.png").toExternalForm();
        Label label3 = new Label("UMKM");
        label3.setId("recomendtext");
        BorderPane recomend3 = new BorderPane();
        recomend3.setPadding(new Insets(10));
        recomend3.setId("recomend");
        recomend3.setBottom(label3);
        recomend3.setStyle("-fx-background-image: url('" + recomendBgImageUrl3 + "');");



        label1.setOnMouseClicked(event -> {
            DataKota dataKota = DataKotaController.getDataKota("BALI");
            Scene3 scene3 = new Scene3(stage,dataKota);
            scene3.show();
        });

        //TODO 1
        label2.setOnMouseClicked(event -> {
            DataKota dataKota = DataKotaController.getDataKota("BALI");
            Scene3 scene3 = new Scene3(stage,dataKota);
            String A = scene3.dataKota.getScene4ATripDetail1();
            String B = scene3.dataKota.getScene4ATripRatingUrl1();
            String C = scene3.dataKota.getScene4ATripImageUrl1();
            String D = scene3.dataKota.getScene4ATripName1();
            Scene4A scene4A = new Scene4A(stage,scene3,A,B,C,D);
            scene4A.show();
        });




        //layouting
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");

        //listview item
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


                
        Label mainText = new Label("EXSPLORE MORE");
        mainText.setId("mainText");

        Label subText = new Label("EXSPLORE NUSANTARA");
        subText.setId("subText");

        Image logoUrl = new Image("/image/LayoutImage/logo1.png");
        ImageView logo = new ImageView(logoUrl);
        

        VBox leftContainer = new VBox();
        leftContainer.getChildren().addAll(listView);
        leftContainer.setAlignment(Pos.CENTER);
        leftContainer.setId("listViewContainer");

        HBox mainTextcontainer = new HBox(mainText);
        mainTextcontainer.setAlignment(Pos.CENTER);
        mainTextcontainer.setId("mainTextcontainer");

        VBox mainContainer = new VBox(15);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setId("mainContainer");
        mainContainer.getChildren().addAll(mainTextcontainer, leftContainer);
        
        VBox recomendContainer = new VBox(10);
        recomendContainer.setAlignment(Pos.CENTER);
        recomendContainer.setId("recomendContainer");
        recomendContainer.getChildren().addAll(logo,subText,recomend1,recomend2,recomend3);
        
        VBox container1 = new VBox();
        container1.getChildren().addAll(mainContainer);
        container1.setAlignment(Pos.CENTER);
        container1.setId("container1");

        HBox container2 = new HBox(recomendContainer);
        container2.setId("container2");
        container2.setAlignment(Pos.CENTER);

        Button backButton = new Button("BACK");
        backButton.setId("backButton");
        HBox backButtonContainer = new HBox(backButton);
        backButtonContainer.setAlignment(Pos.TOP_RIGHT);
        backButtonContainer.setPadding(new Insets(10));

        VBox container3 = new VBox();
        container3.getChildren().addAll(backButtonContainer,container2);



        //button event listener
        backButton.setOnAction(V -> {
            Scene1A loginPage = new Scene1A(stage);
            loginPage.show(); 
        });

        //listview item listener
        listView.setItems(cityNames);
        listView.setId("listView");

        listView.setOnMouseClicked(e -> {
            String selectedCity = listView.getSelectionModel().getSelectedItem();
            DataKota dataKota = DataKotaController.getDataKota(selectedCity);
            Scene3 scene3 = new Scene3(stage,dataKota);
            scene3.show();
        });





        //layout arragnment
        root_1.setLeft(container1);
        root_1.setRight(container3);



        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/stylee.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
