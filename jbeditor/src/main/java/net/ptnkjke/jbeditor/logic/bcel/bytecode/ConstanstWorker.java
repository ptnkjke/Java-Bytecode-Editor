package net.ptnkjke.jbeditor.logic.bcel.bytecode;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.*;

/**
 * Created by Lopatin on 09.07.2014.
 */
public abstract class ConstanstWorker {

    public void visit(Constant constant) throws Exception {
        switch (constant.getTag()) {
            case Constants.CONSTANT_Utf8:
                visitUtf8((ConstantUtf8) constant);
                break;
            case Constants.CONSTANT_Integer:
                visitInteger((ConstantInteger) constant);
                break;
            case Constants.CONSTANT_Float:
                visitFloat((ConstantFloat) constant);
                break;
            case Constants.CONSTANT_Long:
                visitLong((ConstantLong) constant);
                break;
            case Constants.CONSTANT_Double:
                visitDouble((ConstantDouble) constant);
                break;
            case Constants.CONSTANT_Class:
                visitClass((ConstantClass) constant);
                break;
            case Constants.CONSTANT_Fieldref:
                visitFieldRef((ConstantFieldref) constant);
                break;
            case Constants.CONSTANT_String:
                visitString((ConstantString) constant);
                break;
            case Constants.CONSTANT_Methodref:
                visitMethodref((ConstantMethodref) constant);
                break;
            case Constants.CONSTANT_InterfaceMethodref:
                visitInterfaceMethodRef((ConstantInterfaceMethodref) constant);
                break;
            case Constants.CONSTANT_NameAndType:
                visitNameAndType((ConstantNameAndType) constant);
                break;
/*            case Constants.CONSTANT_MethodHandle:
                visitMethodHandle((ConstantMethodHandle) constant);
                break;
            case Constants.CONSTANT_MethodType:
                visitMethodType((ConstantMethodType) constant);
                break;*/
            default:
                try {
                    throw new Exception("");
                }catch (Exception e){
                    e.toString();
                }
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
