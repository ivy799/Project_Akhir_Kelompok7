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

public class Scene4B {
    private Stage stage;

    public Scene4B(Stage stage) {
        this.stage = stage;
    }

    public void show(){
        
        //Scene 4B main variabel
        String Scene4BUmkmImageUrl = getClass().getResource("/image/image23.png").toExternalForm();
        String Scene4BUmkmName = "JALANGKOTE RACING";
        String Scene4AUmkmRatingUrl = getClass().getResource("/image/image21.png").toExternalForm();
        String Scene4BLocationDetail = "lorem ipsum";
        String Scene4BProductDetail = "lorem ipsum";
        String Scene4BContactDetail = "lorem ipsum";
        

        BorderPane root_1 = new BorderPane();
        root_1.setId("body");
        root_1.setStyle("-fx-background-image: url('" + Scene4BUmkmImageUrl + "');");


        //HEADER
        Button backButton = new Button("BACK");
        backButton.setId("HeaderButton");

        Button homeButton = new Button("HOME");
        homeButton.setId("HeaderButton");

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        HBox header = new HBox();
        header.getChildren().addAll(homeButton,spacer1,backButton);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));


        //BODY
        String text = Scene4BUmkmName;
        Label mainText = new Label(text);
        mainText.setId("mainText");

        Image ratingimage = new Image(Scene4AUmkmRatingUrl);
        ImageView rating = new ImageView(ratingimage);

        HBox mainTextContainer = new HBox(mainText);
        mainTextContainer.setAlignment(Pos.CENTER);
        mainTextContainer.setAlignment(Pos.CENTER_RIGHT);

        VBox mainContainer = new VBox(20);
        mainContainer.getChildren().addAll(mainTextContainer,rating);
        mainContainer.setAlignment(Pos.CENTER_RIGHT);
        mainContainer.setPadding(new Insets(0, 130,0,0));

        
        //Detail
        Label location = new Label("LOCATION");
        location.setId("tittle");
        Label product = new Label("PRODUK");
        product.setId("tittle");
        Label contact = new Label("CONTACT");
        contact.setId("tittle");
        
        
        //location detail
        Image line1 = new Image("/image/line2.png");
        ImageView line11 = new ImageView(line1);

        Label locationDetail = new Label(Scene4BLocationDetail); 
        locationDetail.setId("detail");
        
        HBox locationDetailContainer = new HBox(locationDetail);
        locationDetailContainer.setAlignment(Pos.CENTER);
        
        VBox locationContainer = new VBox(10);
        locationContainer.setAlignment(Pos.CENTER);
        locationContainer.setId("container");
        locationContainer.getChildren().addAll(location,line11,locationDetailContainer);
        

        //product detail
        Image line2 = new Image("/image/line2.png");
        ImageView line22 = new ImageView(line2);

        Label productDetail = new Label(Scene4BProductDetail); 
        productDetail.setId("detail");
        
        HBox productDetailContainer = new HBox(productDetail);
        productDetailContainer.setAlignment(Pos.CENTER);

        VBox productContainer = new VBox(10);
        productContainer.setAlignment(Pos.CENTER);
        productContainer.setId("container");
        productContainer.getChildren().addAll(product,line22,productDetailContainer);


        //contact detail
        Image line3 = new Image("/image/line2.png");
        ImageView line33 = new ImageView(line3);

        Label contactDetail = new Label(Scene4BContactDetail); 
        contactDetail.setId("detail");
        
        HBox contactDetailContainer = new HBox(contactDetail);
        contactDetailContainer.setAlignment(Pos.CENTER);

        VBox contactContainer = new VBox(10);
        contactContainer.setAlignment(Pos.CENTER);
        contactContainer.setId("container");
        contactContainer.getChildren().addAll(contact,line33,contactDetailContainer);



        //button eventListener
        // backButton.setOnAction(V -> {
        //     Scene3 scene3 = new Scene3(stage);
        //     scene3.show(); 
        // });

        homeButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });

        

        HBox mainDetail = new HBox(40);
        mainDetail.getChildren().addAll(locationContainer,productContainer,contactContainer);
        mainDetail.setId("mainDetail");
        mainDetail.setAlignment(Pos.TOP_CENTER);





        homeButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });



        root_1.setTop(header);
        root_1.setCenter(mainContainer);
        root_1.setBottom(mainDetail);


        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style4B.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


}
