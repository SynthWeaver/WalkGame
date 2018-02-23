package walkgame;

import gameloop.GameLoop;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.Player;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        View view = new View(primaryStage);
        Controller controller = new Controller(view);
        view.scene = createScene(controller);

        new GameLoop(controller).start();

        primaryStage.setScene(view.scene);

        primaryStage.setTitle("WalkGame");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Scene createScene(Controller controller)
    {
        Group root = controller.view.root;
        Scene scene = new Scene(root, View.SCREEN_WIDTH, View.SCREEN_HEIGHT, Color.BLACK);

        scene.setOnKeyPressed(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                controller.pressButton(k);
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                controller.releaseButton(k);
            }
        });

        return scene;
    }
}
