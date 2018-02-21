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
    private boolean goNorth, goSouth, goEast, goWest;



    @Override
    public void setHealth(int health)
    {
        this.health = health;
    }

    @Override
    public void move()
    {
        if(!goNorth && !goEast && !goSouth && !goWest)
        {
            stopVelocity();
        }
        else{
            double x = getX();
            double y = getY();

            super.setX(x + velocityX);
            super.setY(y + velocityY);
        }
    }



    private void setVelocityX(double velocity) {
        this.velocityX = velocity;
    }

    private void setVelocityY(double velocity) {
        this.velocityY = velocity;
    }

    private void stopVelocity()
    {
        velocityX = 0;
        velocityY = 0;
    }



    @Override
    public void pressW() {
        setVelocityY(0 - speed);
        goNorth = true;
    }

    @Override
    public void pressD() {
        setVelocityX(speed);
        goEast = true;
    }

    @Override
    public void pressS() {
        setVelocityY(speed);
        goSouth = true;
    }

    @Override
    public void pressA() {
        setVelocityX(0 - speed);
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

    @Override
    public void setSpeed(double speed)
    {
        super.speed = speed;
    }
}
