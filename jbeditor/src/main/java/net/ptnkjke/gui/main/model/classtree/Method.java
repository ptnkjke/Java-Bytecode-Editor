package net.ptnkjke.gui.main.model.classtree;

import org.apache.bcel.generic.ClassGen;

/**
 * Created by Lopatin on 03.07.2014.
 */
public class Method extends Info {
    // Класс, к которому относится данный метод
    private ClassGen classGen;
    // Индекс метода
    private int methodIndex;

    public Method(String title) {
        super(title);
    }

    public ClassGen getClassGen() {
        return classGen;
    }

    public void setClassGen(ClassGen classGen) {
        this.classGen = classGen;
    }

    public int getMethodIndex() {
        return methodIndex;
    }

    public void setMethodIndex(int methodIndex) {
        this.methodIndex = methodIndex;
    }
}
