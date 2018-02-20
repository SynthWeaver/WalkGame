package walkgame.interfaces;

public interface Moveable
{
    void setX(float x);
    void setY(float y);
    void setSpeed(float speed);

    void move();

    void setGoNorth(Boolean b);
    void setGoEast(Boolean b);
    void setGoSouth(Boolean b);
    void setGoWest(Boolean b);
}
