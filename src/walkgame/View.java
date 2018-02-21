package walkgame;

import gameloop.GameLoop;
import javafx.scene.Group;
import javafx.scene.Scene;
import walkgame.objects.Player;

public class View extends gameloop.View
{
    public static int APP_WIDTH = 300;
    public static int APP_HEIGHT = 300;

    public View()
    {
        group = new Group(player);
        scene = new Scene(group, View.APP_WIDTH, View.APP_HEIGHT);
    }

    public Group group;
    public Scene scene;

    public Player player = new Player(0,0, "Jack");



    @Override
    public void tick()
    {
        player.move();
    }

    @Override
    public void render()
    {
        group = new Group(player);
        scene.setRoot(group);
        //focusCam();
    }

    private void focusCam()
    {
        double imgHeight = player.getImage().getHeight();
        double imgWidth = player.getImage().getWidth();

        double playerCenter = (imgHeight + imgWidth) / 2f;
        double viewCenter =(APP_HEIGHT + APP_WIDTH) /2f;


    }
}