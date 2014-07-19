package net.ptnkjke.utils;

import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.ConstantPoolGen;

import java.util.regex.Pattern;

/**
 * Created by Lopatin on 19.07.2014.
 */
public class ConstantParser {
    public static ConstantPoolGen get(String text) {
        ConstantPoolGen cpg = new ConstantPoolGen();

        String[] lines = text.split("\n");

        for (String s : lines) {
            if (s.length() == 0) {
                continue;
            }

            if (s.contains("Utf8")) {
                String data = s.replaceAll("Utf8 ?: ?", "");
                ConstantUtf8 constantUtf8 = new ConstantUtf8(data);
                cpg.addConstant(constantUtf8, cpg);
            } else if (s.contains("Integer")) {
                String data = s.replaceAll("Integer ?: ?", "");
                int data_int = Integer.parseInt(data);
                ConstantInteger constantInteger = new ConstantInteger(data_int);
                cpg.addConstant(constantInteger, cpg);
            } else if (s.contains("Float")) {
                String data = s.replaceAll("Float ?: ?", "");
                int data_float = Integer.parseInt(data);
                ConstantFloat constantFloat = new ConstantFloat(data_float);
                cpg.addConstant(constantFloat, cpg);
            } else if (s.contains("Long")) {
                String data = s.replaceAll("Long ?: ?", "");
                Long data_long = Long.parseLong(data);
                ConstantLong constantLong = new ConstantLong(data_long);
                cpg.addConstant(constantLong, cpg);
            } else if (s.contains("Double")) {
                String data = s.replaceAll("Double ?: ?", "");
                Double data_double = Double.parseDouble(data);
                ConstantDouble constantDouble = new ConstantDouble(data_double);
                cpg.addConstant(constantDouble, cpg);
            } else if (s.contains("Class")) {
                String data = s.replaceAll("Class ?: ?", "");
                int t = Integer.parseInt(data);
                ConstantClass constantClass = new ConstantClass(t);
                cpg.addConstant(constantClass, cpg);
            } else if (s.contains("FieldRef")) {
                String data = s.replaceAll("FieldRef ?: ?", "");
                String[] sub = data.split(" ");
                ConstantFieldref constantFieldref = new ConstantFieldref(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
                cpg.addConstant(constantFieldref, cpg);
            } else if (s.contains("InterfaceMethodRef")) {
                String data = s.replaceAll("InterfaceMethodRef ?: ?", "");
                String[] sub = data.split(" ");
                ConstantInterfaceMethodref constantInterfaceMethodref = new ConstantInterfaceMethodref(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
                cpg.addConstant(constantInterfaceMethodref, cpg);
            } else if (s.contains("NameAndType")) {
                String data = s.replaceAll("NameAndType ?: ?", "");
                String[] sub = data.split(" ");
                ConstantNameAndType constantNameAndType = new ConstantNameAndType(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
                cpg.addConstant(constantNameAndType, cpg);
            } else if (s.contains("MethodHandle")) {
                String data = s.replaceAll("MethodHandle ?: ?", "");
                String[] sub = data.split(" ");
                ConstantMethodHandle constantMethodHandle = new ConstantMethodHandle(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
                cpg.addConstant(constantMethodHandle, cpg);
            } else if (s.contains("MethodType")) {
                String data = s.replaceAll("MethodType ?: ?", "");
                int t = Integer.parseInt(data);
                ConstantMethodType constantMethodType = new ConstantMethodType(t);
                cpg.addConstant(constantMethodType, cpg);
            } else if (s.contains("String")) {
                String data = s.replaceAll("String ?: ?", "");
                int t = Integer.parseInt(data);
                ConstantString cs = new ConstantString(t);
                cpg.addConstant(cs, cpg);
            } else {
                try {
                    throw new Exception("asd");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return cpg;
    }
}
