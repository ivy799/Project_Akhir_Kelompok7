package projek.akhir.klp7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
        String recomend1BgImageUrl = getClass().getResource("/image/image19.png").toExternalForm();
        String recomend2BgImageUrl = getClass().getResource("/image/image19.png").toExternalForm();
        String recomend3BgImageUrl = getClass().getResource("/image/image19.png").toExternalForm();



        BorderPane root_1 = new BorderPane();
        root_1.setId("body");

        Label mainText = new Label("EXSPLOR MORE");
        mainText.setId("mainText");

        Label subText = new Label("EXSPLORE NUSANTARA");
        subText.setId("subText");
        
        
        Label label1 = new Label("CYTY/COUNTRY");
        label1.setId("recomendtext");
        BorderPane recomend1 = new BorderPane();
        recomend1.setPadding(new Insets(10));
        recomend1.setId("recomend");
        recomend1.setBottom(label1);
        recomend1.setStyle("-fx-background-image: url('" + recomend1BgImageUrl + "');");


        Label label2 = new Label("CULTURE");
        label2.setId("recomendtext");
        BorderPane recomend2 = new BorderPane();
        recomend2.setPadding(new Insets(10));
        recomend2.setId("recomend");
        recomend2.setBottom(label2);
        recomend2.setStyle("-fx-background-image: url('" + recomend2BgImageUrl + "');");


        Label label3 = new Label("CULINARY");
        label3.setId("recomendtext");
        BorderPane recomend3 = new BorderPane();
        recomend3.setPadding(new Insets(10));
        recomend3.setId("recomend");
        recomend3.setBottom(label3);
        recomend3.setStyle("-fx-background-image: url('" + recomend3BgImageUrl + "');");



        //listview item
        ListView<String> listView = new ListView<>();
        ObservableList<String> cityNames = FXCollections.observableArrayList(
                "BALI",
                "SINJAI",
                "BULUKUMBA",
                "BONE",
                "GOWA",
                "bandung",
                "jakarta",
                "solo",
                "pare-pare",
                "bali",
                "jogja",
                "surabaya",
                "yogyakarta"
                );

        
        
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
        recomendContainer.getChildren().addAll(subText,recomend1,recomend2,recomend3);
        


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
        backButtonContainer.setPadding(new Insets(0));


        VBox container3 = new VBox(70);
        container3.getChildren().addAll(backButtonContainer,container2);


        //button event listener
        backButton.setOnAction(V -> {
            Scene1 loginPage = new Scene1(stage);
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

        



        //scene layout
        root_1.setLeft(container1);
        root_1.setRight(container3);



        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/stylee.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
