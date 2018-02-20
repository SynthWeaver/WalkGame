package walkgame.objects;

import javafx.scene.image.Image;
import walkgame.interfaces.Controllable;
import walkgame.objects.parentObjects.Character;

public class Player extends Character implements Controllable
{
    private static final int PLAYER_HEALTH = 100;
    private static final int PLAYER_SPEED = 2;

    public Player(double x, double y, Image image, String name, int health, float speed)
    {
        super(x, y, image, name, health, speed);
    }

    public Player(double x, double y, Image image, String name)
    {
        this(x, y, image, name, PLAYER_HEALTH, PLAYER_SPEED);
    }

    public Player(double x, double y, String name)
    {
        this(x, y, new Image("walkgame/res/playerSouth.jpg"), name);
    }


    @Override
    public void setName(String name)
    {
        super.name = name;
    }
}
