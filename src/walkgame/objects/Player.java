package walkgame.objects;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import walkgame.View;
import walkgame.interfaces.*;
import walkgame.objects.microObjects.Coordinate;
import walkgame.objects.parentObjects.Character;

public class Player extends Character implements Controllable, Nameable {

    private static final int PLAYER_HEALTH = 100;
    private static final double PLAYER_SPEED = 0;

    public Player(double centerX, double centerY, Image image, String name)
    {
        super(centerX - (image.getWidth() / 2f), centerY - (image.getWidth() / 2f), image, PLAYER_HEALTH, PLAYER_SPEED);
        this.name = name;
    }

    public Player(Coordinate center, Image image, String name)
    {
        super(center.getX() - (image.getWidth() / 2f), center.getY() - (image.getWidth() / 2f), image, PLAYER_HEALTH, PLAYER_SPEED);
        this.name = name;
    }

    public Player(double centerX, double centerY, String name)
    {
        this(centerX , centerY, new Image("walkgame/res/playerSouth.jpg"), name);
    }

    public Player(Coordinate center, String name)
    {
        this(center, new Image("walkgame/res/playerSouth.jpg"), name);
    }

    private String name;


    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void pressButton(KeyCode c) {
        switch (c){
            case W:
                goNorth = true;
                goSouth = false;
                break;
            case D:
                goEast = true;
                goWest = false;
                break;
            case S:
                goSouth = true;
                goNorth = false;
                break;
            case A:
                goWest = true;
                goEast = false;
                break;
        }
    }

    @Override
    public void releaseButton(KeyCode c) {
        switch (c){
            case W: goNorth = false; break;
            case D: goEast = false; break;
            case S: goSouth = false; break;
            case A: goWest = false; break;
        }
    }
}
