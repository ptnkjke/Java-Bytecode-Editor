package net.ptnkjke.jbeditor.gui.main.panes.generalinfopane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.apache.bcel.generic.ClassGen;

/**
 * Created by dalopatin on 27.08.2014.
 */
public class Controller {
    @FXML
    private Label l_className;
    @FXML
    private Label l_superClassName;
    @FXML
    private Label l_fileName;
    @FXML
    private Label l_major;
    @FXML
    private Label l_minor;

    private ClassGen classGen;

    public void setClassGen(ClassGen classGen) {
        this.classGen = classGen;

        this.l_className.setText(classGen.getClassName());
        this.l_superClassName.setText(classGen.getSuperclassName());
        this.l_fileName.setText(classGen.getFileName());
        this.l_major.setText(Integer.toString(classGen.getMajor()));
        this.l_minor.setText(Integer.toString(classGen.getMinor()));
    }
}
