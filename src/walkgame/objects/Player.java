package walkgame.objects;

import javafx.scene.image.Image;
import walkgame.interfaces.Controllable;
import walkgame.objects.parentObjects.Character;

public class Player extends Character implements Controllable
{
    private static final int PLAYER_HEALTH = 100;
    private static final double PLAYER_SPEED = 1.5;

    public Player(double x, double y, Image image, String name, int health, double speed)
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

    @Override
    public void pressW() {
        setVelocityY(0 - getSpeed());
        goNorth = true;
    }

    @Override
    public void pressD() {
        setVelocityX(getSpeed());
        goEast = true;
    }

    @Override
    public void pressS() {
        setVelocityY(getSpeed());
        goSouth = true;
    }

    @Override
    public void pressA() {
        setVelocityX(0 - getSpeed());
        goWest = true;
    }

    @Override
    public void releaseW() {
        goNorth = false;
    }

    @Override
    public void releaseD() {
        goEast = false;
    }

    @Override
    public void releaseS() {
        goSouth = false;
    }

    @Override
    public void releaseA() {
        goWest = false;
    }
}
