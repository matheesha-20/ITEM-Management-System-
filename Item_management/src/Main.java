import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(
                new Scene(
                        FXMLLoader.load(
                                getClass().getResource("view/Home.fxml")


                        )
                )
        );
        stage.setTitle("Home");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/market.png")));
        stage.show();
    }
}