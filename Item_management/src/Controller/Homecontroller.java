package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Homecontroller {

    Viewcontroller viewcontroller;

    public static Stage addStage = new Stage();
    public static Stage searStage = new Stage();
    public static Stage upStage = new Stage();
    public static Stage viewStage = new Stage();
    public static Stage delStage = new Stage();

    private ArrayList<Stage> openWindows = new ArrayList<>();

    public void addbtn(ActionEvent actionEvent) throws IOException {
        // Get the current stage (main window)
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Load the new FXML for the "Add" window
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Add.fxml")));

        // Create a new stage for the "Add" window

        addStage.setScene(new Scene(root));
        addStage.setTitle("Add Item");  // Optional: Set a title for the new window
        addStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/add.png"))));
        // Add a close event listener to the main window (currentStage)
        currentStage.setOnCloseRequest(event -> {
            // Close the "Add" window if it's open
            closeAllWindows();
        });

        openWindows.add(addStage);
        addStage.show();

        // Optionally, hide the current stage if you don't want it visible
        // currentStage.hide();
    }

    public void searbtn(ActionEvent actionEvent) throws IOException {
        // Get the current stage (main window)
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Load the new FXML for the "Add" window
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Search.fxml")));

        // Create a new stage for the "Add" window

        searStage.setScene(new Scene(root));
        searStage.setTitle("Search Item");  // Optional: Set a title for the new window
        searStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/search.png"))));

        // Add a close event listener to the main window (currentStage)
        currentStage.setOnCloseRequest(event -> {
            // Close the "Add" window if it's open
            closeAllWindows();
        });

        openWindows.add(searStage);
        searStage.show();

    }

    public void upbtn(ActionEvent actionEvent) throws  IOException {
        // Get the current stage (main window)
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Load the new FXML for the "Add" window
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Update.fxml")));

        // Create a new stage for the "Add" window

        upStage.setScene(new Scene(root));
        upStage.setTitle("Update Item");  // Optional: Set a title for the new window
        upStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/update.png"))));

        // Add a close event listener to the main window (currentStage)
        currentStage.setOnCloseRequest(event -> {
            // Close the "Add" window if it's open
            closeAllWindows();
        });

        openWindows.add(upStage);
        upStage.show();

    }

    public void delbtn(ActionEvent actionEvent) throws  IOException {
        // Get the current stage (main window)
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Load the new FXML for the "Add" window
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Delete.fxml")));

        // Create a new stage for the "Add" window

        delStage.setScene(new Scene(root));
        delStage.setTitle("Delete Item");  // Optional: Set a title for the new window
        delStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/delete.png"))));

        // Add a close event listener to the main window (currentStage)
        currentStage.setOnCloseRequest(event -> {
            // Close the "Add" window if it's open
            closeAllWindows();
        });

        openWindows.add(delStage);
        delStage.show();
    }

    public void viewbtn(ActionEvent actionEvent) throws IOException {
        // Get the current stage (main window)
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Load the new FXML for the "Add" window
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/View.fxml")));

        // Create a new stage for the "Add" window

        viewStage.setScene(new Scene(root));
        viewStage.setTitle("View Item");  // Optional: Set a title for the new window
        viewStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/view.png"))));

        // Add a close event listener to the main window (currentStage)
        currentStage.setOnCloseRequest(event -> {
            // Close the "Add" window if it's open
            closeAllWindows();
        });

        openWindows.add(viewStage);
        viewStage.show();
    }

    private void closeAllWindows() {
        for (Stage stage : openWindows) {
            stage.close();
        }
    }
}
