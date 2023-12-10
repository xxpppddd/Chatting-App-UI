import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(UI.CreateUI(),375, 812);
        scene.getStylesheets().add("UI.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}