package walkgame;


import gameloop.GameLoop;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import walkgame.interfaces.Controllable;
import walkgame.objects.Floor;
import walkgame.objects.Player;

public class Controller{

    public Controller(View view) {
        this.view = view;
        setKeyEvents();
    }

    View view;

    private void setKeyEvents()
    {
        Scene scene = view.scene;
        Player player = view.player;

        scene.setOnKeyPressed(event -> {
            KeyCode c = event.getCode();
            if(c == KeyCode.W || c == KeyCode.D || c == KeyCode.S || c == KeyCode.A)
            {
                GameLoop.logicUpdate = true;
                player.pressButton(c);
                for(Floor f : Floor.floorList)
                {
                    f.pressButton(c);
                }
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode c = event.getCode();
            if(c == KeyCode.W || c == KeyCode.D || c == KeyCode.S || c == KeyCode.A)
            {
                player.releaseButton(c);
                for(Floor f : Floor.floorList)
                {
                    f.releaseButton(c);
                }
            }
        });
    }
}
