package Controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class Searchcontroller {
    public Label id;
    public Label name;
    public Label qua;
    public Label price;
    public Label des;
    private List<Item> items = new ArrayList<>();

    public TextField search;

    public void searbtn(ActionEvent actionEvent) {
        String searchQuery = search.getText();
        Item item = searchContact(searchQuery);

        if(item == null){
            id.setText("ITEM NOT FOUND");
            name.setText("ITEM NOT FOUND");
            qua.setText("ITEM NOT FOUND");
            price.setText("ITEM NOT FOUND");
            des.setText("ITEM NOT FOUND");
        }else {
            id.setText(item.getId());
            name.setText(item.getName());
            qua.setText(String.valueOf(item.getQuantity()));
            price.setText(String.valueOf(item.getPrice()));
            des.setText(item.getDescription());
        }
    }

    public Item searchContact(String searchQuery) {
        // Fetch the items from the database if it's not already populated
        if (items.isEmpty()) {
            items.addAll(DBConnection.getInstance().getDBList());  // Assuming DBConnection returns a list of items
        }

        // Loop through the list of items to find a match
        for (Item item : items) {
            if (item.getId().equals(searchQuery) || item.getName().equalsIgnoreCase(searchQuery)) {
                return item;  // Return the found item
            }
        }

        return null;  // Return null if no item was found
    }

    public void backbtn(ActionEvent actionEvent) {
        Homecontroller.searStage.close();
    }
}
