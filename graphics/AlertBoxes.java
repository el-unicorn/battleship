package graphics;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.control.Alert.AlertType;

abstract class AlertBoxes {
    
    private static int n = 0;
    
    public static void choice(Stage primaryStage, String title, String message, String option1, String option2) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label label = new Label();
        label.setText(message);
        Button optionA = new Button(option1);
        optionA.setOnAction((ActionEvent e) -> {
            window.close();
            ScreenPlace.start(primaryStage, 1); // PVP
        });
        
        Button optionB = new Button(option2);
        optionB.setOnAction((ActionEvent e) -> {
            window.close();
            ScreenPlace.start(primaryStage, 2); // PVE
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, optionA, optionB);
        //layout.getChildren().addAll(label, optionB);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
    public static void advice(String title, String message){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
    
    public static String text(String title, String header, String ask) {
        n++;
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(ask);
        
        if(n == 1) {
            return "";
        }
        
        Optional<String> result = dialog.showAndWait();
        
        if(result.isPresent()) {
            return result.get();
        } else {
            return "Player "+(n-1);
        }
    }
}