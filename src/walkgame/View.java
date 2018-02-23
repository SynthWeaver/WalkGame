package walkgame;

import gameloop.GameLoop;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
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



    public Player player = new Player(View.SCREEN_WIDTH / 2f,View.SCREEN_HEIGHT / 2f, "Jack");
    public Group root;
    public Scene scene;
    public Stage primaryStage;



    public View(Stage primaryStage)
    {
        new Floor(player.getX(), player.getY(), new Image("walkgame/res/floor1.png"));
        this.root = createRoot();
        this.primaryStage = primaryStage;
    }



    @Override
    public void render()
    {
        root = createRoot();
        scene.setRoot(root);
    }




    private Group createRoot()
    {
        AnchorPane map = new AnchorPane(Floor.floorList.get(0));
        map.setMinSize(GAME_WIDTH,GAME_HEIGHT);
        return new Group(map, player);
    }
}