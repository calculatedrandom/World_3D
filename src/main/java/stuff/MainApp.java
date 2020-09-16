package stuff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/scene.fxml");
        loader.setLocation(xmlUrl);
        Controller controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toString());

        stage.setTitle("TimeUseFx");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", FirstPreloader.class.getCanonicalName());
        Application.launch(MainApp.class, args);
//        launch(args);
    }
}

