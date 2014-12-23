package net.ptnkjke.jbeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import net.ptnkjke.jbeditor.gui.main.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Считываем параметры по умолчанию
        Configutation.read();

        //
        Parent root = null;
        FXMLLoader fxmlLoader = null;
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        Controller controller = null;

        try {
            root = fxmlLoader.load(getClass().getResource("gui/main/View.fxml").openStream());
            controller = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Java Byte Editor rc1");


        // Вешаем dragAndDrop
        final Controller finalController = controller;

        root.setOnDragOver(event -> {
            event.consume();
            event.acceptTransferModes(TransferMode.ANY);
        });

        root.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();

            if (db.hasFiles()) {
                List<File> files = db.getFiles();
                File file = files.get(0);

                if (!file.isFile()) {
                    return;
                }

                finalController.openFile(file);

                event.consume();
            }
        });
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
