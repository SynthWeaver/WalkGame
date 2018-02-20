package walkgame.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import walkgame.interfaces.Controllable;
import walkgame.objects.parentObjects.Character;

public class Player extends Character implements Controllable
{
    public Player(float x, float y, Image image, String name, int health, float speed)
    {
        super(x, y, image, name, health, speed);
    }

    @Override
    public void setName(String name)
    {
        super.name = name;
    }
}
