package net.ptnkjke.jbeditor.logic.bcel;

import net.ptnkjke.jbeditor.logic.bcel.bytecode.Editor;
import net.ptnkjke.jbeditor.logic.Core;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Утилитарный класс для BCEL
 */
public class BCELCore {
    /**
     * Получить байт-код определённого метода
     */
    public static String getMethodsCode(String classFile, int indexMethod) {
        JavaClass javaClass = null;

        try {
            javaClass = new ClassParser(new ByteArrayInputStream(Core.INSTANCE.getClassMap().get(classFile)), classFile.replace("//", ".")).parse();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        ClassGen classGen = new ClassGen(javaClass);

        Method method = classGen.getMethodAt(indexMethod);

        MethodGen methodGen = new MethodGen(method, classGen.getClassName(), classGen.getConstantPool());

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

        return sb.toString();
    }

    /**
     * Получит файл графика GraphViz
     *
     * @return
     */
    private static String getGraphVizFile(MethodGen methodGen, ClassGen classGen) {
        GraphVizCreator graphVizCreator = new GraphVizCreator(methodGen.getInstructionList(), classGen.getConstantPool());
        File image = graphVizCreator.getImage();

        if (image != null) {
            try {
                return image.toURI().toURL().toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static String getGraphVizFile(String classFile, int methodIndex) {
        JavaClass javaClass = null;

        try {
            javaClass = new ClassParser(new ByteArrayInputStream(Core.INSTANCE.getClassMap().get(classFile)), classFile.replace("//", ".")).parse();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        ClassGen classGen = new ClassGen(javaClass);

        Method method = classGen.getMethodAt(methodIndex);
        MethodGen methodGen = new MethodGen(method, classGen.getClassName(), classGen.getConstantPool());

        return getGraphVizFile(methodGen, classGen);
    }

    /**
     * Update class method
     *
     * @param javaClassName JavaClassName in format net.ptnkjke.net
     * @param methodIndex
     * @param code
     */
    public static void updateClassMethod(String javaClassName, int methodIndex, String code) {
        JBcelByteParser jBcelByteParser = new JBcelByteParser();

        byte[] classBytes = Core.INSTANCE.getClassMap().get(javaClassName);
        JavaClass javaClass = null;
        try {
            javaClass = new ClassParser(
                    new ByteArrayInputStream(classBytes),
                    javaClassName
            ).parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClassGen classGen = new ClassGen(javaClass);

        ConstantPoolGen constantPoolGen = classGen.getConstantPool();

        jBcelByteParser.parse(code, constantPoolGen);

        InstructionList instructionList = jBcelByteParser.getInstructions();

        Method old = classGen.getMethodAt(methodIndex);

        MethodGen mg = new MethodGen(old, classGen.getClassName(), classGen.getConstantPool());
        mg.removeLineNumbers();                // IMPORTANT!!
        mg.removeLocalVariables();             // IMPORTANT!!
        mg.setInstructionList(instructionList);
        classGen.setMethodAt(mg.getMethod(), methodIndex);

        // .class after save
        byte[] bytes = classGen.getJavaClass().getBytes();

        Core.INSTANCE.getClassMap().put(javaClassName, bytes);
    }
}
