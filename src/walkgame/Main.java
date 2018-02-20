package walkgame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import walkgame.objects.Player;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 300));*/

        View view = new View();
        Controller controller = new Controller(view);

        Scene scene = new Scene(view.group, 300, 300);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:view.player.setGoNorth(true); break;
                case D: view.player.setGoEast(true); break;
                case S: view.player.setGoSouth(true); break;
                case A: view.player.setGoWest(true); break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:view.player.setGoNorth(false); break;
                case D: view.player.setGoEast(false); break;
                case S: view.player.setGoSouth(false); break;
                case A: view.player.setGoWest(false); break;
            }
        });

        primaryStage.setTitle("WalkGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
