package projek.akhir.klp7;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import projek.controller.DataKotaControllerScene3;
import projek.model.DataKota;
import projek.model.DataUser;

public class Scene2 extends SceneUtil implements Show{
    private Stage stage;
    private DataUser userAccount;

    //constructor
    public Scene2(Stage stage,DataUser userAccount) {
        this.stage = stage;
        this.userAccount = userAccount;
    }

    


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


        
        ImageView profilIcon = new ImageView(new Image("/image/LayoutImage/icon3.png"));
        HBox profilButtonContainer = createHBox(0, Pos.TOP_RIGHT, null, profilIcon);
        profilButtonContainer.setPadding(new Insets(10));
        profilIcon.setId("profileButton");



        SceneUtil factory = new SceneUtil();
        BorderPane recomend1 = factory.createRecomendPane("/image/LayoutImage/Scene2RecomendImg1.png", "BALI", event -> {
            DataKota dataKota = DataKotaControllerScene3.getDataKota("BALI");
            Scene3 scene3 = new Scene3(stage, dataKota,userAccount);
            scene3.show();
        });
        recomend1.setOnMouseClicked(v ->{
            DataKota dataKota = DataKotaControllerScene3.getDataKota("BALI");
            Scene3 scene3 = new Scene3(stage, dataKota,userAccount);
            scene3.show();
        });


        

        BorderPane recomend2 = factory.createRecomendPane("/image/LayoutImage/Scene2RecomendImg2.png", "SURABAYA", event -> {
            DataKota dataKota = DataKotaControllerScene3.getDataKota("SURABAYA");
            Scene3 scene3 = new Scene3(stage, dataKota,userAccount);
            scene3.show();
        }); 
        recomend2.setOnMouseClicked(v ->{
            DataKota dataKota = DataKotaControllerScene3.getDataKota("SURABAYA");
            Scene3 scene3 = new Scene3(stage, dataKota,userAccount);
            scene3.show();
        });



        
        BorderPane recomend3 = factory.createRecomendPane("/image/LayoutImage/Scene2RecomendImg3.png", "MAKASSAR", event -> {
            DataKota dataKota = DataKotaControllerScene3.getDataKota("MAKASSAR");
            Scene3 scene3 = new Scene3(stage, dataKota,userAccount);
            scene3.show();
        });
        recomend3.setOnMouseClicked(v ->{
            DataKota dataKota = DataKotaControllerScene3.getDataKota("MAKASSAR");
            Scene3 scene3 = new Scene3(stage, dataKota,userAccount);
            scene3.show();
        });



        VBox recomendContainer = new VBox(5);
        recomendContainer.setAlignment(Pos.CENTER);
        recomendContainer.setId("recomendContainer");
        recomendContainer.getChildren().addAll(logo,subText,recomend1,recomend2,recomend3);
        HBox container2 = createHBox(0, Pos.CENTER, "container2", recomendContainer);
        VBox container3 = new VBox();
        container3.getChildren().addAll(profilButtonContainer,container2);




        //main article (left)
        Label mainText = new Label("EXSPLORE MORE");
        mainText.setId("mainText");

        TextField searchBar = new TextField();
        searchBar.setPromptText("ENTER CITY NAME...");
        searchBar.setId("searchField");

        Button searchButton = new Button("Search");
        searchButton.setId("searchButton");
        HBox searchBarContainer = createHBox(10, Pos.CENTER, "SearchBar", searchBar,searchButton);


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

        searchButton.setOnAction(e -> {
            String cityToSearch = searchBar.getText().toUpperCase().trim();
            if (cityToSearch.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a city name to search.");
                alert.showAndWait();
            } else if (cityNames.contains(cityToSearch)) {
                cityNames.remove(cityToSearch);
                cityNames.add(0, cityToSearch);
            }
        });
        

        HBox mainTextcontainer = createHBox(0, Pos.CENTER, "mainTextcontainer", mainText);
        VBox leftContainer = createVBox(0, Pos.CENTER, "listViewContainer", listView);
        VBox mainContainer = createVBox(15, Pos.CENTER, "mainContainer", mainTextcontainer,searchBarContainer, leftContainer);
        VBox container1 = createVBox(0, Pos.CENTER, "container1", mainContainer);


        
        //node animation
        FadeTransition fadein1 = createFadeTransition(Duration.seconds(0.5), 0, 1, recomend1);
        fadein1.play();
        FadeTransition fadein2 = createFadeTransition(Duration.seconds(2.5), 0, 1, recomend2);
        fadein2.play();
        FadeTransition fadein3 = createFadeTransition(Duration.seconds(3.5), 0, 2, recomend3);
        fadein3.play();


        
        //button event listener
        profilIcon.setOnMouseClicked(V -> {
            profile userAccount = new profile(stage, this.userAccount);
            userAccount.show();
        });

        listView.setItems(cityNames);
        listView.setId("listView");
        listView.setOnMouseClicked(e -> {
            String selectedCity = listView.getSelectionModel().getSelectedItem();
            DataKota dataKota = DataKotaControllerScene3.getDataKota(selectedCity);
            Scene3 scene3 = new Scene3(stage,dataKota,userAccount);
            scene3.show();
        });





        //layout arragnment
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");
        root_1.setLeft(container1);
        root_1.setRight(container3);
        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style2.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
