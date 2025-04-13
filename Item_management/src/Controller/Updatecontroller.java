package Controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class Updatecontroller {
    Item item = new Item();
    public TextField search;
    public Button cancelbtnaction;
    public Button bthbtnaction;
    private List<Item> items = new ArrayList<>();
    private int index;

    public TextField id;
    public TextField name;
    public TextField quantity;
    public TextField price;
    public TextField dis;



    public void searbtn(ActionEvent actionEvent) {
        String searchQuery = search.getText();
        item = searchContact(searchQuery);
        index = getContactIndex(searchQuery);

        if(item == null){
            id.setText("ITEM NOT FOUND");
            name.setText("ITEM NOT FOUND");
            quantity.setText("ITEM NOT FOUND");
            price.setText("ITEM NOT FOUND");
            dis.setText("ITEM NOT FOUND");
        }else {
            id.setText(item.getId());
            name.setText(item.getName());
            quantity.setText(String.valueOf(item.getQuantity()));
            price.setText(String.valueOf(item.getPrice()));
            dis.setText(item.getDescription());
        }
    }

    public void upbtn(ActionEvent actionEvent) {

        String ID = id.getText();
        String Name = name.getText();
        Integer Quantity = Integer.valueOf(quantity.getText());
        Double Price = Double.valueOf(price.getText());
        String Desc = dis.getText();

        Item item = new Item(ID,Name,Quantity,Desc,Price);
        DBConnection.getInstance().getDBList().set(index,item);



    }

    public void cancbtn(ActionEvent actionEvent){
        id.setText(item.getId());
        name.setText(item.getName());
        quantity.setText(String.valueOf(item.getQuantity()));
        price.setText(String.valueOf(item.getPrice()));
        dis.setText(item.getDescription());

    }

    public void backbtn(ActionEvent actionEvent){
        Homecontroller.upStage.close();

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

    public int getContactIndex(String searchQuery) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId().equals(searchQuery) || item.getName().equalsIgnoreCase(searchQuery)) {
                return i;  // Return Item and its index
            }
        }
        return -1;
    }
}
