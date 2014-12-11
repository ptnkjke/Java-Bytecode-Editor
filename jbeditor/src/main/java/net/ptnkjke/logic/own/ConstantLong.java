package net.ptnkjke.logic.own;


import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantLong extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantLong\\ +(\\d)+");

    private long bytes;

    protected ConstantLong() {
        super(Constants.CONSTANT_Long);
    }

    public ConstantLong(DataInput file) throws IOException {
        this();
        this.bytes = file.readLong();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeLong(bytes);
    }

    @Override
    public String toLineCode() {
        return "ConstantLong " + bytes;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantLong cons = new ConstantLong();
        cons.bytes = Long.parseLong(matcher.group(1));
        return cons;
    }
}
