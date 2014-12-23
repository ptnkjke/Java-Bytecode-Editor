package net.ptnkjke.jbeditor.logic.own.bytecode;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantNameAndType extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantNameAndType\\ +(\\d)+\\ +(\\d)+");

    private int name_index; // Name of field/method
    private int signature_index; // and its signature.

    protected ConstantNameAndType() {
        super(Constants.CONSTANT_NameAndType);
    }

    public ConstantNameAndType(DataInput file) throws IOException {
        this();
        this.name_index = file.readUnsignedShort();
        this.signature_index = file.readUnsignedShort();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeShort(name_index);
        file.writeShort(signature_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantNameAndType " + name_index + " " + signature_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantNameAndType cons = new ConstantNameAndType();
        cons.name_index = Integer.parseInt(matcher.group(1));
        cons.signature_index = Integer.parseInt(matcher.group(2));
        return cons;
    }

    public int getNameIndex() {
        return name_index;
    }

    public void setNameIndex(int name_index) {
        this.name_index = name_index;
    }

    public int getSignatureIndex() {
        return signature_index;
    }

    public void setSignatureIndex(int signature_index) {
        this.signature_index = signature_index;
    }
}
