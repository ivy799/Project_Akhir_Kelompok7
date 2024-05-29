package projek.akhir.klp7;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import projek.model.DataKota;

public class Scene3 extends AbstractAnimation implements Show{
    private Stage stage;
    protected DataKota dataKota;

    public Scene3() {
    }

    public Scene3(Stage stage, DataKota dataKota) {
        this.stage = stage;
        this.dataKota = dataKota;
    }

    @Override
    public void show() {

        // header
        BorderPane root_1 = new BorderPane();
        root_1.setId("body");

        Label namaKota = new Label(dataKota.getNamaKota());
        namaKota.setId("namaKota");

        Button backButton = new Button("BACK");
        Button homeButton = new Button("HOME");
        backButton.setId("button");
        homeButton.setId("button");

        Image logo = new Image(getClass().getResourceAsStream("/image/image25.png"));
        ImageView logoImage = new ImageView(logo);
        logoImage.setId("logo");

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        HBox header = new HBox();
        header.setPadding(new Insets(10));
        header.getChildren().addAll(homeButton,spacer1,namaKota,spacer2,backButton);
        header.setId("header");

        //Header button eventListener
        backButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });

        homeButton.setOnAction(V -> {
            Scene2 scene2 = new Scene2(stage);
            scene2.show(); 
        });




        //main article (right)

        //TRIP
        //trip section layouting
        Label rightTittle1 = new Label("TRAVEL");
        rightTittle1.setId("rightTittle");

        String[] scene3TripImageUrls = new String[]{dataKota.getScene3TripImageUrl1(), dataKota.getScene3TripImageUrl2(), dataKota.getScene3TripImageUrl3()};
        String[] scene3TripNames = new String[]{dataKota.getScene3TripName1(), dataKota.getScene3TripName2(), dataKota.getScene3TripName3()};
        String[] scene4ATripDetails = new String[]{dataKota.getScene4ATripDetail1(), dataKota.getScene4ATripDetail2(), dataKota.getScene4ATripDetail3()};
        String[] scene4ATripRatingUrls = new String[]{dataKota.getScene4ATripRatingUrl1(), dataKota.getScene4ATripRatingUrl2(), dataKota.getScene4ATripRatingUrl3()};
        String[] scene4ATripImageUrls = new String[]{dataKota.getScene4ATripImageUrl1(), dataKota.getScene4ATripImageUrl2(), dataKota.getScene4ATripImageUrl3()};
        String[] scene4ATripNames = new String[]{dataKota.getScene4ATripName1(), dataKota.getScene4ATripName2(), dataKota.getScene4ATripName3()};


        
        BorderPane[] rightImages = new BorderPane[3];
        Button[] tripNameContainers = new Button[3];

        for (int i = 0; i < rightImages.length; i++) {
            String imageUrl = getClass().getResource(scene3TripImageUrls[i]).toExternalForm();
            String tripName = scene3TripNames[i];

            tripNameContainers[i] = new Button(tripName);
            tripNameContainers[i].setPadding(new Insets(5));
            tripNameContainers[i].setId("tripName");

            rightImages[i] = new BorderPane();
            rightImages[i].setBottom(tripNameContainers[i]);
            rightImages[i].setId("rightImage");
            rightImages[i].setStyle("-fx-background-image: url('" + imageUrl + "');");

            int finalI = i;
            tripNameContainers[i].setOnAction(V -> {
                Scene4A scene4A = new Scene4A(stage, this, scene4ATripDetails[finalI], scene4ATripImageUrls[finalI], scene4ATripNames[finalI], scene4ATripRatingUrls[finalI]);
                scene4A.show();
            });
        }

        HBox innerRightContainer1 = new HBox(30);
        innerRightContainer1.setAlignment(Pos.CENTER);
        innerRightContainer1.getChildren().addAll(rightImages);

        VBox rightContainer1 = new VBox(50);
        rightContainer1.setId("rightContainer");
        rightContainer1.getChildren().addAll(rightTittle1, innerRightContainer1);
        



        //UMKM
        //Umkm Section Layouting
        String[] scene3UmkmImageUrls = new String[]{dataKota.getScene3UmkmImageUrl1(), dataKota.getScene3UmkmImageUrl2(), dataKota.getScene3UmkmImageUrl3()};
        String[] scene3UmkmNames = new String[]{dataKota.getScene3UmkmName1(), dataKota.getScene3UmkmName2(), dataKota.getScene3UmkmName3()};
        String[] scene4BUmkmImageUrls = new String[]{dataKota.getScene4BUmkmImageUrl1(), dataKota.getScene4BUmkmImageUrl2(), dataKota.getScene4BUmkmImageUrl3()};
        String[] scene4BUmkmNames = new String[]{dataKota.getScene4BUmkmName1(), dataKota.getScene4BUmkmName2(), dataKota.getScene4BUmkmName3()};
        String[] scene4BLocationDetails = new String[]{dataKota.getScene4BLocationDetail1(), dataKota.getScene4BLocationDetail2(), dataKota.getScene4BLocationDetail3()};
        String[] scene4BProductDetails = new String[]{dataKota.getScene4BProductDetail1(), dataKota.getScene4BProductDetail2(), dataKota.getScene4BProductDetail3()};
        String[] scene4BContactDetails = new String[]{dataKota.getScene4BContactDetail1(), dataKota.getScene4BContactDetail2(), dataKota.getScene4BContactDetail3()};
        String[] scene4BTripRatingUrls = new String[]{dataKota.getScene4BUmkmRatingUrl1(), dataKota.getScene4BUmkmRatingUrl2(), dataKota.getScene4BUmkmRatingUrl3()};


        Label rightTittle2 = new Label("MSMEs");
        rightTittle2.setId("rightTittle");

        VBox rightContainer2 = new VBox(35);
        rightContainer2.setId("rightContainer");
        rightContainer2.getChildren().add(rightTittle2);

        HBox innerRightContainer2 = new HBox(25);
        innerRightContainer2.setAlignment(Pos.CENTER);

        for (int i = 0; i < 3; i++) {
            ImageView umkmImg = new ImageView(new Image(scene3UmkmImageUrls[i]));
            Button umkmName = new Button(scene3UmkmNames[i]);
            umkmName.setPadding(new Insets(10));
            umkmName.setId("umkmName");
            VBox rightImage = new VBox(10);
            rightImage.getChildren().addAll(umkmImg, umkmName);
            rightImage.setId("umkm");

            int finalI = i;
            umkmName.setOnAction(V -> {
                Scene4B scene4B = new Scene4B(stage, this, scene4BUmkmImageUrls[finalI], scene4BUmkmNames[finalI], 
                scene4BTripRatingUrls[finalI], scene4BLocationDetails[finalI], 
                scene4BProductDetails[finalI], scene4BContactDetails[finalI]);
                scene4B.show();
            });

            innerRightContainer2.getChildren().add(rightImage);
        }

        rightContainer2.getChildren().add(innerRightContainer2);








        // Main Article (left)
        ListView<ItemData> listView = new ListView<>();
        listView.setId("listView");
        listView.getItems().addAll(getItemData());

        listView.setCellFactory(new Callback<ListView<ItemData>, ListCell<ItemData>>() {
            @Override
            public ListCell<ItemData> call(ListView<ItemData> listView) {
                return new ButtonListCell();
            }
        });

        Label leftTittle = new Label("CULTURE");
        leftTittle.setAlignment(Pos.CENTER);
        leftTittle.setId("leftTittle");

        HBox leftTittleContainer = new HBox(leftTittle);
        leftTittleContainer.setAlignment(Pos.CENTER);
        leftTittleContainer.setId("leftTittleContainer");

        VBox leftContainer = new VBox(40);
        leftContainer.setPadding(new Insets(10));
        leftContainer.setId("leftContainer");
        leftContainer.getChildren().addAll(leftTittleContainer,listView);


        VBox mainRightContainer = new VBox(20);
        mainRightContainer.getChildren().addAll(rightContainer1,rightContainer2);




        //node animation
        Path path1 = new Path();
    path1.getElements().add(new MoveTo(290, 50));
    path1.getElements().add(new LineTo(290, 125));
    PathTransition pathTransition1 = createPathTransition(Duration.seconds(1), path1, rightContainer1);
    FadeTransition fadein1 = createFadeTransition(Duration.seconds(1), 0, 1, rightContainer1);
    pathTransition1.play();
    fadein1.play();

    Path path2 = new Path();
    path2.getElements().add(new MoveTo(290, 170));
    path2.getElements().add(new LineTo(290, 130));
    PathTransition pathTransition2 = createPathTransition(Duration.seconds(1), path2, rightContainer2);
    FadeTransition fadein2 = createFadeTransition(Duration.seconds(1), 0, 1, rightContainer2);
    pathTransition2.play();
    fadein2.play();

    Path path3 = new Path();
    path3.getElements().add(new MoveTo(1, 265));
    path3.getElements().add(new LineTo(330, 265));
    PathTransition pathTransition3 = createPathTransition(Duration.seconds(1), path3, leftContainer);
    FadeTransition fadein3 = createFadeTransition(Duration.seconds(1), 0, 1, leftContainer);
    pathTransition3.play();
    fadein3.play();




        // Layout arrangement
        BorderPane mainContainer = new BorderPane();
        mainContainer.setPadding(new Insets(20));
        mainContainer.setLeft(leftContainer);
        mainContainer.setRight(mainRightContainer);
        root_1.setCenter(mainContainer);
        root_1.setTop(header);

        Scene scene = new Scene(root_1, 1300, 650);
        scene.getStylesheets().add(getClass().getResource("/styling/style3.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }




    //list item and additional class
    private List<ItemData> getItemData() {
        List<ItemData> items = new ArrayList<>();
        items.add(new ItemData("HISTORY AND HERITAGE", dataKota.getScene3HistoryText1(), dataKota.getScene3HistoryImageUrl1(), dataKota.getScene3HistoryText2(), dataKota.getScene3HistoryImageUrl2(), dataKota.getScene3HistoryText3(), dataKota.getScene3HistoryImageUrl3()));
        items.add(new ItemData("TRADITIONS AND CEREMONIES", dataKota.getScene3TraditionText1(), dataKota.getScene3TraditionImageUrl1(), dataKota.getScene3TraditionText2(), dataKota.getScene3TraditionImageUrl2(), dataKota.getScene3TraditionText3(), dataKota.getScene3TraditionImageUrl3()));
        items.add(new ItemData("CULINARY", dataKota.getScene3FoodText1(), dataKota.getScene3FoodImageUrl1(), dataKota.getScene3FoodText2(), dataKota.getScene3FoodImageUrl2(), dataKota.getScene3FoodText3(), dataKota.getScene3FoodImageUrl3()));
        return items;
    }
    

    static class ItemData {
        private final String title;
        private final String text1;
        private final String imageUrl1;
        private final String text2;
        private final String imageUrl2;
        private final String text3;
        private final String imageUrl3;

        public ItemData(String title, String text1, String imageUrl1, String text2, String imageUrl2, String text3, String imageUrl3) {
            this.title = title;
            this.text1 = text1;
            this.imageUrl1 = imageUrl1;
            this.text2 = text2;
            this.imageUrl2 = imageUrl2;
            this.text3 = text3;
            this.imageUrl3 = imageUrl3;
        }

        public String getTitle() {
            return title;
        }

        public String getText1() {
            return text1;
        }

        public String getImageUrl1() {
            return imageUrl1;
        }

        public String getText2() {
            return text2;
        }

        public String getImageUrl2() {
            return imageUrl2;
        }

        public String getText3() {
            return text3;
        }

        public String getImageUrl3() {
            return imageUrl3;
        }
    }

    static class ButtonListCell extends ListCell<ItemData> {
    private final VBox vbox;
    private final Button button;
    private final StackPane buttonPane;
    private final HBox innerContainer1;
    private final HBox innerContainer2;
    private final HBox innerContainer3;
    private boolean isExpanded;

    public ButtonListCell() {
        vbox = new VBox(20);
        button = new Button();
        button.setId("listViewButton");
        buttonPane = new StackPane();
        buttonPane.setId("buttonContainer");
        innerContainer1 = new HBox(20);
        innerContainer2 = new HBox(20);
        innerContainer3 = new HBox(20);

        button.setOnAction(e -> toggleDetails());

        buttonPane.getChildren().add(button);
        vbox.getChildren().add(buttonPane);
    }

    @Override
    protected void updateItem(ItemData item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            button.setText(item.getTitle());

            updateContainer2(innerContainer1, item.getText1(), item.getImageUrl1());
            updateContainer1(innerContainer2, item.getText2(), item.getImageUrl2());
            updateContainer2(innerContainer3, item.getText3(), item.getImageUrl3());

            if (isExpanded) {
                if (!vbox.getChildren().contains(innerContainer1)) {
                    vbox.getChildren().addAll(innerContainer1, innerContainer2, innerContainer3);
                }
            } else {
                vbox.getChildren().removeAll(innerContainer1, innerContainer2, innerContainer3);
            }

            setGraphic(vbox);
        }
    }

    private void updateContainer1(HBox container, String text, String imageUrl) {
        container.getChildren().clear();
        Label containerText = new Label(text);
        containerText.setWrapText(true);
        containerText.setMaxWidth(390);
        containerText.setId("detailText");
        ImageView containerImage = new ImageView(new Image(getClass().getResourceAsStream(imageUrl)));
        container.getChildren().addAll(containerText, containerImage);
    }

    private void updateContainer2(HBox container, String text, String imageUrl) {
        container.getChildren().clear();
        Label containerText = new Label(text);
        containerText.setWrapText(true);
        containerText.setMaxWidth(390);
        containerText.setId("detailText");
        ImageView containerImage = new ImageView(new Image(getClass().getResourceAsStream(imageUrl)));
        container.getChildren().addAll(containerImage, containerText);
    }

    private void toggleDetails() {
        isExpanded = !isExpanded;
        if (isExpanded) {
            if (!vbox.getChildren().contains(innerContainer1)) {
                vbox.getChildren().addAll(innerContainer1, innerContainer2, innerContainer3);
            }
        } else {
            vbox.getChildren().removeAll(innerContainer1, innerContainer2, innerContainer3);
        }
        setGraphic(vbox);
    }
}

    
}