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
// import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Scene4A {
    private Stage stage;
    
    
    //constructor
    public Scene4A(Stage stage) {
        this.stage = stage;
    }



    public void show(){
        
        //scene 4A main variabel
        String deskripsiWisata = "Apparalang Cliff, a very high and wide rock cliff, to enjoy the beauty of Apparalang Beach. Usually,\n it is the beach that offers bonus tourist offerings in the form of cliffs. However, unlike this one, it\n is the cliff that offers a tourist bonus in the form of a beautiful beach.";
        String namaWisata = "Apparalang\nBulukumba,south sulawesi";
        String bgimageUrl = getClass().getResource("/image/image12.png").toExternalForm();
        String ratingImageUrl = getClass().getResource("/image/comp1.png").toExternalForm();


        BorderPane root_1 = new BorderPane();
        root_1.setId("body");
        root_1.setStyle("-fx-background-image: url('" + bgimageUrl + "');");



        Label mainText = new Label(namaWisata);
        mainText.setId("namaWisata");

        Image rating = new Image(ratingImageUrl);
        ImageView imageView = new ImageView(rating);

        Image line = new Image("/image/line1.png");
        ImageView line1 = new ImageView(line);

        Button backButton = new Button("BACK");
        Button homeButton = new Button("HOME");
        backButton.setId("MainButton");
        homeButton.setId("MainButton");

        Button slideButton1 = new Button("<");
        Button slideButton2 = new Button(">");
        slideButton1.setId("slideButton");
        slideButton2.setId("slideButton");

        Label mainText2 = new Label(deskripsiWisata);
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
        container3.getChildren().addAll(backButton,spacer1,homeButton);
        container3.setPadding(new Insets(20));
        container3.setId("header");

        VBox mainContainer = new VBox(20);
        mainContainer.setId("mainContainer");
        mainContainer.getChildren().addAll(container1,linebox,container2);


        HBox mainDetail = new HBox();
        mainDetail.setId("mainDetail");
        mainDetail.getChildren().addAll(mainContainer);
        mainDetail.setAlignment(Pos.CENTER);

        // backButton.setOnAction(V -> {
        //     Scene4 scene3 = new Scene4(stage);
        //     scene3.show(); 
        // });

        homeButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });



        //scene layout
        root_1.setTop(container3);
        root_1.setBottom(mainDetail);

        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style4A.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    
}
