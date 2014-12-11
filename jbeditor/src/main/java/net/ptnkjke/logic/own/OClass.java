package net.ptnkjke.logic.own;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import net.ptnkjke.utils.Utils;

import java.io.*;

/**
 * Собственной представление кишочков класса ^_^
 */
public class OClass {
    /**
     * Представление ConstantPool
     */
    private ConstantPool constantPool;

    private byte[] original;  // Оригинальное содержимое класса
    private int major, minor; // Compiler version
    private byte[] lastPart; // Последняя часть с содержимым

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }


    public void readFromBytes(byte[] bytes) throws Exception {
        this.original = bytes;

        ByteInputStream bis = new ByteInputStream();
        bis.setBuf(this.original);
        DataInputStream file = new DataInputStream(bis);
        /****************** Read headers ********************************/
        // Check magic tag of class file
        readID(file);
        // Get compiler version
        readVersion(file);

        // Чтение ConstantPool
        readConstantPool(file);

        // Просто сохраняем всё в память
        this.lastPart = Utils.readAllFromInputStream(bis);

        file.close();
    }

    public void dump(File file) throws IOException {
        DataOutputStream f = null;
        try {
            f = new DataOutputStream(new FileOutputStream(file));

            f.writeInt(0xcafebabe);
            f.writeShort(minor);
            f.writeShort(major);
            constantPool.dump(f);
            f.write(lastPart);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }


    private void readID(DataInputStream file) throws Exception {
        int magic = 0xCAFEBABE;
        if (file.readInt() != magic) {
            throw new Exception(" is not a Java .class file");
        }
    }

    private void readVersion(DataInputStream file) throws IOException {
        this.minor = file.readUnsignedShort();
        this.major = file.readUnsignedShort();
    }

    private void readConstantPool(DataInputStream file) throws Exception {
        constantPool = new ConstantPool();
        constantPool.read(file);
    }

}
