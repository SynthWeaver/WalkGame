package walkgame.objects.parentObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends Character
{
    public Enemy(double x, double y, Image image, String name, int health, double speed)
    {
        super(x, y, image, name, health, speed);
    }
}
