package Controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;

public class Addcontroller {
    public TextField id;
    public TextField name;
    public TextField quantity;
    public TextField price;
    public TextField dis;

    public void addbtnaction(ActionEvent actionEvent) {
        String ID = id.getText();
        String Name = name.getText();
        Integer Quantity = Integer.valueOf(quantity.getText());
        String Description = dis.getText();
        Double  Price = Double.valueOf(price.getText());

        Item item = new Item(ID,Name,Quantity,Description,Price);
        DBConnection.getInstance().getDBList().add(item);

        id.setText("");
        name.setText("");
        quantity.setText("");
        price.setText("");
        dis.setText("");

        new Alert(Alert.AlertType.CONFIRMATION,"ADDED SUCCESSFULLY").show();

        Homecontroller.addStage.close();
    }

    public void cancbtn(ActionEvent actionEvent) {
        id.setText("");
        name.setText("");
        quantity.setText("");
        price.setText("");
        dis.setText("");
    }

    public void backbtn(ActionEvent actionEvent) {
        Homecontroller.addStage.close();
    }
}
