package net.ptnkjke.logic.bcel.bytecode;

import org.apache.bcel.classfile.*;

/**
 * Created by Lopatin on 19.07.2014.
 */
public class TextConstantWorker extends ConstanstWorker {
    private String text;
    private ConstantPool cp;

    public TextConstantWorker(ConstantPool cp) {
        this.cp = cp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void visitUtf8(ConstantUtf8 constant) {
        text = "Utf8" + " : " + constant.getBytes();
    }

    @Override
    public void visitInteger(ConstantInteger constant) {
        text = "Integer" + " : " + constant.getBytes();
    }

    @Override
    public void visitFloat(ConstantFloat constant) {
        text = "Float" + " : " + constant.getBytes();
    }

    @Override
    public void visitLong(ConstantLong constant) {
        text = "Long" + " : " + constant.getBytes();
    }

    @Override
    public void visitDouble(ConstantDouble constant) {
        text = "Double" + " : " + constant.getBytes();
    }

    @Override
    public void visitClass(ConstantClass constant) {
        text = "Class" + " : " + constant.getBytes(cp);
    }

    @Override
    public void visitFieldRef(ConstantFieldref constant) {
        text = "FieldRef" + " : " + constant.getClass(cp) + " " + constant.getNameAndTypeIndex();
    }

    @Override
    public void visitString(ConstantString constant) {
        text = "String" + " : " + constant.getConstantValue(cp);
    }

    @Override
    public void visitMethodref(ConstantMethodref constant) {
        text = "MethodRef" + " : " + constant.getClassIndex() + " " + constant.getNameAndTypeIndex();
    }

    @Override
    public void visitInterfaceMethodRef(ConstantInterfaceMethodref constant) {
        text = "InterfaceMethodRef" + " : " + constant.getClassIndex() + " " + constant.getNameAndTypeIndex();
    }

    @Override
    public void visitNameAndType(ConstantNameAndType constant) {
        text = "NameAndType" + " : " + constant.getName(cp) + " " + constant.getSignature(cp);

    }

    @Override
    public void visitMethodHandle(ConstantMethodHandle constant) {
        text = "MethodHandle" + " : " + constant.getReferenceKind() + " " + constant.getReferenceIndex();
    }

    @Override
    public void visitMethodType(ConstantMethodType constant) {
        text = "MethodType" + " : " + constant.getDescriptorIndex();
    }
}
