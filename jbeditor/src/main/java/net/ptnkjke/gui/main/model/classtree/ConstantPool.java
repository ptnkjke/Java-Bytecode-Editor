package net.ptnkjke.gui.main.model.classtree;

import org.apache.bcel.generic.ClassGen;

/**
 * Created by Lopatin on 03.07.2014.
 */
public class ConstantPool extends Info {
    private ClassGen classGen;

    public ConstantPool(String title) {
        super(title);
    }

    public ClassGen getClassGen() {
        return classGen;
    }

    public void setClassGen(ClassGen classGen) {
        this.classGen = classGen;
    }
}
