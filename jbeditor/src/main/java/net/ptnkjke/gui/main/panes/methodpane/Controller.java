package net.ptnkjke.gui.main.panes.methodpane;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import net.ptnkjke.gui.main.model.classtree.Method;
import net.ptnkjke.utils.Editor;
import net.ptnkjke.utils.GraphVizCreator;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.MethodGen;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


/**
 * Created by Lopatin on 05.07.2014.
 */
public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private Canvas canvas;
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
                Editor editor =new Editor();
                editor.visit(handle);

                sb.append(editor.getResult()).append("\n");
                handle = handle.getNext();
            } while (handle != null);
        }

        textArea.setText(sb.toString());

        drawInCanvas(methodGen.getInstructionList());
        graphVizCreator = new GraphVizCreator(methodGen.getInstructionList());
    }


    private void drawInCanvas(InstructionList instructionList) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.fillRect(100, 100, 100, 100);
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

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public TextArea getConsole() {
        return console;
    }

    public void setConsole(TextArea console) {
        this.console = console;
    }
}
