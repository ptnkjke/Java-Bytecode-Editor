package net.ptnkjke;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import net.ptnkjke.logic.asm.bytecode.BCClassVisitor;
import net.ptnkjke.logic.asm.bytecode.BCMethodVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.FileInputStream;
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

        net.ptnkjke.gui.main.Controller controller = null;

        try {
            root = fxmlLoader.load(getClass().getResource("gui/main/View.fxml").openStream());
            controller = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Java Byte Editor rc1");


        // Вешаем dragAndDrop
        final net.ptnkjke.gui.main.Controller finalController = controller;

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
        // TESTING CASE DELETE IT !!!:
        try {
            ClassReader             classReader = new ClassReader(new FileInputStream("C:\\Main1.class"));
            BCClassVisitor visitor = new BCClassVisitor();
            classReader.accept(visitor, 0);

            for(BCMethodVisitor m : visitor.methods){
                for(Object o : m.getTextCode()){
                    System.out.println(o);
                }
            }

            ClassNode classNode = new ClassNode();
            classReader.accept(classNode, 0);
            for(MethodNode m : classNode.methods){
                System.out.println("signature: " + m.signature + " name " +  m.name + " " + " desc " + m.desc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //

        try {
            launch(args);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
