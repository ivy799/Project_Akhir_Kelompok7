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

public class Scene4A {
    private Stage stage;
    private Scene3 scene3;

    // Constructor
    public Scene4A(Stage stage, Scene3 scene3) {
        this.stage = stage;
        this.scene3 = scene3;
        initialize();
    }

    private void initialize() {
        // Main variables for scene 4A
        String Scene4ATripDetail = "Apparalang Cliff, a very high and wide rock cliff, to enjoy the beauty of Apparalang Beach. Usually,\n it is the beach that offers bonus tourist offerings in the form of cliffs. However, unlike this one, it\n is the cliff that offers a tourist bonus in the form of a beautiful beach.";
        String Scene4ATripName = "Apparalang\nBulukumba,south sulawesi";
        String Scene4ATripImageUrl = getClass().getResource("/image/image12.png").toExternalForm();
        String Scene4ATripRatingUrl = getClass().getResource("/image/comp1.png").toExternalForm();


        //layouting
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");
        root_1.setStyle("-fx-background-image: url('" + Scene4ATripImageUrl + "');");

        Label mainText = new Label(Scene4ATripName);
        mainText.setId("namaWisata");

        Image rating = new Image(Scene4ATripRatingUrl);
        ImageView imageView = new ImageView(rating);

        Image line = new Image("/image/line1.png");
        ImageView line1 = new ImageView(line);

        Button homeButton = new Button("HOME");
        homeButton.setId("MainButton");


        //button event listener
        Button backButton = new Button("BACK");
        backButton.setId("MainButton");
        backButton.setOnAction(V -> {
            scene3.show();
        });

        homeButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });



        //layouting
        Button slideButton1 = new Button("<");
        Button slideButton2 = new Button(">");
        slideButton1.setId("slideButton");
        slideButton2.setId("slideButton");

        Label mainText2 = new Label(Scene4ATripDetail);
        mainText2.setId("mainText2");

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        HBox linebox = new HBox(line1);
        linebox.setAlignment(Pos.CENTER);

        HBox container1 = new HBox(280);
        container1.getChildren().addAll(mainText, imageView);
        container1.setId("container1");
        container1.setPadding(new Insets(10));
        container1.setAlignment(Pos.CENTER);

        HBox container2 = new HBox();
        container2.getChildren().add(mainText2);
        container2.setPadding(new Insets(20));

        HBox container3 = new HBox();
        container3.getChildren().addAll(homeButton, spacer1, backButton);
        container3.setPadding(new Insets(20));
        container3.setId("header");

        VBox mainContainer = new VBox(20);
        mainContainer.setId("mainContainer");
        mainContainer.getChildren().addAll(container1, linebox, container2);

        HBox mainDetail = new HBox();
        mainDetail.setId("mainDetail");
        mainDetail.getChildren().addAll(mainContainer);
        mainDetail.setAlignment(Pos.CENTER);


        // Scene layout
        root_1.setTop(container3);
        root_1.setBottom(mainDetail);

        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style4A.css").toExternalForm());
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
