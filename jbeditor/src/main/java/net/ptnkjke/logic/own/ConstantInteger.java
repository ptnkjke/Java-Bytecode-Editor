package net.ptnkjke.logic.own;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantInteger extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantInteger\\ +(\\d)+");

    private int bytes;

    protected ConstantInteger() {
        super(Constants.CONSTANT_Integer);
    }

    public ConstantInteger(DataInput file) throws IOException {
        this();
        this.bytes = file.readInt();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeInt(bytes);
    }

    @Override
    public String toLineCode() {
        return "ConstantInteger" + bytes;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantInteger cons = new ConstantInteger();
        cons.bytes = Integer.parseInt(matcher.group(1));
        return cons;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
