package net.ptnkjke.jbeditor.logic.own.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class AbstractConstant {
    protected byte tag;

    protected AbstractConstant(byte tag) {
        this.tag = tag;
    }

    public static AbstractConstant readConstant(DataInputStream file) throws Exception {
        byte b = file.readByte(); // Read tag byte
        switch (b) {
            case Constants.CONSTANT_Class:
                return new ConstantClass(file);
            case Constants.CONSTANT_Fieldref:
                return new ConstantFieldref(file);
            case Constants.CONSTANT_Methodref:
                return new ConstantMethodref(file);
            case Constants.CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodref(file);
            case Constants.CONSTANT_String:
                return new ConstantString(file);
            case Constants.CONSTANT_Integer:
                return new ConstantInteger(file);
            case Constants.CONSTANT_Float:
                return new ConstantFloat(file);
            case Constants.CONSTANT_Long:
                return new ConstantLong(file);
            case Constants.CONSTANT_Double:
                return new ConstantDouble(file);
            case Constants.CONSTANT_NameAndType:
                return new ConstantNameAndType(file);
            case Constants.CONSTANT_Utf8:
                return new ConstantUtf8(file);
            case Constants.CONSTANT_MethodHandle:
                return new ConstantMethodHandle(file);
            case Constants.CONSTANT_MethodType:
                return new ConstantMethodType(file);
            case Constants.CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamic(file);
            default:
                throw new Exception("Invalid byte tag in constant pool: " + b);
        }
    }

    public abstract void dump(DataOutputStream file) throws IOException;

    public abstract String toLineCode();

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }
}
