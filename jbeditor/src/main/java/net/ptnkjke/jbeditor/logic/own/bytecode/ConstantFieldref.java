package net.ptnkjke.jbeditor.logic.own.bytecode;


import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantFieldref extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantFieldref\\ +(\\d+)+\\ (\\d+)+");
    private int class_index;
    private int name_and_type_index;

    protected ConstantFieldref() {
        super(Constants.CONSTANT_Fieldref);
    }

    public ConstantFieldref(DataInput file) throws IOException {
        this();
        this.class_index = file.readUnsignedShort();
        this.name_and_type_index = file.readUnsignedShort();
    }

    public int getClassIndex() {
        return class_index;
    }

    public void setClassIndex(int class_index) {
        this.class_index = class_index;
    }

    public int getNameAndTypeIndex() {
        return name_and_type_index;
    }

    public void setNameAndTypeIndex(int name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeShort(class_index);
        file.writeShort(name_and_type_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantFieldref " + class_index + " " + name_and_type_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantFieldref cons = new ConstantFieldref();
        cons.class_index = Integer.parseInt(matcher.group(1));
        cons.name_and_type_index = Integer.parseInt(matcher.group(2));

        return cons;
    }
}
