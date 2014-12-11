package net.ptnkjke.logic.own;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantString extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantString\\ +(\\d)+");

    private int string_index; // Identical to ConstantClass except for this name

    protected ConstantString() {
        super(Constants.CONSTANT_String);
    }

    public ConstantString(DataInput file) throws IOException {
        this();
        this.string_index = file.readUnsignedShort();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
    }

    @Override
    public String toLineCode() {
        return "ConstantString " + this.string_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantString cons = new ConstantString();
        cons.string_index = Integer.parseInt(matcher.group(1));
        return cons;
    }

    public int getString_index() {
        return string_index;
    }

    public void setString_index(int string_index) {
        this.string_index = string_index;
    }
}
