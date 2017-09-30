package net.ptnkjke.jbeditor.gui.main.model.classtree;

/**
 * Created by Lopatin on 03.07.2014.
 */
public class Constant extends Info {
    private org.apache.bcel.classfile.Constant constant;

    public Constant(String title) {
        super(title);
    }

    public org.apache.bcel.classfile.Constant getConstant() {
        return constant;
    }

    public void setConstant(org.apache.bcel.classfile.Constant constant) {
        this.constant = constant;
    }
}
