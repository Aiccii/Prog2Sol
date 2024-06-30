package be.kdg.birds.View;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class View extends BorderPane {

    MenuBar menuBar;
    Menu menu;
    MenuItem menuItem;
    ImageView imageView;
    ImageView secondaryImageView;
    ImageView thirdImageView;
    Image image;
    Image image1;
    Image image2;
    CheckBox checkBox;




    private void initializeNodes() {

         checkBox = new CheckBox();

         image = new Image("/angrybird.png");

         imageView = new ImageView(image);
         secondaryImageView = new ImageView(image);
         thirdImageView = new ImageView(image);

         menuItem = new MenuItem("File");
         menu = new Menu("File");
         menuBar = new MenuBar(menu);



    }

    private void layoutNodes() {

        menuItem.setGraphic(imageView); // to set the photo
        menu.getItems().add(menuItem); // adds the menu item to the menu

        checkBox.setGraphic(thirdImageView); // sets the checkbox photo


        menu.setGraphic(new ImageView(image));



        setTop(menuBar);
        setCenter(checkBox);

    }


    public View() {
        initializeNodes();
        layoutNodes();
    }


}
