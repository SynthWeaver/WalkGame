package walkgame;


import gameloop.GameLoop;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import walkgame.objects.Player;

public class Controller{

    public Controller(View view)
    {
        this.view = view;
        this.gameLoop = new GameLoop(view);
        gameLoop.start();
    }

    View view;
    public GameLoop gameLoop;



}
