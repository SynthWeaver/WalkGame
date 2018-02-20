package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameObject extends ImageView
{
    public final static List<Integer> ID_LIST = new ArrayList();

    public GameObject(double x, double y, Image image)
    {
        super(image);
        createID();

        super.setX(x);
        super.setY(y);

        this.name = "NULLNAME";
        this.health = 0;
        this.speed = 0;
    }

    public GameObject(double x, double y, Image image, String name, int health, float speed)
    {
        this(x, y, image);

        this.name = name;
        this.health = health;
        this.speed = speed;
    }


    private int id;
    protected String name;
    int health;
    float speed;

    boolean goNorth, goSouth, goEast, goWest;



    public void setSprite(Image image)
    {
        super.setImage(image);
    }



    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public float getSpeed()
    {
        return speed;
    }



    private void createID()
    {
        id = ID_LIST.size();
        ID_LIST.add(id);
    }
}
