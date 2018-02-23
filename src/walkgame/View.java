package walkgame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.Floor;
import walkgame.objects.Player;

public class View extends gameloop.View
{
    public static double SCREEN_WIDTH = 300;
    public static double SCREEN_HEIGHT = 300;
    public static double GAME_WIDTH = 400;
    public static double GAME_HEIGHT = 400;

    public Controller controller;
    public Player player;

    public Group root;
    public Scene scene;
    public Stage primaryStage;



    public View(Stage primaryStage)
    {
        controller = new Controller(this);
        player = new Player(View.SCREEN_WIDTH / 2f,View.SCREEN_HEIGHT / 2f, "Jack");

        createFloor();
        createRoot();
        createScene();

        this.primaryStage = primaryStage;
    }



    @Override
    public void render()
    {

    }



    private void createFloor()
    {
        new Floor(player.getX(), player.getY(), new Image("walkgame/res/floor1.png"));
        new Floor(Floor.floorList.get(0).getX() + new Image("walkgame/res/floor1.png").getWidth(), player.getY(), new Image("walkgame/res/floor1.png"));
    }

    private void createRoot()
    {
        Pane map = new Pane();
        for (Floor f : Floor.floorList) {
            map.getChildren().add(f);
        }

        map.setMinSize(GAME_WIDTH,GAME_HEIGHT);
        root = new Group(map, player);
    }

    private void createScene()
    {
        scene = new Scene(root, View.SCREEN_WIDTH, View.SCREEN_HEIGHT, Color.BLACK);

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
    }
}