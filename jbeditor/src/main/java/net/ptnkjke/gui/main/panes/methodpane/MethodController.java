package net.ptnkjke.gui.main.panes.methodpane;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import net.ptnkjke.gui.main.model.classtree.Method;
import net.ptnkjke.service.DataActivity;
import net.ptnkjke.utils.Editor;
import net.ptnkjke.utils.GraphVizCreator;
import net.ptnkjke.logic.bcel.JByteParser;
import org.apache.bcel.generic.*;

import java.io.File;
import java.net.MalformedURLException;


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

    private GraphVizCreator graphVizCreator;

    private MethodModel model;

    private ClassGen classGen;
    private Method method;


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

    public void setMethod(Method method) {
        this.method = method;
        classGen = method.getClassGen();
        int num = method.getMethodIndex();

        // Получаем текстовое представление байт-кода с помощью BCEL
        MethodGen methodGen = new MethodGen(classGen.getMethodAt(num),
                classGen.getClassName(),
                classGen.getConstantPool());

        StringBuilder sb = new StringBuilder();
        InstructionHandle handle = methodGen.getInstructionList().getStart();

        if (handle != null) {
            do {
                Editor editor = new Editor();
                try {
                    editor.visit(handle);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                sb.append(editor.getResult()).append("\n");
                handle = handle.getNext();
            } while (handle != null);
        }

        codeBcel.setText(sb.toString());

        // Строим график GraphViz
        graphVizCreator = new GraphVizCreator(methodGen.getInstructionList(), classGen.getConstantPool());
        File image = graphVizCreator.getImage();

        if (image != null) {
            try {
                webview.getEngine().load(image.toURI().toURL().toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public void testSave() {
        JByteParser jByteParser = new JByteParser();
        ConstantPoolGen constantPoolGen = classGen.getConstantPool();

        jByteParser.parse(codeBcel.getText(), constantPoolGen);
        InstructionList instructionList = jByteParser.getInstructions();

        int num = method.getMethodIndex();
        org.apache.bcel.classfile.Method old = classGen.getMethodAt(num);

        MethodGen mg = new MethodGen(old, classGen.getClassName(), classGen.getConstantPool());
        mg.removeLineNumbers();
        mg.removeLocalVariables();
        mg.setInstructionList(instructionList);
        classGen.setMethodAt(mg.getMethod(), num);

        DataActivity.changes.add(classGen);
    }

    public TextArea getCodeBcel() {
        return codeBcel;
    }

    public void setCodeBcel(TextArea codeBcel) {
        this.codeBcel = codeBcel;
    }
}
