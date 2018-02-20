package walkgame.interfaces;

public interface Moveable
{
    void pressW();
    void pressD();
    void pressS();
    void pressA();

    void releaseW();
    void releaseD();
    void releaseS();
    void releaseA();

    void move();
    void setSpeed(double speed);
}
