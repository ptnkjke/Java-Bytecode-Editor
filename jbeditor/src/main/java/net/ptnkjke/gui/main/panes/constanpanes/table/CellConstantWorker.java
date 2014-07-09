package net.ptnkjke.gui.main.panes.constanpanes.table;

import net.ptnkjke.utils.ConstanstWorker;
import org.apache.bcel.classfile.*;

/**
 * Created by Lopatin on 09.07.2014.
 */
public class CellConstantWorker extends ConstanstWorker {
    private ConstantTableCell constantTableCell;
    private ConstantPool cp;

    public CellConstantWorker(ConstantPool cp) {
        this.cp = cp;
    }

    public ConstantTableCell getConstantTableCell() {
        return constantTableCell;
    }

    @Override
    public void visitUtf8(ConstantUtf8 constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Utf8");
        constantTableCell.setValue(constant.getBytes());
    }

    @Override
    public void visitInteger(ConstantInteger constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Integer");
        constantTableCell.setValue(Integer.toString(constant.getBytes()));
    }

    @Override
    public void visitFloat(ConstantFloat constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Float");
        constantTableCell.setValue(Float.toString(constant.getBytes()));
    }

    @Override
    public void visitLong(ConstantLong constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Long");
        constantTableCell.setValue(Long.toString(constant.getBytes()));
    }

    @Override
    public void visitDouble(ConstantDouble constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Double");
        constantTableCell.setValue(Double.toString(constant.getBytes()));
    }


    @Override
    public void visitClass(ConstantClass constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Class");
        constantTableCell.setValue(constant.getBytes(cp));
    }

    @Override
    public void visitFieldRef(ConstantFieldref constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("Fieldref");
        constantTableCell.setValue(constant.getClass(cp));
    }

    @Override
    public void visitString(ConstantString constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("String");
        constantTableCell.setValue(constant.getBytes(cp));
    }

    @Override
    public void visitMethodref(ConstantMethodref constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("MethodRef");
        constantTableCell.setValue(constant.getClass(cp));
    }

    @Override
    public void visitInterfaceMethodRef(ConstantInterfaceMethodref constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("InterfaceMethodRef");
        constantTableCell.setValue(constant.getClass(cp));
    }

    @Override
    public void visitNameAndType(ConstantNameAndType constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("NameAndtype");
        constantTableCell.setValue(constant.getSignature(cp) + " " + constant.getSignature(cp));
    }

    @Override
    public void visitMethodHandle(ConstantMethodHandle constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("MethodHandle");
        constantTableCell.setValue(Integer.toString(constant.getReferenceIndex()));

    }

    @Override
    public void visitMethodType(ConstantMethodType constant) {
        constantTableCell = new ConstantTableCell();
        constantTableCell.setType("MethodType");
        constantTableCell.setValue(Integer.toString(constant.getDescriptorIndex()));
    }
}
