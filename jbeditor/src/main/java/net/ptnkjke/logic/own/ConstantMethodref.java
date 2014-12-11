package net.ptnkjke.logic.own;

import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantMethodref extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantMethodref\\ +(\\d)+\\ +(\\d)+");

    private int class_index;
    private int name_and_type_index;


    protected ConstantMethodref() {
        super(Constants.CONSTANT_Methodref);
    }

    public ConstantMethodref(DataInput file) throws IOException {
        this();
        this.class_index = file.readUnsignedShort();
        this.name_and_type_index = file.readUnsignedShort();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeShort(class_index);
        file.writeShort(name_and_type_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantMethodref " + class_index + " " + name_and_type_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantMethodref cons = new ConstantMethodref();
        cons.class_index = Integer.parseInt(matcher.group(1));
        cons.name_and_type_index = Integer.parseInt(matcher.group(2));
        return cons;
    }

    public int getClass_index() {
        return class_index;
    }

    public void setClass_index(int class_index) {
        this.class_index = class_index;
    }

    public int getName_and_type_index() {
        return name_and_type_index;
    }

    public void setName_and_type_index(int name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }
}
