package graphics;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
    
    public static void main(String[] args) {

        launch(args);
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        AlertBoxes.choice(primaryStage, "GameMode", "Escolha o modo de jogo: ","PVP", "PVE");
    }

}
