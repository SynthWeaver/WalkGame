package walkgame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.parentObjects.GameObject;

public class View extends gameloop.View
{
    public static double SCREEN_WIDTH = 300;
    public static double SCREEN_HEIGHT = 300;
    public static double GAME_WIDTH = 400;
    public static double GAME_HEIGHT = 400;

    public View(Stage primaryStage)
    {
        new Floor(player.getX(), player.getY(), new Image("walkgame/res/floor1.png"));
        root = makeRoot();
        scene = new Scene(root, View.SCREEN_WIDTH, View.SCREEN_HEIGHT, Color.BLACK);
        this.primaryStage = primaryStage;
    }

    public Player player = new Player(View.SCREEN_WIDTH / 2f,View.SCREEN_HEIGHT / 2f, "Jack");
    public Group root;
    public Scene scene;
    public Stage primaryStage;



    @Override
    public void tick()
    {
        player.move();
        for (Floor floor : Floor.floorList)
        {
            floor.move();
        }
    }

    @Override
    public void render()
    {
        root = makeRoot();
        scene.setRoot(root);
    }

    private Group makeRoot()
    {
        AnchorPane map = new AnchorPane(Floor.floorList.get(0));
        map.setMinSize(GAME_WIDTH,GAME_HEIGHT);
        return new Group(map, player);
    }
}