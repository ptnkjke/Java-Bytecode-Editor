package net.ptnkjke.jbeditor.logic.own.bytecode;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Представление Констант-Пула класса
 */
public class ConstantPool {

    private Map<Integer, AbstractConstant> constant_pool = new HashMap<Integer, AbstractConstant>();

    public int getConstantPoolSize() {
        int counter = 1;

        byte tag;
        for (Map.Entry<Integer, AbstractConstant> e : constant_pool.entrySet()) {
            tag = e.getValue().getTag();

            if (tag == Constants.CONSTANT_Double || tag == Constants.CONSTANT_Long) {
                counter++;
            }

            counter++;
        }

        return counter;
    }

    public void read(DataInputStream file) throws Exception {
        byte tag;

        int constant_pool_count = file.readUnsignedShort();
        for (int i = 1; i < constant_pool_count; i++) {
            AbstractConstant constant = AbstractConstant.readConstant(file);

            tag = constant.getTag();
            if (tag == Constants.CONSTANT_Double || tag == Constants.CONSTANT_Long) {
                i++;
            }

            constant_pool.put(i, constant);
        }
    }

    public void dump(DataOutputStream file) throws IOException {
        file.writeShort(getConstantPoolSize());

        for (Map.Entry<Integer, AbstractConstant> e : constant_pool.entrySet()) {
            e.getValue().dump(file);
        }
    }

    public static String getConstantPoolCode(ConstantPool cp) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, AbstractConstant> e : cp.constant_pool.entrySet()) {
            sb.append(e.getKey() + ": " + e.getValue().toLineCode() + "\n");
        }

        return sb.toString();
    }

    public static ConstantPool parseCode(String code) {
        ConstantPool cp = new ConstantPool();

        List<String> lines = new ArrayList<String>();
        for (String line : lines) {
            AbstractConstant constant = null;
            String[] subs = line.split(":");
            String l = subs[1];
            Integer number = Integer.parseInt(subs[0]);
            constant = ConstantClass.parseLine(l);
            if (constant != null) {
                constant = ConstantDouble.parseLine(l);
            } else if (constant != null) {
                constant = ConstantFieldref.parseLine(l);
            } else if (constant != null) {
                constant = ConstantFloat.parseLine(l);
            } else if (constant != null) {
                constant = ConstantInteger.parseLine(l);
            } else if (constant != null) {
                constant = ConstantInterfaceMethodref.parseLine(l);
            } else if (constant != null) {
                constant = ConstantInvokeDynamic.parseLine(l);
            } else if (constant != null) {
                constant = ConstantLong.parseLine(l);
            } else if (constant != null) {
                constant = ConstantMethodHandle.parseLine(l);
            } else if (constant != null) {
                constant = ConstantMethodref.parseLine(l);
            } else if (constant != null) {
                constant = ConstantMethodType.parseLine(l);
            } else if (constant != null) {
                constant = ConstantNameAndType.parseLine(l);
            } else if (constant != null) {
                constant = ConstantString.parseLine(l);
            } else if (constant != null) {
                constant = ConstantUtf8.parseLine(l);
            } else if (constant != null) {
                try {
                    throw new Exception("nooooo");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            cp.constant_pool.put(number, constant);
        }

        return cp;
    }
}
