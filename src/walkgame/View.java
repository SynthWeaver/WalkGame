package walkgame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import walkgame.objects.Player;

public class View
{
    public View()
    {

    }

    Player player = new Player(0,0, new Image("walkgame/res/playerSouth.jpg"), "Jack", 100, 5);
    Group group = new Group(player);


    public void render()
    {

    }
}
