package net.ptnkjke.gui.main.panes.methodpane;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.GridPane;
import net.ptnkjke.gui.main.model.classtree.Method;

import java.io.IOException;

/**
 * Created by Lopatin on 05.07.2014.
 */
public class Utils {

    public static GridPane loadView(Method method) {
        GridPane gridPane = null;

        FXMLLoader fxmlLoader = null;

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        try {
            gridPane = (GridPane) fxmlLoader.load(Utils.class.getResource("/net/ptnkjke/gui/main/panes/methodpane/View.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        gridPane.setMaxWidth(10000);
        gridPane.setMaxHeight(10000);

        Controller controller = fxmlLoader.getController();
        controller.setMethod(method);
        return gridPane;
    }
}
