package Controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class Deletecontroller {
    // List to store items fetched from the database
    private List<Item> items = new ArrayList<>();
    private  int index;

    // UI components
    public TextField sear;
    public Label id;
    public Label name;
    public Label qua;
    public Label pri;
    public Label des;

    // This method is triggered when the search button is clicked
    public void searbtn(ActionEvent actionEvent) {
        String searchQuery = sear.getText();
        Item item = searchContact(searchQuery);
        index = getContactIndex(searchQuery);

        if(item == null){
            id.setText("ITEM NOT FOUND");
            name.setText("ITEM NOT FOUND");
            qua.setText("ITEM NOT FOUND");
            pri.setText("ITEM NOT FOUND");
            des.setText("ITEM NOT FOUND");
        }else {
            id.setText(item.getId());
            name.setText(item.getName());
            qua.setText(String.valueOf(item.getQuantity()));
            pri.setText(String.valueOf(item.getPrice()));
            des.setText(item.getDescription());
        }
    }

    public void delbtn(ActionEvent actionEvent) {
        upConID(index);
    }

    public void cancbtn(ActionEvent actionEvent) {
        id.setText("");
        name.setText("");
        qua.setText("");
        pri.setText("");
        des.setText("");
    }

    public void bthbtn(ActionEvent actionEvent) {
        Homecontroller.delStage.close();
    }

    // This method searches for the item based on the search query
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

    public int getContactIndex(String searchQuery) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId().equals(searchQuery) || item.getName().equalsIgnoreCase(searchQuery)) {
                return i;  // Return Item and its index
            }
        }
        return -1;
    }

    public void upConID(int index) {
        if (index < 0 || index >= items.size()) {
            return;  // Index is invalid, do nothing
        }

        // Remove the item from the list
        items.remove(index);

        // You may want to update the database here to persist the changes
        // Assuming such a method exists

        DBConnection.getInstance().getDBList().remove(index);
        // Optional: Clear the UI after deletion
        id.setText("");
        name.setText("");
        qua.setText("");
        pri.setText("");
        des.setText("");
    }
}
