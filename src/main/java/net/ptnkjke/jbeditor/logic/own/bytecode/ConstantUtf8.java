package net.ptnkjke.jbeditor.logic.own.bytecode;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantUtf8 extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantUtf8\\ +(.?)+");

    private String bytes;

    protected ConstantUtf8() {
        super(Constants.CONSTANT_Utf8);
    }

    public ConstantUtf8(DataInput file) throws IOException {
        this();
        bytes = file.readUTF();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeUTF(bytes);
    }

    @Override
    public String toLineCode() {
        return "ConstantUtf8 " + bytes;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantUtf8 cons = new ConstantUtf8();
        cons.bytes = matcher.group(1);

        return cons;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }
}
