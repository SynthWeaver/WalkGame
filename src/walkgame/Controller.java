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
    }

    View view;
}
