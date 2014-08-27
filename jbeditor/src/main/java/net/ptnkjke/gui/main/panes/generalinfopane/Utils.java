package net.ptnkjke.gui.main.panes.generalinfopane;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import net.ptnkjke.gui.main.panes.methodpane.*;
import org.apache.bcel.generic.ClassGen;

import java.io.IOException;

/**
 * Created by dalopatin on 27.08.2014.
 */
public class Utils {

    public static VBox loadView(ClassGen classGen){
        VBox gridPane = null;

        FXMLLoader fxmlLoader = null;

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        try {
            gridPane = (VBox) fxmlLoader.load(Utils.class.getResource("/net/ptnkjke/gui/main/panes/generalinfopane/View.fxml").openStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        gridPane.setMaxWidth(10000);
        gridPane.setMaxHeight(10000);

        Controller controller = fxmlLoader.getController();
        controller.setClassGen(classGen);
        return gridPane;
    }
}
