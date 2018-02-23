package walkgame;


import gameloop.GameLoop;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.objects.Floor;
import walkgame.objects.Player;

public class Controller extends gameloop.Controller{

    View view;



    public Controller(View view) {
        this.view = view;
    }



    public void pressButton(KeyCode k)
    {
        GameLoop.logicUpdate = true;
        view.player.pressButton(k);
        for(Floor f : Floor.floorList)
        {
            f.pressButton(k);
        }
    }

    public void releaseButton(KeyCode k)
    {
        view.player.releaseButton(k);
        for(Floor f : Floor.floorList)
        {
            f.releaseButton(k);
        }
    }



    @Override
    public void tick()
    {
        view.player.move();
        for (Floor floor : Floor.floorList)
        {
            floor.move();
        }
    }

    @Override
    public void render()
    {
        view.render();
    }
}
