package net.ptnkjke.jbeditor.logic.own.bytecode;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantFloat extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantFloat\\ +(.?)+");

    private float bytes;

    protected ConstantFloat() {
        super(Constants.CONSTANT_Float);
    }

    public ConstantFloat(DataInput file) throws IOException {
        this();
        this.bytes = file.readFloat();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeDouble(bytes);
    }

    @Override
    public String toLineCode() {
        return "ConstantFloat " + bytes;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantFloat cons = new ConstantFloat();
        cons.bytes = Float.parseFloat(matcher.group(1));
        return cons;
    }

    public float getBytes() {
        return bytes;
    }

    public void setBytes(float bytes) {
        this.bytes = bytes;
    }
}
