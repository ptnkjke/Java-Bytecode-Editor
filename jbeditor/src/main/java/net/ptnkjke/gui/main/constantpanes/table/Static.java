package net.ptnkjke.gui.main.constantpanes.table;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.TabPane;
import net.ptnkjke.gui.main.panes.methodpane.*;
import org.apache.bcel.generic.ClassGen;

import java.io.IOException;

public class Static {
    public static TabPane loadView(ClassGen cg) {

        TabPane pane = null;

        FXMLLoader fxmlLoader = null;

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        try {
            pane = (TabPane) fxmlLoader.load(MethodUtils.class.getResource("/net/ptnkjke/gui/main/constantpanes/table/View.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.setMaxWidth(10000);
        pane.setMaxHeight(10000);

        net.ptnkjke.gui.main.constantpanes.table.Controller controller = fxmlLoader.getController();
        controller.setClassGen(cg);
        return pane;
    }
}
