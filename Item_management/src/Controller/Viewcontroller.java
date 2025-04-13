package Controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

public class Viewcontroller {

    public TableColumn id;
    public TableColumn name;
    public TableColumn qa;
    public TableColumn dis;
    public TableColumn price;
    public TableView table;



    public void reloadbtn(ActionEvent actionEvent) {
            loaditem();
    }

    public  void loaditem(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        qa.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dis.setCellValueFactory(new PropertyValueFactory<>("description"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<Item> customerObservableList = FXCollections.observableArrayList();

        DBConnection.getInstance().getDBList().forEach(item -> {
            customerObservableList.add(item);
        });

        table.setItems(customerObservableList);
    }

    public void bthbtn(ActionEvent actionEvent) {
        Homecontroller.viewStage.close();
    }
}
