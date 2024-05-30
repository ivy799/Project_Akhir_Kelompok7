package projek.akhir.klp7;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projek.controller.DataKotaControllerScene3;
import projek.model.DataKota;



public class Scene4A extends Scene3{
    private DataKota dataKota;
    private Stage stage;
    private String getScene4ATripDetail,getScene4ATripImageUrl,getScene4ATripName,getScene4ATripRatingUrl;

    // Constructor
    public Scene4A(Stage stage, DataKota dataKota,String getScene4ATripDetail, String getScene4ATripImageUrl,String getScene4ATripName, String getScene4ATripRatingUrl ) {
        this.stage = stage;
        this.dataKota = dataKota;
        this.getScene4ATripDetail = getScene4ATripDetail;
        this.getScene4ATripImageUrl = getScene4ATripImageUrl;
        this.getScene4ATripName = getScene4ATripName;
        this.getScene4ATripRatingUrl = getScene4ATripRatingUrl;
        initialize();
    }

    

    private void initialize() {
        
        //layouting
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");
        root_1.setStyle("-fx-background-image: url(" + getScene4ATripImageUrl + ");");

        Label mainText = new Label(getScene4ATripName);
        mainText.setId("namaWisata");

        Image rating = new Image(getScene4ATripRatingUrl);
        ImageView imageView = new ImageView(rating);

        Image line = new Image("/image/line1.png");
        ImageView line1 = new ImageView(line);

        Button homeButton = new Button("HOME");
        homeButton.setId("MainButton");

        Button backButton = new Button("BACK");
        backButton.setId("MainButton");


        //button event listener
        backButton.setOnAction(V -> {
            this.dataKota = DataKotaControllerScene3.getDataKota(dataKota.getNamaKota());
            Scene3 scene3 = new Scene3(stage,this.dataKota);
            scene3.show();
        });

        homeButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });



        //layouting

        Label mainText2 = new Label(getScene4ATripDetail);
        mainText2.setId("mainText2");
        mainText2.setWrapText(true);
        mainText2.setMaxWidth(590);

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        HBox linebox = new HBox(line1);
        linebox.setAlignment(Pos.CENTER);

        HBox container1 = createHBox(280, Pos.CENTER, "container1", mainText, imageView);
        container1.setPadding(new Insets(10));

        HBox container2 = createHBox(0, null, null, mainText2);
        container2.setPadding(new Insets(20));

        HBox container3 = createHBox(0, null, "header", homeButton, spacer1, backButton);
        container3.setPadding(new Insets(20));

        VBox mainContainer = createVBox(0, null, "mainContainer", container1, linebox, container2);
        HBox mainDetail = createHBox(0, Pos.CENTER, "mainDetail", mainContainer);



        // Scene layout
        root_1.setTop(container3);
        root_1.setBottom(mainDetail);

        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style4A.css").toExternalForm());
        stage.setScene(scene);
    }

    @Override
    public void show() {
        stage.show();
    }
}
