package walkgame;


import gameloop.GameLoop;
import javafx.scene.Group;
import javafx.scene.Scene;
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

        scene.setOnKeyPressed(event -> {//todo: naar controller
            switch (event.getCode()) {
                case  W:
                    player.pressW();
                    GameLoop.logicUpdate = true;
                    break;
                case D:
                    player.pressD();
                    GameLoop.logicUpdate = true;
                    break;
                case S:
                    player.pressS();
                    GameLoop.logicUpdate = true;
                    break;
                case A:
                    player.pressA();
                    GameLoop.logicUpdate = true;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case  W: player.releaseW(); break;
                case D: player.releaseD(); break;
                case S: player.releaseS(); break;
                case A: player.releaseA(); break;
            }
        });
    }
}
