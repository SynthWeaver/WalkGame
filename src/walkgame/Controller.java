package walkgame;


import gameloop.GameLoop;
import javafx.fxml.FXML;

public class Controller{

    private GameLoop gameLoop = new GameLoop(this);

    @FXML
    public void initialize() {
        gameLoop.start();
    }

    public void render()
    {

    }
}
