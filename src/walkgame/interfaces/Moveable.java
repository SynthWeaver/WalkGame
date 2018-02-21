package walkgame.interfaces;

public interface Moveable
{
    void move();
    void setSpeed(double speed);
    double getSpeed();

    void setVelocityX(double velocity);
    void setVelocityY(double velocity);
}
