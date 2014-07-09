package net.ptnkjke.gui.main.panes.constanpanes.table;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import net.ptnkjke.gui.main.model.classtree.Method;
import net.ptnkjke.gui.main.panes.methodpane.*;
import org.apache.bcel.generic.ConstantPoolGen;

import java.io.IOException;

/**
 * Created by Lopatin on 09.07.2014.
 */
public class Static {
    public static Pane loadView(ConstantPoolGen cpg) {

        Pane pane = null;

        FXMLLoader fxmlLoader = null;

        fxmlLoader = new FXMLLoader();
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        try {
            pane = (Pane) fxmlLoader.load(Utils.class.getResource("/net/ptnkjke/gui/main/panes/constanpanes/table/View.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.setMaxWidth(10000);
        pane.setMaxHeight(10000);

        net.ptnkjke.gui.main.panes.constanpanes.table.Controller controller = fxmlLoader.getController();
        controller.setConstantPool(cpg);
        return pane;
    }
}
