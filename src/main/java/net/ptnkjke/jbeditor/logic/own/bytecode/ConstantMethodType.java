package net.ptnkjke.jbeditor.logic.own.bytecode;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantMethodType extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantMethodType\\ +(\\d)+");

    private int descriptor_index;

    protected ConstantMethodType() {
        super(Constants.CONSTANT_MethodType);
    }

    public ConstantMethodType(DataInput file) throws IOException {
        this();
        this.descriptor_index = file.readUnsignedShort();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeShort(descriptor_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantMethodType " + descriptor_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantMethodType cons = new ConstantMethodType();
        cons.descriptor_index = Integer.parseInt(matcher.group(1));
        return cons;
    }

    public int getDescriptorIndex() {
        return descriptor_index;
    }

    public void setDescriptorIndex(int descriptor_index) {
        this.descriptor_index = descriptor_index;
    }
}
