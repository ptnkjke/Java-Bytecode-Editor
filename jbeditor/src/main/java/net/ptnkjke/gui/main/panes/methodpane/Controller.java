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
import net.ptnkjke.utils.JByteParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.*;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;


/**
 * Created by Lopatin on 05.07.2014.
 */
public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView imageView;

    private GraphVizCreator graphVizCreator;

    private ClassGen classGen;
    private Method method;

    public void setMethod(Method method) {
        this.method = method;
        classGen = method.getClassGen();
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
                FileInputStream fileInputStream = new FileInputStream(image);
                img = new Image(new FileInputStream(image));
                fileInputStream.close();
            } while (img.getWidth() == 0); // TODO: Очень странное место
            imageView.setImage(img);
            imageView.setFitWidth(img.getWidth());
            imageView.setFitHeight(img.getHeight());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextFlow tf;


    }

    public void testSave() {
        JByteParser jByteParser = new JByteParser();
        ConstantPoolGen constantPoolGen = classGen.getConstantPool();

        jByteParser.parse(textArea.getText(), constantPoolGen);
        InstructionList instructionList = jByteParser.getInstructions();

        int num = method.getMethodIndex();
        org.apache.bcel.classfile.Method old = classGen.getMethodAt(num);

        MethodGen mg = new MethodGen(old, classGen.getClassName(), classGen.getConstantPool());
        mg.setInstructionList(instructionList);
        classGen.setMethodAt(mg.getMethod(), num);


        File oldText = new File("temp" + File.separator + "old.text");
        File newText = new File("temp" + File.separator + "new.text");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(oldText));
            writer.write(textArea.getText());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        InstructionHandle handle = mg.getInstructionList().getStart();

        if (handle != null) {
            do {
                Editor editor = new Editor();
                editor.visit(handle);

                sb.append(editor.getResult()).append("\n");
                handle = handle.getNext();
            } while (handle != null);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newText));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }
}
