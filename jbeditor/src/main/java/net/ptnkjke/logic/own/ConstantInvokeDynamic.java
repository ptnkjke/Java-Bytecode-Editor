package net.ptnkjke.logic.own;


import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantInvokeDynamic extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantInvokeDynamic\\ +(\\d)+\\ +(\\d)+");

    private int bootstrap_method_attr_index;
    private int name_and_type_index;

    protected ConstantInvokeDynamic() {
        super(Constants.CONSTANT_InvokeDynamic);
    }

    public ConstantInvokeDynamic(DataInput file) throws IOException {
        this();
        this.bootstrap_method_attr_index = file.readUnsignedShort();
        this.name_and_type_index = file.readUnsignedShort();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeShort(this.bootstrap_method_attr_index);
        file.writeShort(this.name_and_type_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantInvokeDynamic " + bootstrap_method_attr_index + " " + name_and_type_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantInvokeDynamic cons = new ConstantInvokeDynamic();
        cons.bootstrap_method_attr_index = Integer.parseInt(matcher.group(1));
        cons.name_and_type_index = Integer.parseInt(matcher.group(2));
        return cons;
    }

    public int getBootstrap_method_attr_index() {
        return bootstrap_method_attr_index;
    }

    public void setBootstrap_method_attr_index(int bootstrap_method_attr_index) {
        this.bootstrap_method_attr_index = bootstrap_method_attr_index;
    }

    public int getName_and_type_index() {
        return name_and_type_index;
    }

    public void setName_and_type_index(int name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }
}
