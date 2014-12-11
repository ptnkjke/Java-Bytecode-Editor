package net.ptnkjke.logic.own;


import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConstantMethodHandle extends AbstractConstant {
    private static final Pattern pattern = Pattern.compile("ConstantMethodHandle\\ +(\\d)+\\ +(\\d)+");

    private int reference_kind;
    private int reference_index;

    protected ConstantMethodHandle() {
        super(Constants.CONSTANT_MethodHandle);
    }

    public ConstantMethodHandle(DataInput file) throws IOException {
        this();
        this.reference_kind = file.readUnsignedByte();
        this.reference_index = file.readUnsignedShort();
    }

    @Override
    public void dump(DataOutputStream file) throws IOException {
        file.writeByte(tag);
        file.writeByte(reference_kind);
        file.writeShort(reference_index);
    }

    @Override
    public String toLineCode() {
        return "ConstantMethodHandle " + reference_kind + " " + reference_index;
    }

    public static AbstractConstant parseLine(String lineCode) {
        Matcher matcher = pattern.matcher(lineCode);
        if (!matcher.find()) {
            return null;
        }

        ConstantMethodHandle cons = new ConstantMethodHandle();
        cons.reference_kind = Integer.parseInt(matcher.group(1));
        cons.reference_index = Integer.parseInt(matcher.group(2));
        return cons;
    }

    public int getReference_kind() {
        return reference_kind;
    }

    public void setReference_kind(int reference_kind) {
        this.reference_kind = reference_kind;
    }

    public int getReference_index() {
        return reference_index;
    }

    public void setReference_index(int reference_index) {
        this.reference_index = reference_index;
    }
}
