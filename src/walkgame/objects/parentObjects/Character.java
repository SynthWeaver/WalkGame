package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;

public class Character extends GameObject implements Moveable, Destructible
{
    public Character(float x, float y, Image image, String name, int health, float speed)
    {
        super(x, y, image, name, health, speed);
    }

    @Override
    public void setX(float x)
    {
        super.setX(x);
    }

    @Override
    public void setY(float y)
    {
        super.setY(y);
    }

    @Override
    public void setHealth(int health)
    {
        super.health = health;
    }

    @Override
    public void setSpeed(float speed)
    {
        super.speed = speed;
    }

    @Override
    public void move()
    {
        double x = getX();
        double y = getY();
        if(goNorth)
        {
            setY(y - speed);
        }
        if(goEast)
        {
            setX(x + speed);
        }
        if(goSouth)
        {
            setY(y + speed);
        }
        if(goWest)
        {
            setX(x - speed);
        }
    }

    @Override
    public void setGoNorth(Boolean b)
    {
        goNorth = b;
    }

    @Override
    public void setGoEast(Boolean b)
    {
        goEast = b;
    }

    @Override
    public void setGoSouth(Boolean b)
    {
        goSouth = b;
    }

    @Override
    public void setGoWest(Boolean b)
    {
        goWest = b;
    }
}
