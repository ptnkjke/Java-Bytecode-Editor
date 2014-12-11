package net.ptnkjke.logic.own;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantClass extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantClass\\ +(\\d)+");
    private int name_index;

    protected ConstantClass() {
        super(Constants.CONSTANT_Class);
    }

    public ConstantClass(DataInput file) throws IOException {
        this();
        name_index = file.readUnsignedShort();
    }

    public int getNameIndex() {
        return name_index;
    }

    public void setNameIndex(int name_index) {
        this.name_index = name_index;
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeShort(name_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantClass " + name_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantClass cons = new ConstantClass();
        cons.name_index = Integer.parseInt(matcher.group(1));

        return cons;
    }
}
