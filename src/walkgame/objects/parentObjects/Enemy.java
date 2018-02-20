package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends Character
{
    public Enemy(float x, float y, Image image, String name, int health, float speed)
    {
        super(x, y, image, name, health, speed);
    }
}
