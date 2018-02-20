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
    public GameLoop gameLoop = new GameLoop(view);

    @Override
    public void start(Stage stage){
        primaryStage = stage;
        gameLoop.start();
        loadStage("WalkGame");
        primaryStage.show();
    }

    private void loadScene()
    {
        scene = new Scene(view.group, 300, 300);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case  W:
                    view.player.pressW();
                    GameLoop.logicUpdate = true;
                    break;
                case D:
                    view.player.pressD();
                    GameLoop.logicUpdate = true;
                    break;
                case S:
                    view.player.pressS();
                    GameLoop.logicUpdate = true;
                    break;
                case A:
                    view.player.pressA();
                    GameLoop.logicUpdate = true;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case  W: view.player.releaseW(); break;
                case D: view.player.releaseD(); break;
                case S: view.player.releaseS(); break;
                case A: view.player.releaseA(); break;
            }
        });
    }

    public void loadStage(String name)
    {
        primaryStage.setTitle(name);
        loadScene();
        primaryStage.setScene(scene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
