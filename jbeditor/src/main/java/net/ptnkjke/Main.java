package net.ptnkjke;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Считываем параметры по умолчанию
        Configutation.read();

        //
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("gui/main/View.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("0.01");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();

    }


    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
