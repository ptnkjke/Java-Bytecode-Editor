package net.ptnkjke.gui.main.panes.methodpane;


import javafx.fxml.FXML;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import net.ptnkjke.gui.main.model.classtree.Method;
import net.ptnkjke.utils.Editor;
import net.ptnkjke.utils.GraphVizCreator;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.MethodGen;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by Lopatin on 05.07.2014.
 */
public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView imageView;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextArea console;

    private GraphVizCreator graphVizCreator;

    public void setMethod(Method method) {
        ClassGen classGen = method.getClassGen();
        int num = method.getMethodIndex();

        MethodGen methodGen = new MethodGen(classGen.getMethodAt(num),
                classGen.getClassName(),
                classGen.getConstantPool());

        StringBuilder sb = new StringBuilder();
        InstructionHandle handle = methodGen.getInstructionList().getStart();

        if (handle != null) {
            do {
                Editor editor = new Editor();
                editor.visit(handle);

                sb.append(editor.getResult()).append("\n");
                handle = handle.getNext();
            } while (handle != null);
        }

        textArea.setText(sb.toString());

        graphVizCreator = new GraphVizCreator(methodGen.getInstructionList(), classGen.getConstantPool());
        File image = graphVizCreator.getImage();
        Image img = null;

        try {
            do {
                img = new Image(new FileInputStream(image));
            } while (img.getWidth() == 0); // TODO: Очень странное место
            imageView.setImage(img);
            imageView.setFitWidth(img.getWidth());
            imageView.setFitHeight(img.getHeight());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        TextFlow tf;


    }

    public void runConsole() {
        String text = console.getText();

        ScriptEngineManager factory = new ScriptEngineManager();

        ScriptEngine engine = factory.getEngineByName("nashorn");

        try {
            engine.getBindings(ScriptContext.GLOBAL_SCOPE).put("viz", graphVizCreator);
            engine.eval(text);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }


    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public TextArea getConsole() {
        return console;
    }

    public void setConsole(TextArea console) {
        this.console = console;
    }
}
