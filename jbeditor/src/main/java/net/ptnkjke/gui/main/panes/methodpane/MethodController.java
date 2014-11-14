package net.ptnkjke.gui.main.panes.methodpane;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import net.ptnkjke.logic.bcel.BCELCore;


/**
 * Created by Lopatin on 05.07.2014.
 */
public class MethodController {
    // code[bcel]
    @FXML
    private TextArea codeBcel;
    @FXML
    private TextArea codeAsm;
    @FXML
    private WebView webview;
    
    private MethodModel model;


    public void setModel(MethodModel model) {
        this.model = model;

        if (model.getGraphPath() != null) {
            webview.getEngine().load(model.getGraphPath());
        }
        if (model.getCodeBCEL() != null) {
            codeBcel.setText(model.getCodeBCEL());
        }
        if (model.getCodeASM() != null) {
            codeAsm.setText(model.getCodeASM());
        }
    }

    public void acceptBCELChange() {
        BCELCore.updateClassMethod(model.getClassName(), model.getMethodIndex(), codeBcel.getText());
    }

    public void acceptASMChange() {

    }

    public TextArea getCodeBcel() {
        return codeBcel;
    }

    public void setCodeBcel(TextArea codeBcel) {
        this.codeBcel = codeBcel;
    }
}
