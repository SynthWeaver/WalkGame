package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import walkgame.interfaces.Destructible;
import walkgame.interfaces.Moveable;

public class Character extends GameObject implements Moveable, Destructible
{
    public Character(double x, double y, Image image, String name, int health, double speed)
    {
        super(x, y, image, name, health, speed);
    }



    private double velocityX = 0;
    private double velocityY = 0;
    protected boolean goNorth, goSouth, goEast, goWest;


    public double getSpeed()
    {
        return super.speed;
    }


    public void setVelocityX(double velocity) {
        this.velocityX = velocity;
    }

    public void setVelocityY(double velocity) {
        this.velocityY = velocity;
    }

    @Override
    public void setHealth(int health)
    {
        this.health = health;
    }

    @Override
    public void move()
    {
        if(!goNorth && !goSouth)
        {
            velocityY = 0;
        }
        if(!goEast && !goWest)
        {
            velocityX = 0;
        }

        double x = getX();
        double y = getY();

        super.setX(x + velocityX);
        super.setY(y + velocityY);

    }

    @Override
    public void setSpeed(double speed)
    {
        super.speed = speed;
    }
}
