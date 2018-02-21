package walkgame.interfaces;

public interface Controllable extends Moveable
{
    void pressW();
    void pressD();
    void pressS();
    void pressA();

    void releaseW();
    void releaseD();
    void releaseS();
    void releaseA();

    void setName(String name);
}
