package net.ptnkjke.gui.main.panes.methodpane;

import net.ptnkjke.gui.main.model.classtree.Method;

/**
 * Представление
 */
public class MethodModel {
    /**
     * Байт-код для BCEL
     */
    private String codeBCEL;
    /**
     * Сведения о BCEL-методе
     */
    private Method methodBCEL;
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


    public String getCodeBCEL() {
        return codeBCEL;
    }

    public void setCodeBCEL(String codeBCEL) {
        this.codeBCEL = codeBCEL;
    }

    public Method getMethodBCEL() {
        return methodBCEL;
    }

    public void setMethodBCEL(Method methodBCEL) {
        this.methodBCEL = methodBCEL;
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
}
