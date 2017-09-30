package net.ptnkjke.jbeditor.logic.own.bytecode;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantDouble extends AbstractConstant{
    private static final Pattern pattern = Pattern.compile("ConstantDouble\\ +(.?)+");
    private double bytes;

    protected ConstantDouble() {
        super(Constants.CONSTANT_Double);
    }

    public ConstantDouble(DataInput file) throws IOException {
        this();
        this.bytes = file.readDouble();
    }

    public double getBytes() {
        return bytes;
    }

    public void setBytes(double bytes) {
        this.bytes = bytes;
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeDouble(bytes);
    }

    @Override
    public String toLineCode() {
        return "ConstantDouble " + bytes;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantDouble cons = new ConstantDouble();
        cons.bytes = Double.parseDouble(matcher.group(1));

        return cons;
    }
}
