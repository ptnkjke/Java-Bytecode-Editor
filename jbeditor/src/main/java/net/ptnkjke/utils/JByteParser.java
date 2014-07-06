package net.ptnkjke.utils;

import org.apache.bcel.generic.*;

import java.util.ArrayList;

/**
 * Created by Lopatin on 06.07.2014.
 */
public class JByteParser {
    InstructionList instructions = new InstructionList();
    ArrayList<InstructionHandle> instructionHandleList = new ArrayList<InstructionHandle>();

    public void parse(String code, ConstantPoolGen ccg) {
        InstructionList list;

        String[] lines = code.split("\n");


        for (int i = 0; i < lines.length; i++) {
            parseLine(lines[i]);
        }
    }


    private void parseLine(String code) {
        InstructionHandle instructionHandle = null;
        Instruction instruction = null;
        // ARITHMETIC
        switch (code) {
            case "dadd":
                instruction = new DADD();
                break;
            case "ddiv":
                instruction = new DDIV();
                break;
            case "dmul":
                instruction = new DMUL();
                break;
            case "dneg":
                instruction = new DNEG();
                break;
            case "drem":
                instruction = new DREM();
                break;
            case "dsub":
                instruction = new DSUB();
                break;
            case "fadd":
                instruction = new FADD();
                break;
            case "fdiv":
                instruction = new FDIV();
                break;
            case "fmul":
                instruction = new FMUL();
                break;
            case "fneg":
                instruction = new FNEG();
                break;
            case "frem":
                instruction = new FREM();
                break;
            case "fsub":
                instruction = new FSUB();
                break;
            case "iadd":
                instruction = new IADD();
                break;
            case "iand":
                instruction = new IAND();
                break;
            case "idiv":
                instruction = new IDIV();
                break;
            case "imul":
                instruction = new IMUL();
                break;
            case "ineg":
                instruction = new INEG();
                break;
            case "ior":
                instruction = new IOR();
                break;
            case "irem":
                instruction = new IREM();
                break;
            case "ishl":
                instruction = new ISHL();
                break;
            case "ishr":
                instruction = new ISHR();
                break;
            case "isub":
                instruction = new ISUB();
                break;
            case "iushr":
                instruction = new IUSHR();
                break;
            case "ixor":
                instruction = new IXOR();
                break;
            case "ladd":
                instruction = new LADD();
                break;
            case "land":
                instruction = new LAND();
                break;
            case "ldiv":
                instruction = new LDIV();
                break;
            case "lmul":
                instruction = new LMUL();
                break;
            case "lneg":
                instruction = new LNEG();
                break;
            case "lor":
                instruction = new LOR();
                break;
            case "lrem":
                instruction = new LREM();
                break;
            case "lshl":
                instruction = new LSHL();
                break;
            case "lshr":
                instruction = new LSHR();
                break;
            case "lsub":
                instruction = new LSUB();
                break;
            case "lushr":
                instruction = new LUSHR();
                break;
            case "lxor":
                instruction = new LXOR();
                break;
        }
        if (instruction != null) {
            instructionHandle = instructions.append(instruction);
            instructionHandleList.add(instructionHandle);
            return;
        }

        // ARRAYINSTRUCTION
        switch (code) {
            case "aaload":
                instruction = new AALOAD();
                break;
            case "aastore":
                instruction = new AASTORE();
                break;
            case "baload":
                instruction = new BALOAD();
                break;
            case "bastore":
                instruction = new BASTORE();
                break;
            case "caload":
                instruction = new CALOAD();
                break;
            case "castore":
                instruction = new CASTORE();
                break;
            case "daload":
                instruction = new DALOAD();
                break;
            case "dastore":
                instruction = new DASTORE();
                break;
            case "faload":
                instruction = new FALOAD();
                break;
            case "fastore":
                instruction = new FASTORE();
                break;
            case "iaload":
                instruction = new IALOAD();
                break;
            case "iastore":
                instruction = new IASTORE();
                break;
            case "laload":
                instruction = new LALOAD();
                break;
            case "lastore":
                instruction = new LASTORE();
                break;
            case "saload":
                instruction = new SALOAD();
                break;
            case "sastore":
                instruction = new SASTORE();
                break;
        }

        if (instruction != null) {
            instructionHandle = instructions.append(instruction);
            instructionHandleList.add(instructionHandle);
            return;
        }

        // BRANCHINSTRUCTION

        // CONVERSIONINTRUCTION

        // CPINSTRUCTION

        // LOCALVARIABLEINSTRUCTION

        // RETURNINSTRUCTION

        // STACKINSTRUCTION

        // OTHERINSTRUCTION
    }
}
