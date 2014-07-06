package net.ptnkjke.utils;

import org.apache.bcel.generic.*;

import java.util.ArrayList;

/**
 * Created by Lopatin on 06.07.2014.
 */
public class JByteParser {
    private InstructionList instructions = new InstructionList();
    private ArrayList<InstructionHandle> instructionHandleList = new ArrayList<InstructionHandle>();
    private ArrayList<BranchStruct> branchStructs = new ArrayList<>();

    public void parse(String code, ConstantPoolGen ccg) {
        InstructionList list;

        String[] lines = code.split("\n");


        for (int i = 0; i < lines.length; i++) {
            parseLine(lines, i);
        }

        // Обработка BranchStructs!
    }


    /**
     * Сколько строк обработано
     *
     * @return
     */
    private int parseLine(String[] lines, int numLine) {
        String instructionName = null;
        String[] args = null;
        InstructionHandle instructionHandle = null;
        Instruction instruction = null;
        // ARITHMETIC
        switch (instructionName) {
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
            return 1;
        }

        // ARRAYINSTRUCTION
        switch (instructionName) {
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
            return 1;
        }

        // BRANCHINSTRUCTION
        switch (instructionName) {
            case "goto":
                instruction = new GOTO(null);
                break;
            case "goto_w":
                instruction = new GOTO_W(null);
                break;
            case "if_acmpeq":
                instruction = new IF_ACMPEQ(null);
                break;
            case "if_acmne":
                instruction = new IF_ACMPNE(null);
                break;
            case "if_icmpeq":
                instruction = new IF_ICMPEQ(null);
                break;
            case "if_icmpge":
                instruction = new IF_ICMPGE(null);
                break;
            case "if_icmpgt":
                instruction = new IF_ICMPGT(null);
                break;
            case "if_icmple":
                instruction = new IF_ICMPLE(null);
                break;
            case "if_icmplt":
                instruction = new IF_ICMPLT(null);
                break;
            case "if_icmpne":
                instruction = new IF_ICMPNE(null);
                break;
            case "ifeq":
                instruction = new IFEQ(null);
                break;
            case "ifge":
                instruction = new IFGE(null);
                break;
            case "ifgt":
                instruction = new IFGT(null);
                break;
            case "ifle":
                instruction = new IFLE(null);
                break;
            case "iflt":
                instruction = new IFLT(null);
                break;
            case "ifne":
                instruction = new IFNE(null);
                break;
            case "ifnonnull":
                instruction = new IFNONNULL(null);
                break;
            case "ifnull":
                instruction = new IFNULL(null);
                break;
            case "jsr":
                instruction = new JSR(null);
                break;
            case "jsr_w":
                instruction = new JSR_W(null);
                break;
        }
        if (instruction != null) {
            instructionHandle = instructions.append(instruction);
            instructionHandleList.add(instructionHandle);

            branchStructs.add(new BranchStruct((BranchInstruction) instruction, Integer.parseInt(args[0])));
            return 1;
        }

        switch (instructionName) {
            case "tableswitch":
                //instruction = new TABLESWITCH(); // TODO: !!!!ALERT!!!!!
                break;
            case "lookupswitch":
                //instruction = new LOOKUPSWITCH() // TODO: !!!!ALERT!!!!!
                break;
        }


        // CONVERSIONINTRUCTION

        // CPINSTRUCTION

        // LOCALVARIABLEINSTRUCTION

        // RETURNINSTRUCTION

        // STACKINSTRUCTION

        // OTHERINSTRUCTION

        return 0;
    }

    private class BranchStruct {
        BranchInstruction instruction;
        int label;

        BranchStruct(BranchInstruction instruction, int label) {

        }
    }
}
