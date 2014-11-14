package net.ptnkjke.gui.main.panes.methodpane;

import net.ptnkjke.gui.main.model.classtree.Method;
import net.ptnkjke.logic.bcel.BCELCore;

/**
 * Представление
 */
public class MethodModel {
    /**
     * Байт-код для BCEL
     */
    private String codeBCEL;
    /**
     * Байт-код для ASM
     */
    private String codeASM;
    /**
     * Путь до граф-файла
     */
    private String graphPath;
    /**
     * Порядковый нмоер метода
     */
    private int methodIndex;
    /**
     * ClassName in format: net.ptnkjke.class
     */
    private String className;


    public MethodModel(String className, int methodIndex) {
        this.className = className;
        this.methodIndex = methodIndex;

        this.codeBCEL = BCELCore.getMethodsCode(className, methodIndex);
        this.graphPath = BCELCore.getGraphVizFile(className, methodIndex);
    }

    public String getCodeBCEL() {
        return codeBCEL;
    }

    public void setCodeBCEL(String codeBCEL) {
        this.codeBCEL = codeBCEL;
    }

    public String getCodeASM() {
        return codeASM;
    }

    public void setCodeASM(String codeASM) {
        this.codeASM = codeASM;
    }

    public String getGraphPath() {
        return graphPath;
    }

    public void setGraphPath(String graphPath) {
        this.graphPath = graphPath;
    }

    public int getMethodIndex() {
        return methodIndex;
    }

    public void setMethodIndex(int methodIndex) {
        this.methodIndex = methodIndex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
