package walkgame;

import gameloop.GameLoop;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import walkgame.objects.Player;

public class Main extends Application {

    private Stage primaryStage;
    private Scene scene;
    private View view = new View(this);
    private Controller controller = new Controller(view);

    @Override
    public void start(Stage stage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 300));*/

        primaryStage = stage;
        loadStage("WalkGame");
    }

    private void loadScene()
    {
        scene = new Scene(view.group, 300, 300);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case  W:
                    view.player.setGoNorth(true);
                    GameLoop.logicUpdate = true;
                    break;
                case D:
                    view.player.setGoEast(true);
                    GameLoop.logicUpdate = true;
                    break;
                case S:
                    view.player.setGoSouth(true);
                    GameLoop.logicUpdate = true;
                    break;
                case A:
                    view.player.setGoWest(true);
                    GameLoop.logicUpdate = true;
                    break;
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
    }

    public void loadStage(String name)
    {
        primaryStage.setTitle(name);
        loadScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
