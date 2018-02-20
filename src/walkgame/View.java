package walkgame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import walkgame.objects.Player;

public class View
{
    public View(Main mainApp)
    {
        this.mainApp = mainApp;
    }

    Main mainApp;

    Player player = new Player(0,0, "Jack");
    Group group = new Group(player);



    public void tick()
    {
        player.move();
    }

    public void render()
    {
        group = new Group(player);
        mainApp.loadStage( "WalkGame");
    }
}
