package net.ptnkjke.jbeditor.utils;

import org.apache.bcel.Const;
import org.apache.bcel.classfile.*;

public abstract class ConstanstWorker {

    public void visit(Constant constant) throws Exception {
        switch (constant.getTag()) {
            case Const.CONSTANT_Utf8:
                visitUtf8((ConstantUtf8) constant);
                break;
            case Const.CONSTANT_Integer:
                visitInteger((ConstantInteger) constant);
                break;
            case Const.CONSTANT_Float:
                visitFloat((ConstantFloat) constant);
                break;
            case Const.CONSTANT_Long:
                visitLong((ConstantLong) constant);
                break;
            case Const.CONSTANT_Double:
                visitDouble((ConstantDouble) constant);
                break;
            case Const.CONSTANT_Class:
                visitClass((ConstantClass) constant);
                break;
            case Const.CONSTANT_Fieldref:
                visitFieldRef((ConstantFieldref) constant);
                break;
            case Const.CONSTANT_String:
                visitString((ConstantString) constant);
                break;
            case Const.CONSTANT_Methodref:
                visitMethodref((ConstantMethodref) constant);
                break;
            case Const.CONSTANT_InterfaceMethodref:
                visitInterfaceMethodRef((ConstantInterfaceMethodref) constant);
                break;
            case Const.CONSTANT_NameAndType:
                visitNameAndType((ConstantNameAndType) constant);
                break;
            case Const.CONSTANT_MethodHandle:
                visitMethodHandle((ConstantMethodHandle) constant);
                break;
            case Const.CONSTANT_MethodType:
                visitMethodType((ConstantMethodType) constant);
                break;
            default:
                throw new Exception("");
        }
    }

    public abstract void visitUtf8(ConstantUtf8 constant);

    public abstract void visitInteger(ConstantInteger constant);

    public abstract void visitFloat(ConstantFloat constant);

    public abstract void visitLong(ConstantLong constant);

    public abstract void visitDouble(ConstantDouble constant);

    public abstract void visitClass(ConstantClass constant);

    public abstract void visitFieldRef(ConstantFieldref constant);

    public abstract void visitString(ConstantString constant);

    public abstract void visitMethodref(ConstantMethodref constant);

    public abstract void visitInterfaceMethodRef(ConstantInterfaceMethodref constant);

    public abstract void visitNameAndType(ConstantNameAndType constant);

    public abstract void visitMethodHandle(ConstantMethodHandle constant);

    public abstract void visitMethodType(ConstantMethodType constant);
}
